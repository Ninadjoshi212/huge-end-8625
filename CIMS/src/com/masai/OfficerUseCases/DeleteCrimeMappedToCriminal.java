package com.masai.OfficerUseCases;

import java.util.Scanner;

import com.masai.Exceptions.CrimeException;
import com.masai.OfficerDao.OfficerDao;
import com.masai.OfficerDao.OfficerDaoImpl;

public class DeleteCrimeMappedToCriminal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Crime_id to delete crime details");
		int id = sc.nextInt();

		OfficerDao od = new OfficerDaoImpl();

		try {
			String status = od.deleteCrimeMappedToCriminal(id);
			System.out.println(status);
		} catch (CrimeException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
