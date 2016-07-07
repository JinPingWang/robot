package test;

import java.io.IOException;
import java.net.URLEncoder;

import json.Json;
import tuling.TuringRequestBean;
import tuling.TuringHttpClient;

public class Test01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		TuringRequestBean turingBean = new TuringRequestBean("ae35e0925aa475708cd0f1892ac8c244", "我喜欢你", "aabbccd");
		Json json = new Json();
		String jsonString = json.getJson(turingBean);
		
		TuringHttpClient turingClient = new TuringHttpClient();
		System.out.println(turingClient.getResult(jsonString));
	}

}
