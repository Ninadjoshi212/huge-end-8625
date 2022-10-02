package com.masai.OfficerUseCases;

import java.util.Scanner;

import com.masai.Exceptions.CriminalException;
import com.masai.OfficerDao.OfficerDao;
import com.masai.OfficerDao.OfficerDaoImpl;

public class DeleteCriminalMappedToCrime {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Criminal_id to delete criminal details");
		int id = sc.nextInt();

		OfficerDao od = new OfficerDaoImpl();

		try {

			String status = od.deleteCriminalMappedToCrime(id);
			System.out.println(status);

		} catch (CriminalException e) {

			System.out.println(e.getMessage());

		}
	}
}
