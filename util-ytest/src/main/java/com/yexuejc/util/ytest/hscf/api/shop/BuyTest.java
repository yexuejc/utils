package com.yexuejc.util.ytest.hscf.api.shop;

import com.yexuejc.util.ytest.hscf.api.core.BaseHscfTest;
import com.yexuejc.util.ytest.hscf.api.model.BuyModel;
import com.yexuejc.util.ytest.hscf.api.utils.HeaderUtil;
import com.yexuejc.util.ytest.hscf.api.utils.Reqst;
import org.junit.Test;


public class BuyTest extends BaseHscfTest {
	
	@Test
	public void saveBuyInfo() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidShop().addToken(LoginTest.token));
		BuyModel buyModel = new BuyModel();
		buyModel.setCarId("000f0b8083ca4ac089ab02674f3e54ba");
		buyModel.setPhone("13558883724");
		buyModel.setPrice(50000);
		reqst.setData(buyModel);
		toReqst(rootShopPath+"/buy/saveBuyInfo", reqst);
	}

}
