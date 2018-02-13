package com.yexuejc.util.ytest.hscf.api.shop;

import com.yexuejc.util.ytest.hscf.api.core.BaseHscfTest;
import com.yexuejc.util.ytest.hscf.api.utils.Reqst;
import org.junit.Test;


/**
 * 慧商车服-移动端-shopApi
 * 
 * @author yexue
 * @expl
 * @time 2017年8月23日 下午5:30:23
 */
public class AdTest extends BaseHscfTest {
	enum URI {
		GE_TAD("/getAd")
		
		;

		public String NAME;

		URI(String name) {
			this.NAME = adPath+name;
		}
	}

	/**
	 * 获取广告
	 */
	@Test
	public void getAd() {
		Reqst reqst = new Reqst();
		reqst.setData("A");
		toReqst(URI.GE_TAD.NAME, reqst);
	}
}
