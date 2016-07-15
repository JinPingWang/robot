package test;

import java.io.IOException;
import java.util.Random;

import json.Json;
import robot.TuringRobot;
import util.TaoDian;

public class Test02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String ss[] = new String[]{"New Baltimore, MI, United States","New Baltimore, NY, United States","New Baltimore, PA, United States","New Bavaria, OH, United States"};
		Json json = new Json();
		System.out.println(json.getJson(ss));
	}
}
