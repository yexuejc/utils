package com.yexuejc.util.api.demo.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class FormatUtils {
	/**
	 * 格式化JSON
	 * @param str
	 * @return
	 */
	public static String formatJSON(String str) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(str);
		String prettyJsonString = gson.toJson(je);
		return prettyJsonString;
	}

}
