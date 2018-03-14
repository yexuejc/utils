package com.yexuejc.util.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yexue
 * @tag
 * @time 2017/8/17 14:34
 */

public interface HttpsApi {

	/**
	 * qq登录
	 */
	@GET("/banners/{code}")
	@Headers("X-User-Agent:l;l;l;l;l;l;l;l;l")
	Call<Object> banners(@Path("code") String code);
}