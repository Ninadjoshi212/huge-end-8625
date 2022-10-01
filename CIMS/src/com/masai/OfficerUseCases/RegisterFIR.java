package com.masai.OfficerUseCases;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.masai.Bean.Crime;
import com.masai.OfficerDao.OfficerDao;
import com.masai.OfficerDao.OfficerDaoImpl;


public class RegisterFIR {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Type of the crime");
		String name = sc.nextLine();
		
		System.out.println("Enter the Detailed Description of the crime (maximum 150 words)");
		String des = sc.nextLine();
		
		System.out.println("Enter the Name of the police Station");
		String police = sc.nextLine();
		
		System.out.println("Enter the name of the Main suspected");
		String sus = sc.nextLine();	
		
		System.out.println("Enter the Number of Victims");
		int vict = sc.nextInt();
		
		System.out.println("Enter the date of crime (formate must be -> yyyy-mm-dd)");
		String str = sc.next();

		try {
			
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateS = LocalDate.parse(str,dtf);
		String date = dateS.toString();
		

		System.out.println("what is the Status of this case ? Solved/Unsolved");
		String status = sc.next();
		
		Crime c = new Crime(name,vict,des,date,police,sus,status);
	
		OfficerDao od = new OfficerDaoImpl();
		String s = od.registerFIR(c);
		
		System.out.println(s);

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Invalid format");
		}
	}
	
}
