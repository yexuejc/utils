package com.yexuejc.util.ytest.hscf.api.shop;

import com.yexuejc.util.ytest.hscf.api.core.BaseHscfTest;
import com.yexuejc.util.ytest.hscf.api.model.FeedbackModel;
import com.yexuejc.util.ytest.hscf.api.model.LoginModel;
import com.yexuejc.util.ytest.hscf.api.model.MyTalkBuyModel;
import com.yexuejc.util.ytest.hscf.api.model.Pager;
import com.yexuejc.util.ytest.hscf.api.utils.HeaderUtil;
import com.yexuejc.util.ytest.hscf.api.utils.Reqst;
import org.junit.Test;


public class LoginTest extends BaseHscfTest {
	enum URI {
		SMS_CODE("/smsCode"),//咨询分页查询
		;

		public String NAME;

		URI(String name) {
			this.NAME = smsPath+name;
		}
	}
	/**
	 * 咨询分页查询
	 */
	@Test
	public void smsCode() {
		Reqst reqst = new Reqst();
		reqst.setData("18202837563");
		toReqst(URI.SMS_CODE.NAME,reqst);
	}
	
	
	@Test
	public void login() {
		Reqst reqst = new Reqst();
		LoginModel loginModel = new LoginModel();
		loginModel.setUsername("18202837563");
		loginModel.setSessionid("0xRprHsikhv8MbPxJ897OZ");
		loginModel.setPasscode("750373");
		reqst.setData(loginModel);
		toReqst(rootShopPath+"/login",reqst);
	}
	public static final String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJiNzZkZTEzN2Y3MmY0NjlmOWQ2MDU3ZTc1MzRkZDBkMSIsImlhdCI6MTUwNTExOTYzMywiaXNzIjoiaHNjaGVmdS5jb20iLCJzdWIiOiJ7XCJ1c2VybmFtZVwiOlwiMTgyMDI4Mzc1NjNcIn0ifQ.X_sZMEaKJPsVS2vN7P6jwOPr7HrhQ5DbovE_wLgP6KNQN816rtf1CeJIo_vAjzpkf8NxOohT-e4yrpDlQ6yWzA";
	
	/**
	 * 砍价记录
	 */
	@Test
	public void talkbuy() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(token));
		MyTalkBuyModel model = new MyTalkBuyModel();
		Pager pager = new Pager();
		model.setPager(pager);
		model.setOrderType(0);
		reqst.setData(model);
		toReqst(rootShopPath+"/user/talkbuy",reqst);
	}
	/**
	 * 删除砍价记录
	 */
	@Test
	public void delTalkbuy() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(token));
		reqst.setData(new String[]{"3","4"});
		toReqst(rootShopPath+"/user/delTalkbuy",reqst);
	}
	/**
	 * 反馈
	 */
	@Test
	public void feedback() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(token));
		FeedbackModel feedbackModel = new FeedbackModel();
		//feedbackModel.setCi("");
		feedbackModel.setContent("amsdfsdfsdfds");
		reqst.setData(feedbackModel);
		toReqst(rootShopPath+"/feedback/feedback",reqst);
	}
	@Test
	public void logout() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(token));
		toReqst(rootShopPath+"/logout",reqst);
	}
}
