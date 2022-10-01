package com.masai.AdminUseCase;

import com.masai.AdminDao.AdminDao;
import com.masai.AdminDao.AdminDaoImpl;

public class CountSolvedFIR {

	public static void main(String[] args) {
		
		AdminDao ad = new AdminDaoImpl();
		String s = ad.numberOfSolvedFIR();
		System.out.println(s);
		
	}

}
