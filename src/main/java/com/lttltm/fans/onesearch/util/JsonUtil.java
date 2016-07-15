package com.lttltm.fans.onesearch.util;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

public class JsonUtil {

	public static String generateJsonFromObject(Object object) {
		JsonConfig config = new JsonConfig();
		config.setJsonPropertyFilter(new PropertyFilter() {
			@Override
			public boolean apply(Object source, String name, Object value) {
				return value == null;
			}
		});
		return JSONObject.fromObject(object, config).toString();
	}

	public static String generateJsonFromMultiObject(List<?> mergeList) {
        JsonConfig config = new JsonConfig();
        config.setJsonPropertyFilter(new PropertyFilter() {
            public boolean apply(Object source, String name, Object value) {
                return value == null;
            }
        });
        return JSONArray.fromObject(mergeList, config).toString();
    }
	
	@SuppressWarnings("unchecked")
	public static <T> T[] generateObjFromJsonArray(String jsonString,
			Class<T> clazz_t) {
		JSONArray array = JSONArray.fromObject(jsonString);
		Object[] obj = new Object[array.size()];
		for (int i = 0; i < array.size(); i++) {
			JSONObject jsonObject = array.getJSONObject(i);
			obj[i] = JSONObject.toBean(jsonObject, clazz_t);
		}
		return (T[]) obj;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> generateObjFromJsonList(String jsonString,
			Class<T> clazz_t) {
		JSONArray array = JSONArray.fromObject(jsonString);
		List<T> t_list = new ArrayList<T>();
		Object t_obj = null;
		for (int i = 0; i < array.size(); i++) {
			JSONObject jsonObject = array.getJSONObject(i);
			t_obj = JSONObject.toBean(jsonObject, clazz_t);
			t_list.add((T) t_obj);
		}
		return t_list;
	}

	@SuppressWarnings("unchecked")
	public static <T> T generateObjectFromJson(String jsonStr, Class<T> clazz_t) {
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		Object t_obj = JSONObject.toBean(jsonObject, clazz_t);
		return (T) t_obj;
	}
}
