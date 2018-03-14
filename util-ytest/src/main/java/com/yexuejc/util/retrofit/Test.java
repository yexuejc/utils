package com.yexuejc.util.retrofit;

public class Test {
	public static void main(String[] args) {
		ApiService.getInstance().getApi(HttpsApi.class).banners("a_b").enqueue(new BaseCallBack<Object>() {

			@Override
			public void onNext(Object result) {
				System.out.println(result);
			} 
		});
	}
}
