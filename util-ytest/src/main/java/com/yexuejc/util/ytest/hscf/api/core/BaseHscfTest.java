package com.yexuejc.util.ytest.hscf.api.core;


import com.yexuejc.util.ytest.hscf.api.utils.Reqst;
import com.yexuejc.util.ytest.http.Https;

public class BaseHscfTest {
	
	protected static final String rootShopPath = "http://localhost:9100";
//	protected static final String rootShopPath = "http://ivt2.hschefu.com:9100";
	protected static final String rootStaffPath = "http://ivt2.hschefu.com:9200";
//	protected static final String rootStaffPath = "http://localhost:9200";
	/**广告*/
	protected static final String adPath = rootShopPath+"/ad";
	/**咨询*/
	protected static final String articlePAth = rootShopPath+"/article";
	
	/**咨询*/
	protected static final String verPath = rootStaffPath+"/ver";
	/**通知消息接口*/
	protected static final String msgPath = rootStaffPath+"/msg";
	protected static final String smsPath = rootShopPath+"/sms";
	
	
	
	
	
	
	protected void toReqst(String url,Reqst reqst) {
		Https.requestPostToVersion(url,reqst, new Https.Callback() {

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
