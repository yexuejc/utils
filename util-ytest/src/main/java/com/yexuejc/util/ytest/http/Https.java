package com.yexuejc.util.ytest.http;

import com.google.gson.Gson;
import com.yexuejc.util.ytest.gzutil.SignParamsUtil;
import com.yexuejc.util.ytest.hscf.api.utils.Reqst;
import com.yexuejc.util.ytest.utils.FormatUtils;

import java.util.HashMap;
import java.util.Map;


public class Https {
	private static String charset = "UTF-8";
	static HttpClientUtil httpClientUtil = new HttpClientUtil();

	/**
	 * 加密请求
	 *
	 * @param url
	 *            请求地址
	 * @param params
	 *            参数
	 * @param callback
	 *            返回结果
	 * @param flag
	 *            是否格式化
	 */
	public static void requestGet2Sign(final String url, final Map<String, Object> params, String signKey,
			final Callback callback, final boolean flag) {
		if (signKey != null && !signKey.equals("")) {
			params.put("TMS", System.currentTimeMillis());
			requestGetToVersion(url, SignParamsUtil.createSignMap(params, signKey), callback, flag);
		} else {
			requestGetToVersion(url, params, callback, flag);
		}

	}

	/**
	 * 加密请求
	 *
	 * @param url
	 *            请求地址
	 * @param params
	 *            参数
	 * @param callback
	 *            返回结果
	 * @param flag
	 *            是否格式化
	 */
	public static void requestPost2Sign(final String url, final Map<String, Object> params, String signKey,
			final Callback callback, final boolean flag) {
		if (signKey != null && !signKey.equals("")) {
			params.put("TMS", System.currentTimeMillis());
			requestPostToVersion(url, SignParamsUtil.createSignMap(params, signKey), callback, flag);
		} else {
			requestPostToVersion(url, params, callback, flag);
		}

	}

	/**
	 * https的get请求带版本
	 *
	 * @param url
	 *            请求地址
	 * @param params
	 *            参数
	 * @param callback
	 *            返回结果
	 * @param flag
	 *            是否格式化
	 */
	public static void requestGetToVersion(final String url, final Map<String, Object> params, final Callback callback,
			final boolean flag) {
		params.put("version", "4.0");
		System.out.println("\n=====================================================================\n");
		String pString = params.toString();
		pString = pString.replaceAll(", ", "&");
		pString = pString.substring(1, pString.lastIndexOf("}"));
		System.out.println("url-request : \n" + url + "?" + pString);
		System.out.println("url : \n" + url);
		System.out.println("parmans : \n" + FormatUtils.formatJSON(params.toString()));
		System.out.println("\n=====================================================================\n");
		requestGet(url, params, callback, flag);
	}

	/**
	 * https的post请求带版本
	 *
	 * @param url
	 *            请求地址
	 * @param params
	 *            参数
	 * @param callback
	 *            返回结果
	 * @param flag
	 *            是否格式化
	 */
	public static void requestPostToVersion(final String url, final Map<String, Object> params, final Callback callback,
			final boolean flag) {
		params.put("version", "4.0");
		System.out.println("\n=====================================================================\n");
		String pString = params.toString();
		pString = pString.replaceAll(", ", "&");
		pString = pString.substring(1, pString.lastIndexOf("}"));
		System.out.println("url-request : \n" + url + "?" + pString);
		System.out.println("url : \n" + url);
		System.out.println("parmans : \n" + FormatUtils.formatJSON(params.toString()));
		System.out.println("\n=====================================================================\n");
		requestPost(url, params, callback, flag);
	}
	/**
	 * https的post请求带版本
	 *
	 * @param url
	 *            请求地址
	 * @param reqst
	 *            参数
	 * @param callback
	 *            返回结果
	 * @param flag
	 *            是否格式化
	 */
	public static void requestPostToVersion(final String url, final Reqst reqst, final Callback callback,
			final boolean flag) {
		System.out.println("\n=====================================================================\n");
		System.out.println("url：>>>>>> \n" + url);
		System.out.println("parmans：>>>>>> \n" + new Gson().toJson(reqst));
		if(flag)System.out.println("parmans-format：>>>>>> \n"+FormatUtils.formatJSON(new Gson().toJson(reqst)));
		System.out.println("\n=====================================================================\n");
		requestPost(url, reqst, callback, flag);
	}

	/**
	 * get请求
	 * 
	 * @param url
	 *            请求地址
	 * @param params
	 *            参数
	 * @param callback
	 *            返回结果
	 * @param flag
	 *            是否格式化
	 */
	public static void requestGet(String url, Map<String, Object> params, Callback callback, boolean flag) {
		try {
			Map<String, String> p = new HashMap<String, String>();
			if (params != null) {
				for (String key : params.keySet()) {
					if (params.get(key) != null) {
						p.put(key, params.get(key).toString());
					} else {
						p.put(key, "");
					}
				}
			}

			String result = httpClientUtil.doGet(url, p, charset);
			if (flag) {
				result = FormatUtils.formatJSON(result);
			}
			callback.success(result);
		} catch (Exception e) {
			callback.error(500, "请求失败");
			e.printStackTrace();
		}
	}

	/**
	 * post 请求
	 * 
	 * @param url
	 *            请求地址
	 * @param params
	 *            参数
	 * @param callback
	 *            返回结果
	 * @param flag
	 *            是否格式化
	 */
	public static void requestPost(String url, Map<String, Object> params, Callback callback, boolean flag) {
		try {
			Map<String, String> p = new HashMap<String, String>();
			if (params != null) {
				for (String key : params.keySet()) {
					if (params.get(key) != null) {
						p.put(key, params.get(key).toString());
					} else {
						p.put(key, "");
					}
				}
			}
			String result = httpClientUtil.doPost(url, p, charset);
			if (flag) {
				result = FormatUtils.formatJSON(result);
			}
			callback.success(result);
		} catch (Exception e) {
			callback.error(500, "请求失败");
			e.printStackTrace();
		}
	}
	/**
	 * post json 请求
	 * 
	 * @param url
	 *            请求地址
	 * @param reqst
	 *            参数
	 * @param callback
	 *            返回结果
	 * @param flag
	 *            是否格式化
	 */
	public static void requestPost(String url, Reqst reqst, Callback callback, boolean flag) {
		try {
			String result = httpClientUtil.doPost(url, reqst, charset);
			if (flag) {
				result = FormatUtils.formatJSON(result);
			}
			callback.success(result);
		} catch (Exception e) {
			callback.error(500, "请求失败");
			e.printStackTrace();
		}
	}

	/**
	 * 返回给ui的返回函数
	 */
	public interface Callback {
		/**
		 * 成功
		 *
		 * @param result
		 *            返回结果
		 */
		void success(String result);

		/**
		 * 失败
		 *
		 * @param errCode
		 *            错误码
		 * @param errMsg
		 *            错误消息
		 */
		void error(int errCode, String errMsg);

	}

}
