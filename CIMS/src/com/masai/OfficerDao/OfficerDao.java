package com.masai.OfficerDao;

import java.util.List;

import com.masai.Bean.Crime;
import com.masai.Bean.Criminal;
import com.masai.Exceptions.CrimeException;
import com.masai.Exceptions.CriminalException;

public interface OfficerDao {
	
	public String registerFIR(Crime c);
	
	public List<Crime> getAllFIR() throws CrimeException;

	public String registerCriminalToCrime(int crime_id, int criminal_id) throws CrimeException, CriminalException;

	public void searchCrimeByCriminal(int crime_id, int criminal_id) throws CrimeException, CriminalException;

	public String deleteCrimeByCriminalId(int crime_id, int criminal_id) throws CriminalException, CrimeException;
	
	public String deleteCrimeNotMappedToCriminal(int id);
	
	public String deleteCrimeMappedToCriminal(int id) throws CrimeException;
	
	public String updateStatusOfFIR(int crime_id, String value) throws CrimeException;
	
	public Crime searchFIRByID(int id) throws CrimeException;

	public List<Crime> searchFIRByCrimeType(String s) throws CrimeException;
	
	public String addCriminalDetails(Criminal c);

	public List<Criminal> getAllCriminals() throws CriminalException;

	public String deleteCriminalMappedToCrime(int id) throws CriminalException;

	public String deleteCriminalNotMappedToCrime(int id);

	public Criminal searchCriminalByID(int id) throws CriminalException;
	
	public List<Criminal> searchCriminalByName(String s) throws CriminalException;
	
	public List<Crime> detailsOfSolvedFIR() throws CrimeException;
	
	public List<Crime> detailsOfUnsolvedFIR() throws CrimeException;


}
