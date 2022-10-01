package com.masai.AdminUseCase;

import java.util.Scanner;

import com.masai.AdminDao.AdminDao;
import com.masai.AdminDao.AdminDaoImpl;
import com.masai.Exceptions.CrimeException;

public class CheckStatus {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the FIR number");
		int id = sc.nextInt();

		AdminDao ad = new AdminDaoImpl();

		try {

			String status = ad.checkStatusOfFIR(id);
			System.out.println(status);

		} catch (CrimeException e) {

			System.out.println(e.getMessage());

		}
		sc.close();
	}

}
