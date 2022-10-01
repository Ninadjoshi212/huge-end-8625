package com.masai.OfficerUseCases;

import java.util.List;

import com.masai.Bean.Crime;
import com.masai.Exceptions.CrimeException;
import com.masai.OfficerDao.OfficerDao;
import com.masai.OfficerDao.OfficerDaoImpl;

public class AllFIRRecord {

	public static void main(String[] args) {

		OfficerDao od = new OfficerDaoImpl();

		try {

			List<Crime> list = od.getAllFIR();

			for (Crime c : list) {
				
				System.out.println();
				System.out.println("***********************************************");
				
				System.out.println();
				System.out.println("Crime Id : " + c.getId());
				System.out.println("Crime Type : " + c.getName());
				System.out.println("Crime Victims : " + c.getVictims());
				System.out.println("Crime Description : " + c.getDetails());
				System.out.println("Crime Date : " + c.getDate());
				System.out.println("Station Alloted : " + c.getPolice());
				System.out.println("Crime Suspect : " + c.getSuspected());
				System.out.println("CRime Status : " + c.getStatus());
				
				System.out.println();
				System.out.println("***********************************************");

			}

		} catch (CrimeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
