package com.masai.AdminUseCase;

import java.util.List;
import java.util.Scanner;

import com.masai.AdminDao.AdminDao;
import com.masai.AdminDao.AdminDaoImpl;
import com.masai.Bean.StationCrime;

public class FirByStationName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Police Station Area :");

		String Station_Area = sc.nextLine();

		AdminDao dao = new AdminDaoImpl();

		try {
			List<StationCrime> dtos = dao.getFIRByStationArea(Station_Area);

			dtos.forEach(dto -> System.out.println(dto));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
