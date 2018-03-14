package com.yexuejc.util.ytest.hscf.api.staff;

import java.util.ArrayList;
import java.util.List;

import com.yexuejc.util.ytest.hscf.api.core.BaseHscfTest;
import com.yexuejc.util.ytest.hscf.api.model.MoreAd;
import com.yexuejc.util.ytest.hscf.api.model.StoreModel;
import com.yexuejc.util.ytest.hscf.api.model.StoreTransferModel;
import com.yexuejc.util.ytest.hscf.api.utils.HeaderUtil;
import com.yexuejc.util.ytest.hscf.api.utils.Reqst;
import org.junit.Test;


public class StoreTest extends BaseHscfTest {
	
	@Test
	public void transfer() {
		Reqst reqst = new Reqst();
		StoreTransferModel model = new StoreTransferModel();
		/**
		 * "data": ["storeId": "73157676af0047e88f0afaf57b11ed19",
		 *  "toEeId": "a905dd283565ed208f00213b1133a21e", "note": "Sdfsdfsdf"], "ext": ""]
		 */
		model.setStoreId("73157676af0047e88f0afaf57b11ed19");
		model.setToEeId("a905dd283565ed208f00213b1133a21e");
		model.setNote("Sdfsdfsdf");
		reqst.setData(model);
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		toReqst(rootStaffPath + "/store/transfer", reqst);
	}

	/**
	 * 获取市场列表
	 */
	@Test
	public void bazaarList() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		toReqst(rootStaffPath + "/store/bazaarList", reqst);
	}
	/**
	 * 获取门店列表
	 */
	@Test
	public void storeList() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		toReqst(rootStaffPath + "/store/storeList", reqst);
	}
	/**
	 * 获取我的门店列表
	 */
	@Test
	public void myStoreList() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		toReqst(rootStaffPath + "/store/myStoreList", reqst);
	}
	
	/**
	 * 添加门店
	 */
	@Test
	public void saveStore() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		StoreModel model = new StoreModel();
		model.setName("新华二手车门店");
		model.setImgs("img/car/7cdb845c018140278f7cafddfc87c0f5/5479a88b5b11178c909a503e18b7ad1e1502444194313.jpg");
		model.setIsHc("Y");
		model.setAdName("王五");
		model.setAdPost("销售");
		model.setBazaarId("e10adc3949ba59abbe56e057f20f883e");
		model.setCity("75");
		model.setAdMobile("18202345678");
		model.setAddr("武侯区xxxx");
		model.setRemark("备注");
		List<MoreAd> moreAds = new ArrayList<>();
		MoreAd moreAd = new MoreAd("img/car/7cdb845c018140278f7cafddfc87c0f5/5479a88b5b11178c909a503e18b7ad1e1502444194313.jpg", "赵六", "13512345678", "看门的");
		MoreAd moreAd2 = new MoreAd("img/car/7cdb845c018140278f7cafddfc87c0f5/5479a88b5b11178c909a503e18b7ad1e1502444194313.jpg", "赵六哥", "13512345378", "看门的");
		MoreAd moreAd3 = new MoreAd("img/car/7cdb845c018140278f7cafddfc87c0f5/5479a88b5b11178c909a503e18b7ad1e1502444194313.jpg", "赵六弟", "13512345378", "看门的");
		moreAds.add(moreAd);
		moreAds.add(moreAd2);
		moreAds.add(moreAd3);
		model.setMoreAd(moreAds);
		reqst.setData(model);
		toReqst(rootStaffPath + "/store/saveStore", reqst);
	}
	
	
	@Test
	public void reserveCar() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		toReqst(rootStaffPath + "/saler/reserveCar", reqst);
	}
	
}
