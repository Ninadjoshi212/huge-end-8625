package com.masai.AdminDao;

import java.util.List;

import com.masai.Bean.Crime;
import com.masai.Bean.PoliceOfficer;
import com.masai.Bean.Police_Station;
import com.masai.Bean.StationCrime;
import com.masai.Bean.StationCriminal;
import com.masai.Exceptions.CrimeException;
import com.masai.Exceptions.OfficerException;
import com.masai.Exceptions.Police_StationException;

public interface AdminDao {
	
	public String registerPoliceStation(Police_Station police);
	
	public String registerOfficers(PoliceOfficer officer);
	
	public String registerOfficerToStation(Integer officer_Id, Integer station_Id) throws OfficerException, Police_StationException;
	
	public List<StationCriminal> getCriminalsByStationArea(String PoliceStation_Area) throws Police_StationException;
	
	public List<StationCrime> getFIRByStationArea(String PoliceStation_Area) throws Police_StationException;

	public void detailedListOfFIR();
	
	public String countNumberOfFIRInCurrentMonth();
	
	public String numberOfSolvedFIR();
	
	public String numberOfUnsolvedFIR();
	
	public String checkStatusOfFIR(int crime_id) throws CrimeException;

}
