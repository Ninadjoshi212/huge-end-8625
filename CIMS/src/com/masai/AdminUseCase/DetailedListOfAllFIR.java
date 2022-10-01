package com.masai.AdminUseCase;

import com.masai.AdminDao.AdminDao;
import com.masai.AdminDao.AdminDaoImpl;

public class DetailedListOfAllFIR {

	public static void main(String[] args) {

		AdminDao ad = new AdminDaoImpl();

		ad.detailedListOfFIR();

	}

}
