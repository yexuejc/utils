package com.yexuejc.util.base.util;

/**
 * @className FileUtil
 * @description 工具类
 * @author maxf:yexue
 * @time 2017年11月3日 下午3:12:49
 */
public class FileUtil {
	private static final String TYPE_TAR_GZ=".tar.gz";
	private static final String TAR_GZ="tar.gz";

	public static String getFileType(String fileName) {
		if (fileName.indexOf(TYPE_TAR_GZ) + TYPE_TAR_GZ.length() == fileName.length()) {
			return TAR_GZ;
		}
		return fileName.substring(fileName.indexOf(".") + 1);
	}

}
