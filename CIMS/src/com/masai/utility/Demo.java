package com.masai.utility;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(Connection con = DBUtil.getconnection()) {

			System.out.println(con);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
