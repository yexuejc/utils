package com.yexuejc.util.ytest.hscf.api.staff;

import com.yexuejc.util.ytest.hscf.api.core.BaseHscfTest;
import com.yexuejc.util.ytest.hscf.api.utils.HeaderUtil;
import com.yexuejc.util.ytest.hscf.api.utils.Reqst;
import org.junit.Test;

/**
 * 根据车架号查询车型
 * @author yexue
 * @expl
 * @time 2017年10月11日 下午5:15:14
 */
public class CarDetailQuery extends BaseHscfTest {
	enum URI {
		QUERY("/carDetailQuery/query");//根据车架号查询车型

		public String NAME;

		URI(String name) {
			this.NAME = rootStaffPath + name;
		}
	}

	/**
	 * 根据车架号查询车型
	 */
	@Test
	public void carDetailQuery() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		reqst.setData("LFV2A21KXE4176550");
		toReqst(URI.QUERY.NAME, reqst);
	}

}
