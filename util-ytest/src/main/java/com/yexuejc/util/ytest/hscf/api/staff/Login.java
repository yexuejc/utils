package com.yexuejc.util.ytest.hscf.api.staff;

import com.yexuejc.util.ytest.hscf.api.core.BaseHscfTest;
import com.yexuejc.util.ytest.hscf.api.model.LoginModel;
import com.yexuejc.util.ytest.hscf.api.utils.Reqst;
import com.yexuejc.util.ytest.hscf.api.utils.Resps;
import com.yexuejc.util.ytest.http.Https;
import org.junit.Test;

import com.google.gson.Gson;

public class Login extends BaseHscfTest {
	/**通过login()获取*/
	public static String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJqdGkiOiI1Y2M2OTJhNDE1NjQ0MzA5OWJhNzQ4ZjNjMTgyN2QwMCIsImlhdCI6MTUwODkyMDgzOSwiaXNzIjoiaHNjaGVmdS5jb20iLCJzdWIiOiJ7XCJ1c2VybmFtZVwiOlwiMTM4OTAzNDAwNjJcIn0ifQ.6FlWtYOiVmsU_49g6agnUITSECwlZJl3zCltUU19Ex1V6gEUfwVcvw-ZGvAcSA5lgL3R3jyCiER_TODOy6YtuQ";
	
	/**
	 * 获取当前版本
	 */
	@Test
	public void login() {
		Reqst reqst = new Reqst();
		//reqst.setHeader(HeaderUtil.getAndroidStaff());
		LoginModel loginModel = new LoginModel();
		loginModel.setUsername("13709002408");
		loginModel.setPassword("123456");
		reqst.setData(loginModel);
		Https.requestPostToVersion(rootStaffPath+"/login",reqst, new Https.Callback() {

			@Override
			public void success(String result) {
				System.out.println("登录成功！返回结果》》》》》》》》》》》》》");
				System.out.println(result);
				Resps resps = new Gson().fromJson(result, Resps.class);
				Login.token = (String) resps.getData();
			}

			@Override
			public void error(int errCode, String errMsg) {
				System.out.println("请求失败！");
				System.out.println(errCode + ":" + errMsg);
			}
		}, true);
	}

}
