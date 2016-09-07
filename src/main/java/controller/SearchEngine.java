package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import json.Json;
import robot.Robot;
import robot.SemanticNetRobot;
import robot.TuringRobot;

@WebServlet("/search")
public class SearchEngine extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5765160188981936290L;
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		doGet(request, response);
	}
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String callback = request.getParameter("callback");
		String q = request.getParameter("q");
		String _ = request.getParameter("_");
		System.out.println(callback+"\t"+q+"\t"+_);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
	
//		String ss[] = new String[]{"New Baltimore, MI, United States","New Baltimore, NY, United States","New Baltimore, PA, United States","New Bavaria, OH, United States"};
//		Json json = new Json();
//		out.write(callback+ "(" + json.getJson(ss) + ")");
		out.flush();
		out.close();
	}
}
