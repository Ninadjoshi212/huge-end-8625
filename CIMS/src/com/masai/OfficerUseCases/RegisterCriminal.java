package com.masai.OfficerUseCases;

import java.util.Scanner;

import com.masai.Bean.Criminal;
import com.masai.OfficerDao.OfficerDao;
import com.masai.OfficerDao.OfficerDaoImpl;

public class RegisterCriminal {

public static void main(String[] args) {

	try {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Ciminal Name");
		String name = sc.nextLine();
		
		System.out.println("Enter the Address Of Criminal");
		String Address = sc.nextLine();
		
		System.out.println("Enter the Gender : Male / Female");
		String gender = sc.nextLine();
		
		System.out.println("Enter Any identity mark");
		String mark = sc.nextLine();
		
		System.out.println("What Crime he/she does");
		String crime = sc.nextLine();
		
		System.out.println("In which area he/she did crime");
		String area = sc.nextLine();
		
		System.out.println("Enter the Age");
		int age = sc.nextInt();
		
		Criminal c = new Criminal(name,Address,age,gender,mark,crime,area);
	
		OfficerDao od = new OfficerDaoImpl();
		
		String status = od.addCriminalDetails(c);
		
		System.out.println(status);
	
	} catch(Exception e) {
		
		System.out.println("Invlalid Input");
	}
	
}
	

}
