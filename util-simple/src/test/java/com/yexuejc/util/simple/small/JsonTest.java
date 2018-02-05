package com.yexuejc.util.simple.small;

import com.yexuejc.util.base.util.JsonUtil;

import java.util.List;
import java.util.Map;

public class JsonTest {
    public static void main(String[] args) {
//        JsonUtil.json2Obj("{\"name\":\"张三\"}", Map.class);

        String str = "[\n" +
                "\t\"6dfe23b00cea43c0a61c1540830a36de\",\n" +
                "\t\"3a4e20a808ba4a908a273e64189f0125\",\n" +
                "\t\"bf88db4e96cf4daf88aee36389c3bdda\",\n" +
                "\t\"7b471e8ff90a4d5894cc57f72335fc5f\",\n" +
                "\t\"4c700c46848e4bdbaa42a79698558556\",\n" +
                "\t\"536d04787ba24ff2ae47bbd0f846af04\",\n" +
                "\t\"a2dc10383d8a4b408b76fe281bcb9eca\",\n" +
                "\t\"4e530498829346058e5a13ead0df2800\",\n" +
                "\t\"4fdc916978ba46b3af10df0860aecf18\",\n" +
                "\t\"cd2b1356df0940bf8bfaf2ae91a332cd\",\n" +
                "\t\"e10adc3949ba59abbe56e057f20f883e\"]";
        String s="[\"6dfe23b00cea43c0a61c1540830a36de\",\"3a4e20a808ba4a908a273e64189f0125\"," +
                "\"bf88db4e96cf4daf88aee36389c3bdda\",\"7b471e8ff90a4d5894cc57f72335fc5f\"," +
                "\"4c700c46848e4bdbaa42a79698558556\",\"536d04787ba24ff2ae47bbd0f846af04\"," +
                "\"a2dc10383d8a4b408b76fe281bcb9eca\",\"4e530498829346058e5a13ead0df2800\"," +
                "\"4fdc916978ba46b3af10df0860aecf18\",\"cd2b1356df0940bf8bfaf2ae91a332cd\"," +
                "\"e10adc3949ba59abbe56e057f20f883e\"]";
        List<String> list = JsonUtil.json2Obj(str, List.class);
        System.out.println(JsonUtil.obj2Json(list));
    }
}
