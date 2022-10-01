package com.masai.OfficerUseCases;

import java.util.List;

import com.masai.AdminDao.AdminDao;
import com.masai.AdminDao.AdminDaoImpl;
import com.masai.Bean.Crime;
import com.masai.Exceptions.CrimeException;
import com.masai.OfficerDao.OfficerDao;
import com.masai.OfficerDao.OfficerDaoImpl;

public class UnsolvedCasesRecord {

	public static void main(String[] args) {

		OfficerDao od = new OfficerDaoImpl();

		try {

			List<Crime> list = od.detailsOfUnsolvedFIR();

			for (Crime c : list) {
				System.out.println();
				System.out.println("Id of the Crime : " + c.getId());
				System.out.println("Name of the crime : " + c.getName());
				System.out.println("Number of Victims : " + c.getVictims());
				System.out.println("Detailed Description of Crime : " + c.getDetails());
				System.out.println("Date : " + c.getDate());
				System.out.println("Police staion name : " + c.getPolice());
				System.out.println("Name of main Suspected : " + c.getSuspected());
				System.out.println("Status of Case : " + c.getStatus());
				System.out.println();
				System.out.println("***********************************************");

			}

		} catch (CrimeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
