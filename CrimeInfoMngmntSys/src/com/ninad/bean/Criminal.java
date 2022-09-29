package com.ninad.bean;

public class Criminal {

	private Integer c_Id;
	private String c_Name;
	private Integer c_Age;
	private String c_Gender;
	private String c_Address;
	private String c_identification;
	private String crime_Type;
	private String crime_Date;
	
	public Criminal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Criminal(int c_Id, String c_Name, int c_Age, String c_Gender, String c_Address, String c_identification,
			String crime_Type, String crime_Date) {
		super();
		this.c_Id = c_Id;
		this.c_Name = c_Name;
		this.c_Age = c_Age;
		this.c_Gender = c_Gender;
		this.c_Address = c_Address;
		this.c_identification = c_identification;
		this.crime_Type = crime_Type;
		this.crime_Date = crime_Date;
	}

	@Override
	public String toString() {
		return "Criminal [c_Id=" + c_Id + ", c_Name=" + c_Name + ", c_Age=" + c_Age + ", c_Gender=" + c_Gender
				+ ", c_Address=" + c_Address + ", c_identification=" + c_identification + ", crime_Type=" + crime_Type
				+ ", crime_Date=" + crime_Date + "]";
	}

	public int getC_Id() {
		return c_Id;
	}
	
	public void setC_Id(int c_Id) {
		this.c_Id = c_Id;
	}
	
	public String getC_Name() {
		return c_Name;
	}
	
	public void setC_Name(String c_Name) {
		this.c_Name = c_Name;
	}
	
	public int getC_Age() {
		return c_Age;
	}
	
	public void setC_Age(int c_Age) {
		this.c_Age = c_Age;
	}
	
	public String getC_Gender() {
		return c_Gender;
	}
	
	public void setC_Gender(String c_Gender) {
		this.c_Gender = c_Gender;
	}
	
	public String getC_Address() {
		return c_Address;
	}
	
	public void setC_Address(String c_Address) {
		this.c_Address = c_Address;
	}
	
	public String getC_identification() {
		return c_identification;
	}
	
	public void setC_identification(String c_identification) {
		this.c_identification = c_identification;
	}
	
	public String getCrime_Type() {
		return crime_Type;
	}
	
	public void setCrime_Type(String crime_Type) {
		this.crime_Type = crime_Type;
	}
	
	public String getCrime_Date() {
		return crime_Date;
	}
	
	public void setCrime_Date(String crime_Date) {
		this.crime_Date = crime_Date;
	}

}
