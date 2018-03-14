package com.yexuejc.util.example.small;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StrP {
	/**
     * 字符串转换方法 把字节数组转换成16进制字符串
     *
     * @param buf 初始字节数组
     * @return 转换后字符串
     */
    public static String toHex(byte buf[]) {
        StringBuffer strbuf = new StringBuffer(buf.length * 2);
        int i;
        for (i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10) {
                strbuf.append("0");
            }
            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }
        return strbuf.toString();
    }
	 /**
     * 获取字符串的MD5码
     *
     * @param str
     * @return
     */
    public static String toMD5(String str) {
        if (str == null) {
            return null;
        }
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        md.update(str.getBytes());
        byte tmp[] = md.digest();
        return toHex(tmp);
    }

    public static String getSmsSign(String mobile) {
        String str = mobile + "lg_fishing";
        str = toMD5(str).toLowerCase();
        System.out.println(">>>>>>>>>>>"+str);
        String firstChar = str.substring(0,1);
        System.out.println("firstChar>>>>>>>>>>>"+firstChar);
        String tmp = str.substring(1,str.length()-1);
        System.out.println("tmp>>>>>>>>>>>"+tmp);
        String lastChar = str.substring(str.length()-1,str.length());
        System.out.println("lastChar>>>>>>>>>>>"+lastChar);
        return lastChar+tmp+firstChar;
    }
	public static void main(String[] args) {
		String string = getSmsSign("13512345678lg_fishing");
		System.out.println(string);
	}

}
