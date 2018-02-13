package com.yexuejc.util.retrofit;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yexue
 * @tag
 * @time 2017/8/17 14:11
 */

public class NetClient {
	/**
	 * 获取Retrofit适配器。
	 *
	 * @return 网络适配器
	 */
	static Retrofit newRetrofit() {
		return new Retrofit.Builder().baseUrl("https://192.168.0.127:9100").client(getClient().build())
				.addConverterFactory(GsonConverterFactory.create()).build();
	}

	/**
	 * 获取 OkHttpClient
	 *
	 * @return OkHttpClient
	 */
	private static OkHttpClient.Builder getClient() {
		HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, "123");
		return new OkHttpClient.Builder().connectTimeout(20, TimeUnit.SECONDS).writeTimeout(20, TimeUnit.SECONDS)
				.readTimeout(20, TimeUnit.SECONDS).hostnameVerifier(new HostnameVerifier() {

					@Override
					public boolean verify(String hostname, SSLSession session) {
						return true;
					}
				})
				// .cookieJar(new CookieManger(APP.getInstance()))
				.connectionPool(new ConnectionPool(4, 10, TimeUnit.SECONDS))
				.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
				.protocols(Collections.singletonList(Protocol.HTTP_1_1));
		// 这里你可以根据自己的机型设置同时连接的个数和时间，我这里8个，和每个保持时间为10s
		// .addInterceptor(new AddCookiesInterceptor(AppManager.getInstance()))
		// .addInterceptor(new ReceivedCookiesInterceptor(AppManager.getInstance()))
		// .addInterceptor(new
		// HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));//日志

		/**
		 * 自定义打印日志
		 */
		// .addInterceptor(new LoggerInterceptor("TAG",true));
	}
}