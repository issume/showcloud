package com.showcloud.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTest {

	public static void main(String[] args) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
		//	Class.forName("org.gjt.mm.mysql.Driver").newInstance(); //5.140 version
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/showcloud?user=root&password=password&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true";
			Connection conn = DriverManager.getConnection(url);

			// 执行查询的操作
			String sqlString = "select * from sys_user";
			pst = (PreparedStatement) conn.prepareStatement(sqlString);
			rs = pst.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}

			/*
			 * 执行更更新操作 pst=(PreparedStatement) conn.
			 * prepareStatement("update userinfo set userpwd='pwd' where id=1");
			 * int count=pst.executeUpdate(); if (count==0) {
			 * System.out.println("update execute fail"); }else{
			 * System.out.println("update execute success"); } if (conn!=null) {
			 * System.out.println("success"); }else{ System.out.println("fail");
			 * }
			 */

			/*
			 * 添加信息部分 pst=(PreparedStatement) conn.
			 * prepareStatement("insert into userinfo(username,userpwd) values(?,?);"
			 * ); pst.setString(1, "gao"); pst.setString(2, "gpwd");
			 * pst.execute();
			 */
			/*
			 * 根据id删除数据部分 pst=(PreparedStatement)
			 * conn.prepareStatement("delete from userinfo where id=2");
			 * pst.execute();
			 */

			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
