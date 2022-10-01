package com.masai.OfficerUseCases;

import java.util.Scanner;

import com.masai.Exceptions.CrimeException;
import com.masai.Exceptions.CriminalException;
import com.masai.OfficerDao.OfficerDao;
import com.masai.OfficerDao.OfficerDaoImpl;

public class CrimeCriminalMap {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Crime_id");
		int crime_id = sc.nextInt();
		
		System.out.println("Enter the criminal_id");
		int Criminal_id = sc.nextInt();
		
		OfficerDao od = new OfficerDaoImpl();
		
		String insert = "";
		
		try {
			
			insert = od.registerCriminalToCrime(crime_id, Criminal_id);
		
		} catch (CrimeException e) {
			
			insert = e.getMessage();
			
		} catch (CriminalException e) {
			
			insert = e.getMessage();
			
		}
		
		System.out.println(insert);
	}
	
}
