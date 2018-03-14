package com.yexuejc.util.ytest.hscf.api.staff;

import com.yexuejc.util.ytest.hscf.api.core.BaseHscfTest;
import com.yexuejc.util.ytest.hscf.api.utils.HeaderUtil;
import com.yexuejc.util.ytest.hscf.api.utils.Reqst;
import org.junit.Test;


/**
 *  慧商车服-移动端-staffApi
 * @author yexue
 * @expl
 * @time 2017年8月24日 上午11:45:40
 */
public class VersionTest extends BaseHscfTest {
	
	enum URI {
		CUR_VER("/curVer")//获取当前版本
		
		;

		public String NAME;

		URI(String name) {
			this.NAME = verPath+name;
		}
	}
	
	/**
	 * 获取当前版本
	 */
	@Test
	public void curVer() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff());
		toReqst(URI.CUR_VER.NAME, reqst);
	}

}
