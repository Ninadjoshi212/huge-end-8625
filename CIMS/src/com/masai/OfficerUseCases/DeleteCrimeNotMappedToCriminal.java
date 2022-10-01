package com.masai.OfficerUseCases;

import java.util.Scanner;

import com.masai.OfficerDao.OfficerDao;
import com.masai.OfficerDao.OfficerDaoImpl;

public class DeleteCrimeNotMappedToCriminal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Crime_id to delete crime details");
		int id = sc.nextInt();
		
		OfficerDao od = new OfficerDaoImpl();
		
		String status = od.deleteCrimeNotMappedToCriminal(id);
		
		System.out.println(status);
		sc.close();
	}

}
