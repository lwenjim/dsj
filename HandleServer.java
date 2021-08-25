package dsj;


import java.sql.*;

import java.util.*;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Date;

import com.mysql.cj.jdbc.Driver;

public class HandleServer extends HttpServlet {

	//init method

	public void init() throws ServletException {

	}

	//handle get request

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("");
			out.println("ok");
			Class.forName("com.mysql.cj.jdbc.Driver");
			 PreparedStatement pstmt     = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/course_db", "root", "123456!@#").prepareStatement("select course_id,course_name from course");
			 ResultSet         resultSet = pstmt.executeQuery();
			 ResultSetMetaData metaData  = resultSet.getMetaData();
			 int               cols_len  = metaData.getColumnCount();
			 while (resultSet.next()) {
			 	for (int i = 0; i < cols_len; i++) {
			 		String cols_name  = metaData.getColumnName(i + 1);
			 		out.println(metaData.getColumnName(i + 1)+"||" +resultSet.getObject(cols_name).toString() + "<br />");
			 	}
			 }
			out.flush();
		}catch(IOException|SQLException|ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	//handle post request

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	//handle put request
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	//handle delete request

	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	//destroy
	public void destroy() {

	}
}