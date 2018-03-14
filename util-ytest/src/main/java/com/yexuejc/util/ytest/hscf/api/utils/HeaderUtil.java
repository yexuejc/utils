package com.yexuejc.util.ytest.hscf.api.utils;

public class HeaderUtil {
	private static ReqstHeader iosShop;
	private static ReqstHeader iosStaff;
	private static ReqstHeader androidShop;
	private static ReqstHeader androidStaff;
	
	public static ReqstHeader getIosShop() {
		if(iosShop==null){
			iosShop=new ReqstHeader();
			iosShop.setApp("hschefu-ios-shop");
			iosShop.setOs("IOS");
			iosShop.setVer("1.2.9");
		}
		return iosShop;
	}
	public static ReqstHeader getIosStaff() {
		if(iosStaff==null){
			iosStaff=new ReqstHeader();
			iosStaff.setApp("hschefu-ios-staff");
			iosStaff.setOs("IOS");
			iosStaff.setVer("1.2.11");
		}
		return iosStaff;
	}
	public static ReqstHeader getAndroidShop() {
		if(androidShop==null){
			androidShop=new ReqstHeader();
			androidShop.setApp("hschefu-android-shop");
			androidShop.setOs("Android");
			androidShop.setVer("1.9.5");
		}
		return androidShop;
	}
	public static ReqstHeader getAndroidStaff() {
		if(androidStaff==null){
			androidStaff=new ReqstHeader();
			androidStaff.setApp("hschefu-android-staff");
			androidStaff.setOs("Android");
			androidStaff.setVer("2.1.1");
		}
		return androidStaff;
	}

}
