package com.masai.OfficerUseCases;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.OfficerDao.OfficerDao;
import com.masai.OfficerDao.OfficerDaoImpl;

public class SearchFIRByCriminal {

	public static void main(String[] args) {

		OfficerDao od = new OfficerDaoImpl();

		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Enter the crime_id");
			int crime_id = sc.nextInt();

			System.out.println("Enter the criminal_id");
			int criminal_id = sc.nextInt();

			od.searchCrimeByCriminal(crime_id, criminal_id);

		} catch (InputMismatchException im) {
			System.out.println("Input Mismatch");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
