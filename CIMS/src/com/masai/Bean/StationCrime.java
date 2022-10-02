package com.masai.Bean;

public class StationCrime {
	
	private int crime_Id;
	private String name_Of_Crime;
	private int victims;
	private String detdesc;
	private String sus;
	private String PoliceStation_Name;
	private String PoliceStation_Area;
	
	public StationCrime() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StationCrime(int crime_Id, String name_Of_Crime, int victims, String detdesc, String sus,
			String policeStation_Name, String policeStation_Area) {
		super();
		this.crime_Id = crime_Id;
		this.name_Of_Crime = name_Of_Crime;
		this.victims = victims;
		this.detdesc = detdesc;
		this.sus = sus;
		PoliceStation_Name = policeStation_Name;
		PoliceStation_Area = policeStation_Area;
	}

	@Override
	public String toString() {
		return "\ncrime_Id=" + crime_Id + "\nname_Of_Crime=" + name_Of_Crime
				+ "\nvictims=" + victims + "\ndetdesc=" + detdesc
				+ "\nsus=" + sus + ", PoliceStation_Name=" + PoliceStation_Name
				+ "\nPoliceStation_Area=" + PoliceStation_Area + "\n";
	}
	
	public int getCrime_Id() {
		return crime_Id;
	}
	public void setCrime_Id(int crime_Id) {
		this.crime_Id = crime_Id;
	}
	public String getName_Of_Crime() {
		return name_Of_Crime;
	}
	public void setName_Of_Crime(String name_Of_Crime) {
		this.name_Of_Crime = name_Of_Crime;
	}
	public int getVictims() {
		return victims;
	}
	public void setVictims(int victims) {
		this.victims = victims;
	}
	public String getDetdesc() {
		return detdesc;
	}
	public void setDetdesc(String detdesc) {
		this.detdesc = detdesc;
	}
	public String getSus() {
		return sus;
	}
	public void setSus(String sus) {
		this.sus = sus;
	}
	public String getPoliceStation_Name() {
		return PoliceStation_Name;
	}
	public void setPoliceStation_Name(String policeStation_Name) {
		PoliceStation_Name = policeStation_Name;
	}
	public String getPoliceStation_Area() {
		return PoliceStation_Area;
	}
	public void setPoliceStation_Area(String policeStation_Area) {
		PoliceStation_Area = policeStation_Area;
	}

}
