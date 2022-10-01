package com.masai.OfficerUseCases;

import java.util.Scanner;

import com.masai.Bean.Criminal;
import com.masai.Exceptions.CriminalException;
import com.masai.OfficerDao.OfficerDao;
import com.masai.OfficerDao.OfficerDaoImpl;

public class CriminalById {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Criminal_id to search particular criminal Details");
		int criminal_id = sc.nextInt();
		
		OfficerDao od = new OfficerDaoImpl();
		
		try {
			
			Criminal c = od.searchCriminalByID(criminal_id);
			
			System.out.println();
			System.out.println("Id of the Criminal : " + c.getId() );
			System.out.println("Name of the criminal : " + c.getName());
			System.out.println("Address of criminal; : " + c.getAddress());
			System.out.println("Gender : " + c.getGender());
			System.out.println("Age : " + c.getAge());
			System.out.println("Area : " + c.getArea());
			System.out.println("Identity mark : " + c.getIdentity_mark());
			System.out.println("crime : " + c.getCrime());
			System.out.println();
			
		} catch (CriminalException e) {
		
			System.out.println(e.getMessage());
			
		}
	}

}
