package com.masai.AdminUseCase;

import java.util.Scanner;

import com.masai.AdminDao.AdminDao;
import com.masai.AdminDao.AdminDaoImpl;
import com.masai.Exceptions.OfficerException;
import com.masai.Exceptions.Police_StationException;

public class OfficerStationMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String message = "";
		
		Scanner s1 = new Scanner(System.in);
		
		System.out.println("Enter the Officer_id");
		int officer_Id = s1.nextInt();
		
		System.out.println("Enter the Station_id");
		int station_Id = s1.nextInt();
		
		AdminDao ad = new AdminDaoImpl();
		
		try {
			
			message = ad.registerOfficerToStation(officer_Id, station_Id);
		
		} catch (OfficerException e) {
			
			message = e.getMessage();
			
		} catch (Police_StationException e) {
			
			message = e.getMessage();
			
		}
		
		System.out.println(message);

	}

}
