package com.yexuejc.util.ytest.hscf.api.staff;

import com.yexuejc.util.ytest.hscf.api.core.BaseHscfTest;
import com.yexuejc.util.ytest.hscf.api.utils.HeaderUtil;
import com.yexuejc.util.ytest.hscf.api.utils.Reqst;
import org.junit.Test;



public class DictCarTest extends BaseHscfTest {

	enum URI {
		GET_CAR_DETAIL("/dictcar/getCarDetail")// 根据车id获取车辆详细名称
		
		;
		
		
		public String NAME;

		URI(String url) {
			this.NAME = rootStaffPath+url;
		}
	}

	/**
	 * 根据车id获取车辆详细名称
	 * 测试通过
	 */
	@Test
	public void getCarDetail() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		reqst.setData("00397bd9a74c4c2d900e3ba7a0706120");
		toReqst(URI.GET_CAR_DETAIL.NAME, reqst);
	}

}
