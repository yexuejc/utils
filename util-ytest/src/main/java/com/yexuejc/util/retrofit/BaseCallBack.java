package com.yexuejc.util.retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yexue
 * @tag
 * @time 2017/8/17 15:13
 */

public abstract class BaseCallBack<T> implements Callback<T> {

	@Override
	public void onResponse(Call<T> call, Response<T> response) {
		onNext(response.body());
	}

	@Override
	public void onFailure(Call<T> call, Throwable t) {
		System.out.println(t);
		onNext(null);
	}

	public abstract void onNext(T result);
}
