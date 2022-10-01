package com.masai.OfficerUseCases;

import java.util.Scanner;

import com.masai.OfficerDao.OfficerDao;
import com.masai.OfficerDao.OfficerDaoImpl;

public class DeleteCriminalNotMappedToCrime {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Criminal_id to delete criminal details");
		int id = sc.nextInt();

		OfficerDao od = new OfficerDaoImpl();

		String status = od.deleteCriminalNotMappedToCrime(id);

		System.out.println(status);
		
		sc.close();
	}

}
