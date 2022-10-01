package com.masai.AdminUseCase;

import java.util.Scanner;

import com.masai.AdminDao.AdminDao;
import com.masai.AdminDao.AdminDaoImpl;
import com.masai.Bean.Police_Station;

public class RegisterPolice_Station {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Police-Station name:");
		String PoliceStation_Name = sc.nextLine();

		System.out.println("Enter Police Station Area :");
		String PoliceStation_Area = sc.nextLine();

		AdminDao ad = new AdminDaoImpl();

		Police_Station police = new Police_Station();

		police.setPoliceStation_Name(PoliceStation_Name);

		police.setPoliceStation_Area(PoliceStation_Area);

		String result = ad.registerPoliceStation(police);

		System.out.println(result);
	}

}
