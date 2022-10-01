package com.masai.AdminUseCase;

import com.masai.AdminDao.AdminDaoImpl;
import com.masai.AdminDao.AdminDao;

public class CountUnsolvedFIR {

	public static void main(String[] args) {
		
		AdminDao ad = new AdminDaoImpl();
		String s = ad.numberOfUnsolvedFIR();
		System.out.println(s);
		
	}

}
