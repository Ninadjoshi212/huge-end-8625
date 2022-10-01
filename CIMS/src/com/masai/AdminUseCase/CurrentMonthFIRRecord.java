package com.masai.AdminUseCase;

import com.masai.AdminDao.AdminDao;
import com.masai.AdminDao.AdminDaoImpl;

public class CurrentMonthFIRRecord {

	public static void main(String[] args) {
	
		AdminDao ad = new AdminDaoImpl();
		String count = ad.countNumberOfFIRInCurrentMonth();
		System.out.println(count);
	
	}

}
