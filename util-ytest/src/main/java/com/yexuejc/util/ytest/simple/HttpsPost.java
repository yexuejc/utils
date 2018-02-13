package com.yexuejc.util.ytest.simple;

import com.yexuejc.util.ytest.http.HttpClientUtil;
import com.yexuejc.util.ytest.http.Https;
import com.yexuejc.util.ytest.utils.HttpsValues;
import com.yexuejc.util.ytest.utils.SignSecretKeyValues;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class HttpsPost {
	private String charset = "utf-8";
	private HttpClientUtil httpClientUtil = null;
	{
		httpClientUtil = new HttpClientUtil();
	}

	/**
	 * 自定义post请求
	 */
	 @Test
	 public void getImages1() {
	 // GET_IMAGE_URLD
	 String result = httpClientUtil.doPost(HttpsValues.GET_IMAGE_URLD, new HashMap<>(),
	 charset);
	 System.out.println(result);
	 }

	/**
	 * 普通post请求
	 */
	@Test
	public void getImages() {
		Https.requestPost(HttpsValues.GET_IMAGE_URLD, new HashMap<>(), new Https.Callback() {

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

	
	/**
	 * 加密post请求
	 * 
	 */
	@Test
	public void getMember() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", "8a7cf8dd4d22cbc6014d277f582f0f22");
		params.put("isSign", true);
		Https.requestPost2Sign(HttpsValues.URL_GET_USER_INFO, params, SignSecretKeyValues.MEMBER_MEMBER,
				new Https.Callback() {

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
				}, true);
	}

}
