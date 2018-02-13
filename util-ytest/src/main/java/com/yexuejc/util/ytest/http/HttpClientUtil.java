package com.yexuejc.util.ytest.http;

import com.google.gson.Gson;
import com.yexuejc.util.ytest.hscf.api.utils.Reqst;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.*;
import java.util.Map.Entry;


/* 
 * 利用HttpClient进行post请求的工具类 
 */
public class HttpClientUtil {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String doPost(String url, Map<String, String> map, String charset) {
		SSLClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			httpClient = new SSLClient();
			httpPost = new HttpPost(url);
			// 设置参数
			if (map != null) {
				List<NameValuePair> list = new ArrayList<NameValuePair>();
				Iterator iterator = map.entrySet().iterator();
				while (iterator.hasNext()) {
					Entry<String, String> elem = (Entry<String, String>) iterator.next();
					list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
				}
				if (list.size() > 0) {
					UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
					httpPost.setEntity(entity);
				}
			}
			HttpResponse response = httpClient.execute(httpPost);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, charset);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	/**
	 * application/json
	 * 
	 * @param url
	 * @param reqst
	 * @param charset
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String doPost(String url, Reqst reqst, String charset) {
		Gson gson = new Gson();
		SSLClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			httpClient = new SSLClient();
			httpPost = new HttpPost(url);
			httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
			if (reqst.getHeader() != null && !reqst.getHeader().equals("")) {
				Map<String, String> headers = gson.fromJson(gson.toJson(reqst.getHeader()), Map.class);
				  Set<String> keys = headers.keySet();  
                  for (Iterator<String> i = keys.iterator(); i.hasNext();) {  
                      String key = (String) i.next();  
                      httpPost.addHeader(key, headers.get(key));  
                        
                  }  
				reqst.setHeader(null);
			}
			// 将JSON进行UTF-8编码,以便传输中文
			// String encoderJson = URLEncoder.encode(json,charset);

			StringEntity se = new StringEntity(gson.toJson(reqst),charset);
			se.setContentType("text/json");
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
			httpPost.setEntity(se);
			HttpResponse response = httpClient.execute(httpPost);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, charset);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	/**
	 * 发送get请求
	 * 
	 * @param url
	 *            链接地址
	 * @param charset
	 *            字符编码，若为null则默认utf-8
	 * @return
	 */
	public String doGet(String url, Map<String, String> param, String charset) {
		if (null == charset) {
			charset = "utf-8";
		}
		SSLClient httpClient = null;
		HttpGet httpGet = null;
		String result = null;

		try {
			httpClient = new SSLClient();
			// 设置参数
			if (param != null) {
				url = url + "?" + param;
			}
			httpGet = new HttpGet(url);
			HttpResponse response = httpClient.execute(httpGet);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, charset);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}