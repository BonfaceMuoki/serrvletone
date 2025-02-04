package com.bonaet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/register-user")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
		String fname = req.getParameter("fname");
		String lanme = req.getParameter("lname");
		PrintWriter out = res.getWriter();
		
		Connection conn =null;
		String statement = "INSERT INTO users (fname,lname) VALUES(?,?)";
		String selectUsers = "SELECT * FROM users";
		String dbUrl="jdbc:mysql://localhost:3306/servlet_one";
		String dbUsername="root";
		String dbPass="1234";
		PreparedStatement pststement =null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl,dbUsername,dbPass);
			pststement = conn.prepareStatement(statement);
			pststement.setString(1, fname);
			pststement.setString(2, lanme);
			pststement.executeUpdate();
				  
			res.sendRedirect("index.jsp");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
