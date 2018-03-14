package com.yexuejc.util.ytest.hscf.api.staff;

import com.yexuejc.util.ytest.hscf.api.core.BaseHscfTest;
import com.yexuejc.util.ytest.hscf.api.model.Pager;
import com.yexuejc.util.ytest.hscf.api.utils.HeaderUtil;
import com.yexuejc.util.ytest.hscf.api.utils.Reqst;
import org.junit.Test;

public class MsgTest extends BaseHscfTest {
	enum URI {
		MSG_LIST("/msgList")// 获取与我相关的通知消息接口

		;

		public String NAME;

		URI(String name) {
			this.NAME = msgPath + name;
		}
	}

	/**
	 * 获取与我相关的通知消息接口
	 */
	@Test
	public void msgList() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		Pager pager = new Pager();
		reqst.setData(pager);
		toReqst(URI.MSG_LIST.NAME, reqst);
	}
}
