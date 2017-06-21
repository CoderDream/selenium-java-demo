package com.coderdream.util;

import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonUtil {

	public static void main(String[] args) {
		HashMap<Integer, Integer> obj = new HashMap<Integer, Integer>();
		obj.put(1, 1);
		obj.put(3, 1);
		obj.put(4, 1);
		obj.put(5, 1);

		Gson gson = new Gson();
		String jsonStr = gson.toJson(obj);// 转换成JSON字符串
		System.out.println(jsonStr);

		Type t = new TypeToken<HashMap<Integer, Integer>>() {
		}.getType();// 把JSON字符串转换成原来的Java对象
		HashMap<Integer, Integer> o = gson.fromJson(jsonStr, t);
		System.out.println(o);
	}
}
