package com.yexuejc.util.ytest.hscf.api.staff;

import com.yexuejc.util.ytest.hscf.api.core.BaseHscfTest;
import com.yexuejc.util.ytest.hscf.api.utils.HeaderUtil;
import com.yexuejc.util.ytest.hscf.api.utils.Reqst;
import org.junit.Test;


public class EeTest extends BaseHscfTest {
	
	@Test
	public void eeinfo() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		reqst.setData("a905dd283565ed208f00213b1133a21e");
		toReqst(rootStaffPath + "/ee/eeInfo", reqst);
	}

	/**
	 * 首页查询某个员工的统计数据
	 */
	@Test
	public void statistics() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		toReqst(rootStaffPath + "/ee/statistics", reqst);
	}
	/**
	 * 我的车辆统计数据
	 */
	@Test
	public void statistics2() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		toReqst(rootStaffPath + "/ee/statistics2", reqst);
	}

}
