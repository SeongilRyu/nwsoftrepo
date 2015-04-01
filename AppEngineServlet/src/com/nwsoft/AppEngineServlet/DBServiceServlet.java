package com.nwsoft.AppEngineServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBServiceServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String qry = req.getParameter("strSql");
		//
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html><head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Response= " + qry + "</p>");
		out.println("</body></html>");
		out.close();
	}

}
