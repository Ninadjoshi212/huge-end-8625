package com.masai.AdminUseCase;

import java.util.Scanner;

import com.masai.AdminDao.AdminDao;
import com.masai.AdminDao.AdminDaoImpl;
import com.masai.Bean.PoliceOfficer;
import com.masai.Exceptions.OfficerException;

public class RegisterOfficer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Officer name:");
		String officer_Name = sc.nextLine();

		System.out.println("Enter Officer username :");
		String officer_Username = sc.nextLine();
		
		System.out.println("Enter Officer password :");
		String officer_Password = sc.nextLine();
		
		System.out.println("Enter Officer rank : (Commissioner / Inspector )");
		String officer_Rank = sc.nextLine();
		
		System.out.println("Enter Officer Date Of Joining :");
		String dateOfJoining = sc.nextLine();

		AdminDao dao = new AdminDaoImpl();

		PoliceOfficer officer = new PoliceOfficer();
		
		officer.setOfficer_Name(officer_Name);

		officer.setOfficer_Username(officer_Username);
		
		officer.setOfficer_Password(officer_Password);
		
		officer.setOfficer_Rank(officer_Rank);
		
		officer.setDateOfJoining(dateOfJoining);

		String result = dao.registerOfficers(officer);

		System.out.println(result);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		
	}

}
