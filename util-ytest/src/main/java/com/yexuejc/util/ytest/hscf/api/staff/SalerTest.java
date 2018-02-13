package com.yexuejc.util.ytest.hscf.api.staff;

import java.util.ArrayList;
import java.util.List;

import com.yexuejc.util.ytest.hscf.api.core.BaseHscfTest;
import com.yexuejc.util.ytest.hscf.api.model.*;
import com.yexuejc.util.ytest.hscf.api.utils.HeaderUtil;
import com.yexuejc.util.ytest.hscf.api.utils.Reqst;
import org.junit.Test;


public class SalerTest extends BaseHscfTest {
	
	enum URI {
		UN_SHELVE("/saler/unShelve"),//业务员申请下架车辆
		MY_CAR_LIST("/saler/mycarList"),//员工端-查询某个员工收的二手车
		MY_SELLCAR("/saler/sellCar"),//员工端-业务员确定要卖本辆车
		SELL_CAR_LIST("/saler/sellCarList"),//员工端-业务员要卖辆车
		PUT_CAR("/saler/putcar"),//员工端-上传
		GETCARBYID("/saler/getCarById"),//根据id获取二手车详情,data为car_id的值,必须参数
		ALLOT("/saler/allot"),//根据id获取二手车详情,data为car_id的值,必须参数
		;

		public String NAME;

		URI(String name) {
			this.NAME = rootStaffPath + name;
		}
	}
	
	@Test
	public void allot() {
		Reqst reqst = new Reqst();
		TransferModel model = new TransferModel();
		model.setCarId("508ba435ce864018a4d77fe870e7b603");
		model.setEeid("6f7661f4934a4388bad1024137385541");
		model.setNote("Sadfsdf");
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		reqst.setData(model);
		toReqst(URI.ALLOT.NAME, reqst);
	}
	@Test
	public void getCarById() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		reqst.setData("c4f7954f9d8d49d799eff137f72b7683");
		toReqst(URI.GETCARBYID.NAME, reqst);
	}

	@Test
	public void putcar() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		CarModel carModel = new CarModel();
//		carModel.setId(StrUtil.genUUID());
		carModel.setId("0053ea37b6894313b530bed52fb9f80e");
		carModel.setReqType(1);//0新上传，1修改审核
		carModel.setBelongType(1);//车辆归属：0 个人，1车商
		if(carModel.getBelongType()==1){
			carModel.setStoreId("73157676af0047e88f0afaf57b11ed19");
		}
		carModel.setMileage("1000");
		carModel.setDetailId("1000001");
		carModel.setCertExpire("2018-10-01");
		carModel.setRegDate("2017-01-01");
		carModel.setCity("75");
		carModel.setColor("A");
		carModel.setLiabilityExpire("2018-10-02");
		carModel.setVendorPrice("150000");
		List<CarImg> carImgs = new ArrayList<>();
		CarImg carImg = new CarImg("左前45度","外观","img/car/7cdb845c018140278f7cafddfc87c0f5/87adeed9e9b90ae15bdab12ef61f99f11502443878221.jpg","false");
		CarImg carImg2 = new CarImg("正前/右前45度均可","外观","img/car/7cdb845c018140278f7cafddfc87c0f5/f230234d3ad365d863e667f2d1cf56cc1502444031814.jpg","false");
		carImgs.add(carImg);
		carImgs.add(carImg2);
		carModel.setCarImgs(carImgs);
		
		CarSensitive cst = new CarSensitive();
		cst.setOwnerName("唐先生");
		cst.setVin("LSGPC52U6AF132431");
		cst.setOwnerMobile("13512345678");
		//选填------------>
		cst.setLpn("川A16355");
		carModel.setCst(cst);
		//选填------------>
		carModel.setDesc("--->成都市武侯区东华二手车市场明和车行罗先生。电话18508247010");
		carModel.setInsuranceExpire("2018-10-10");
		carModel.setTransferTimes("5");
		carModel.setPrice("100000");
		carModel.setLabels(new String[]{"C"});
		carModel.setTest("N");
		carModel.setAssess("N");
		
		
		reqst.setData(carModel);
		toReqst(URI.PUT_CAR.NAME, reqst);
	}
	
	/**
	 *业务员申请下架车辆
	 */
	@Test
	public void unShelve() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		reqst.setData("00397bd9a74c4c2d900e3ba7a0706120");
		toReqst(URI.UN_SHELVE.NAME, reqst);
	}
	
	
	/**
	 * 查询个人车辆-车商车辆
	 * 修改测试：通过
	 */
	@Test
	public void mycarList() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		SellCarModel sellCarModel = new SellCarModel();
		sellCarModel.setStat("X");//状态"B": "待审核","X": "被驳回","P": "已录入"
		sellCarModel.setType(1);//查询类型：1车商车辆，0个人车辆
		reqst.setData(sellCarModel);
		toReqst(URI.MY_CAR_LIST.NAME, reqst);
	}
	/**
	 * 业务员确定要卖本辆车
	 * 修改测试：通过
	 */
	@Test
	public void sellCar() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		reqst.setData("011dbbb6e8614676b00a5440af14db07");
		toReqst(URI.MY_SELLCAR.NAME, reqst);
	}
	/**
	 * 员工端-业务员获取我要卖车列表
	 * 修改测试：通过(条件不通过)
	 */
	@Test
	public void sellCarList() {
		Reqst reqst = new Reqst();
		reqst.setHeader(HeaderUtil.getAndroidStaff().addToken(Login.token));
		SellCarModel sellCarModel = new SellCarModel();
		reqst.setData(sellCarModel);
		toReqst(URI.SELL_CAR_LIST.NAME, reqst);
	}
	
	@Test
	public void s(){
		CarImg carImg = new CarImg("左前45度", "外观","img/car/7cdb845c018140278f7cafddfc87c0f5/87adeed9e9b90ae15bdab12ef61f99f11502443878221.jpg", "false");
		CarImg carImg2 = new CarImg("正前/右前45度均可", "外观","img/car/7cdb845c018140278f7cafddfc87c0f5/87adeed9e9b90ae15bdab12ef61f99f11502443878221.jpg", "false");
		CarImg[] newCarImg = new CarImg[]{carImg,carImg2}; 
		List<CarImg> oldCarImg = new ArrayList<CarImg>();
		oldCarImg.add(carImg);
		oldCarImg.add(carImg2);
		
		for(CarImg nc:newCarImg){
			for (CarImg oc : oldCarImg) {
				if(nc.getName().equals(oc.getName())){
					if(!nc.getImg().equals(oc.getImg())){
					}
				}
			}
			
		}
	}
	
}
