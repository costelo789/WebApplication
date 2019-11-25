package com;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;


public class Response_Client {
	public static JSONArray responseClient(String message) {
		JSONObject obj = new JSONObject();
		JSONArray rep = new JSONArray();
		obj.put("response", message);
		rep.put(obj);
		return rep;
	}
}
