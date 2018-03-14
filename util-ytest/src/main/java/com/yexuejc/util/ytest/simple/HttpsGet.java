package com.yexuejc.util.ytest.simple;

import org.junit.Test;
import com.yexuejc.util.ytest.http.Https;
import com.yexuejc.util.ytest.utils.HttpsValues;


public class HttpsGet {

	/**
	 * get请求
	 * 使用方法同post
	 */
	@Test
	public void getImages() {
		Https.requestGet(HttpsValues.GET_IMAGE_URLD, null, new Https.Callback() {

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
