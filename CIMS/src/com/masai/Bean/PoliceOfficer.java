package com.masai.Bean;

public class PoliceOfficer {

	Integer officer_Id;
	String officer_Name;
	String officer_Username;
	String officer_Password;
	String officer_Rank;
	String dateOfJoining;
	Integer station_id;
	
	public PoliceOfficer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PoliceOfficer(Integer officer_Id, String officer_Name, String officer_Username, String officer_Password, String officer_Rank, String dateOfJoining, Integer station_id) {
		super();
		this.officer_Id = officer_Id;
		this.officer_Name = officer_Name;
		this.officer_Username = officer_Username;
		this.officer_Password = officer_Password;
		this.officer_Rank = officer_Rank;
		this.dateOfJoining = dateOfJoining;
		this.station_id = station_id;
	}

	@Override
	public String toString() {
		return "PoliceOfficer \n[ officerId= " + officer_Id
				+ "\n, officer_Name= " + officer_Name
				+ "\n, officer_Username= " + officer_Username
				+ "\n, officer_Password= " + officer_Password
				+ "\n, officer_Rank= " + officer_Rank
				+ "\n, DateOfJoining= " + dateOfJoining
				+ "\n, Allocated to Station Id= " + station_id
				+ " ]";
	}

	public Integer getOfficer_Id() {
		return officer_Id;
	}
	
	public void setOfficer_Id(Integer officer_Id) {
		this.officer_Id = officer_Id;
	}
	
	public String getOfficer_Name() {
		return officer_Name;
	}

	public void setOfficer_Name(String officer_Name) {
		this.officer_Name = officer_Name;
	}
	
	public String getOfficer_Username() {
		return officer_Username;
	}
	
	public void setOfficer_Username(String officer_Username) {
		this.officer_Username = officer_Username;
	}
	
	public String getOfficer_Password() {
		return officer_Password;
	}
	
	public void setOfficer_Password(String officer_Password) {
		this.officer_Password = officer_Password;
	}

	public String getOfficer_Rank() {
		return officer_Rank;
	}

	public void setOfficer_Rank(String officer_Rank) {
		this.officer_Rank = officer_Rank;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Integer getStation_id() {
		return station_id;
	}

	public void setStation_id(Integer station_id) {
		this.station_id = station_id;
	}

}
