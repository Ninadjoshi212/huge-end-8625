package com.masai.OfficerUseCases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.OfficerDao.OfficerDao;
import com.masai.OfficerDao.OfficerDaoImpl;

public class DeleteCrimeByCriminal {

	public static void main(String[] args) {

		OfficerDao od = new OfficerDaoImpl();

		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Enter the crime_id");
			int crime_id = sc.nextInt();

			System.out.println("Enter the criminal_id");
			int criminal_id = sc.nextInt();

			System.out.println(od.deleteCrimeByCriminalId(crime_id, criminal_id));

		} catch (InputMismatchException im) {
			System.out.println("Invalid Input");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
