package com.masai.OfficerUseCases;

import java.util.List;

import com.masai.Bean.Criminal;
import com.masai.Exceptions.CriminalException;
import com.masai.OfficerDao.OfficerDao;
import com.masai.OfficerDao.OfficerDaoImpl;

public class AllCriminalsRecord {

	public static void main(String[] args) {

		OfficerDao od = new OfficerDaoImpl();

		try {

			List<Criminal> list = od.getAllCriminals();

			for (Criminal c : list) {

				System.out.println();
				System.out.println("Id of the Criminal : " + c.getId());
				System.out.println("Name of the criminal : " + c.getName());
				System.out.println("Address of criminal; : " + c.getAddress());
				System.out.println("Gender : " + c.getGender());
				System.out.println("Age : " + c.getAge());
				System.out.println("Area : " + c.getArea());
				System.out.println("Identity mark : " + c.getIdentity_mark());
				System.out.println("crime : " + c.getCrime());
				System.out.println();
				System.out.println("***********************************************");

			}

		} catch (CriminalException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
