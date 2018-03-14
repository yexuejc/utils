package com.yexuejc.util.example.small.tostring;

public class MainTostring {

	public static void main(String[] args) {
		Tostring tostring = new Tostring();
		tostring.setA("41564565");
		tostring.setB("asdasdasd");
		System.out.println(tostring.toString());

		String sss = "【e分钱】亲爱的唐龙同学您的认证信息审核通过，您可以获得参与百分百中奖的万元红包抢抢抢！详见APP首页活动规则time2018-02-12 15:26:52";
		System.out.println(sss.substring(0,sss.indexOf("time")));
		System.out.println(sss.substring(sss.indexOf("time")+4));
	}

}
