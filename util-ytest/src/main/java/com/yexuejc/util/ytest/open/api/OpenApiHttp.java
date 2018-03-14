package com.yexuejc.util.ytest.open.api;

import com.yexuejc.util.base.util.StrUtil;
import com.yexuejc.util.ytest.gzutil.RSA;
import com.yexuejc.util.ytest.http.Https;
import com.yexuejc.util.ytest.simple.HttpsPost;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

public class OpenApiHttp extends HttpsPost {
    //公钥
    public static final String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIkqOW5SffkCdP0BJXMuQGkU6vt6DuJSfD7yDiLfl6-UlBTg1Y9w1G4suv9G8UGDtzYmB5Vz29-1FVd445VybF8CAwEAAQ";

    /**
     * 普通post请求
     */
    @Test
    public void getLogin() throws Exception {
        Map params = new HashMap<>();
        params.put("password", RSA.publicEncrypt("123456", RSA.getPublicKey(publicKey)));
        params.put("account", "13512345678");
        String ensign = StrUtil.getSignContent(params);
        System.out.println(ensign);
        params.put("sign", StrUtil.toMD5(ensign));
        //篡改
//        params.put("account", "13512345673");

        Https.requestPost("http://192.168.0.204:8706/openapi/login", params, new Https.Callback() {

            @Override
            public void success(String result) {
                System.out.println("请求成功！返回结果》》》》》》》》》》》》》");
                System.out.println(result);
            }

            @Override
            public void error(int errCode, String errMsg) {
                System.out.println("请求失败！");
                System.out.println(errCode + ":" + errMsg);
            }
        }, false);
    }

}
