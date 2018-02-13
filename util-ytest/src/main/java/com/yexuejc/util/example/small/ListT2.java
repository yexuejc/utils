package com.yexuejc.util.example.small;

import com.yexuejc.util.example.bean.BannerVO;
import com.yexuejc.util.example.utils.ObjUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListT2 {
	public static void main(String[] args) {
		List<Map<String, Object>> list = new ArrayList<>();

		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("banner_name", "asasas");
		map1.put("img_path", "asasas");
		map1.put("target_url", "asasas");
		list.add(map1);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("banner_name", "sssssssssssss");
		map2.put("img_path", "sssssssssssss");
		map2.put("target_url", "sssssssssssss");
		list.add(map2);
		
		List<BannerVO> bannerVOs = new ArrayList<>();
		for (Map<String, Object> map : list) {
			BannerVO bannerVO = new BannerVO();
			bannerVO.setTitle(ObjUtils.getString(map.get("banner_name")));
			bannerVO.setImgPath(ObjUtils.getString(map.get("img_path")));
			bannerVO.setTargetUrl(ObjUtils.getString(map.get("target_url")));
			bannerVOs.add(bannerVO);
		}
		for (BannerVO bannerVO2 : bannerVOs) {
			System.out.println(bannerVO2.toString());
		}
	}
}
