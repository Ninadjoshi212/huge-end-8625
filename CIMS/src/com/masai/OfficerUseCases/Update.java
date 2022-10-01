package com.masai.OfficerUseCases;

import java.util.Scanner;

import com.masai.AdminDao.AdminDao;
import com.masai.AdminDao.AdminDaoImpl;
import com.masai.Exceptions.CrimeException;
import com.masai.OfficerDao.OfficerDao;
import com.masai.OfficerDao.OfficerDaoImpl;

public class Update {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the valid FIR Id");
		int id = sc.nextInt();

		OfficerDao od = new OfficerDaoImpl();
		AdminDao ad = new AdminDaoImpl();

		try {

			String current_status = ad.checkStatusOfFIR(id);
			System.out.println(current_status);

			System.out.println("Want to update the status ? Y / N");
			String choice = sc.next();

			try {

				if (choice.equalsIgnoreCase("y")) {

					System.out.println("Enter the value : Solved / Unsolved");
					String value = sc.next();

					String s = od.updateStatusOfFIR(id, value);
					System.out.println(s);

				} else if (choice.equalsIgnoreCase("n")) {

					System.out.println("Thankyou!!!");

				} else {
					
					throw new CrimeException("Invalid choice");
				}

			} catch (CrimeException e) {

				System.out.println(e.getMessage());

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
