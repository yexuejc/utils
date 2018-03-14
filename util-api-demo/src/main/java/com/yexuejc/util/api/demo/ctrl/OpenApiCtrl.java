package com.yexuejc.util.api.demo.ctrl;

import com.yexuejc.util.api.demo.common.RSA;
import com.yexuejc.util.api.demo.util.FormatUtils;
import com.yexuejc.util.base.http.Resps;
import com.yexuejc.util.base.util.JsonUtil;
import com.yexuejc.util.base.util.JwtUtil;
import com.yexuejc.util.base.util.StrUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import static com.yexuejc.util.api.demo.common.RSA.getPublicKey;

/**
 * 针对开放接口openapi的解决方案：
 * 1.防泄漏：敏感信息RSA非对称加密（如密码）
 * 2.防篡改：参数MD5 签名
 * 3.防重复请求：时间戳
 * 4.token授权
 */
@RestController
@RequestMapping("/openapi")
public class OpenApiCtrl {
    //私钥
    public static final String privateKey = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAiSo5blJ9-QJ0_QElcy5AaRTq-3oO4lJ8PvIOIt-Xr5SUFODVj3DUbiy6_0bxQYO3NiYHlXPb37UVV3jjlXJsXwIDAQABAkBE0WOJH2hGs93gRl_0vwLf9ffDfkTTdlER_73p70aad3QZRslEkinQH7G5aE_DgBm5m72TCeH-PD2FZ2lwtavBAiEAvnRown5Lpqbl0tN_OUxr_e1u9d_-8dNL_JEETO7BZCECIQC4XtY-18j0bVVLxaXPjKQ00D59yntwObihDNyRK0nAfwIgHPHEGgrnpGQo-Wl7JFIg925mNqfcLxRVsAS6CpcefQECIQCUsLdsmy6QIhTmNRJSXoSXq1KatE_05DhIekzwLs8eFQIgfMawMiu52ZxBI5_pZ7ancQZ6Dsxl45utFqJShzV1pio";
    //公钥
    public static final String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIkqOW5SffkCdP0BJXMuQGkU6vt6DuJSfD7yDiLfl6-UlBTg1Y9w1G4suv9G8UGDtzYmB5Vz29-1FVd445VybF8CAwEAAQ";

    /**
     * @param account   账号
     * @param password  密码
     * @param sign      md5签名
     * @param timestamp 时间戳
     * @return
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping("/login")
    public Object login(String account, String password, String sign, Long timestamp) throws InvalidKeySpecException, NoSuchAlgorithmException {
        System.out.println("=======================================================");
        //时间戳在当前时间前一分钟内有效
        if (timestamp == null || timestamp > System.currentTimeMillis() || timestamp < System.currentTimeMillis() - 1000 * 60) {
            return "请求过期";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("account", account);
        map.put("password", password);
        map.put("timestamp", timestamp);
        String ensign = StrUtil.getSignContent(map);
        System.out.println("参数：" + ensign);
        System.out.println("MD5:" + StrUtil.toMD5(ensign));
        if (!StrUtil.toMD5(ensign).equals(sign)) {
            return "签名错误";
        }

        String privateDecryptPassword = RSA.privateDecrypt(password, RSA.getPrivateKey(privateKey));
        System.out.println("明文密码：" + privateDecryptPassword);
        if (!"123456".equals(privateDecryptPassword)) {
            return "密码错误";
        }
        //生成token 缓存 redis
        String token = JwtUtil.compact(account);
        return Resps.success().setSucc(token);
    }


    public static void main(String[] args) throws Exception {
//        testRSA();
        testMd5();
        long timestamp = System.currentTimeMillis();
        System.out.printf(String.valueOf(String.valueOf(timestamp).length()));
    }

    private static void testRSA() throws Exception {
        //        Map<String, String> mapKey = RSA.initKeys(512);
//        System.out.println(FormatUtils.formatJSON(JsonUtil.obj2Json(mapKey)));

        String data = "123456";
        //私钥加密，公钥解密
        String encryptData = RSA.privateEncrypt(data, RSA.getPrivateKey(privateKey));
        String decryptData = RSA.publicDecrypt(encryptData, RSA.getPublicKey(publicKey));
        System.out.println("密文：" + encryptData);
        System.out.println("解密：" + decryptData);

        //公钥加密，私钥解密
        String publicEncryptData = RSA.publicEncrypt(data, RSA.getPublicKey(publicKey));
        String privateDecryptData = RSA.privateDecrypt(publicEncryptData, RSA.getPrivateKey(privateKey));
        System.out.println("密文：" + publicEncryptData);
        System.out.println("解密：" + privateDecryptData);
    }

    private static void testMd5() {
        Map<String, Object> map = new HashMap<>();
        map.put("account", "13512345678");
        map.put("password", "123456");
        String params = StrUtil.getSignContent(map);
        System.out.println(params);
        System.out.println("sign=" + StrUtil.toMD5(params));
    }
}
