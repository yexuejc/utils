package com.yexuejc.util.ytest.hscf.api.shop;

import com.yexuejc.util.ytest.hscf.api.core.BaseHscfTest;
import com.yexuejc.util.ytest.hscf.api.model.GoodCarModel;
import com.yexuejc.util.ytest.hscf.api.utils.HeaderUtil;
import com.yexuejc.util.ytest.hscf.api.utils.Reqst;
import org.junit.Test;


public class CarTest extends BaseHscfTest {

	
	/**
	 * 好车推荐
	 */
	@Test
	public void getGoodCar() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidShop());
		GoodCarModel model = new GoodCarModel();
		model.setCity("750");
		model.setCount(5);
		model.setKey("2015");
		reqst.setData(model);
		toReqst(rootShopPath+"/car/getGoodCar", reqst);
	}
}
