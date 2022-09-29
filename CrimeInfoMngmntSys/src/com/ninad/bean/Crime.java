package com.ninad.bean;

import java.sql.Date;
import java.util.List;

public class Crime {
	
	private Integer crime_Id;
	private String crime_Place;
	private Date crime_Date;
	private String crime_Description;
	private List<String> victims;
	private List<String> crime_Suspect;
	
	public Crime() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Crime(Integer crime_Id, String crime_Place, Date crime_Date, String crime_Description,
			List<String> victims, List<String> crime_Suspect) {
		super();
		this.crime_Id = crime_Id;
		this.crime_Place = crime_Place;
		this.crime_Date = crime_Date;
		this.crime_Description = crime_Description;
		this.victims = victims;
		this.crime_Suspect = crime_Suspect;
	}
	
	@Override
	public String toString() {
		return "CrimeBean [crime_Id=" + crime_Id + ", crime_Place=" + crime_Place + ", crime_Date=" + crime_Date
				+ ", crime_Description=" + crime_Description + ", victims=" + victims + ", crime_Suspect="
				+ crime_Suspect + "]";
	}
	
	public Integer getCrime_Id() {
		return crime_Id;
	}
	
	public void setCrime_Id(Integer crime_Id) {
		this.crime_Id = crime_Id;
	}
	
	public String getCrime_Place() {
		return crime_Place;
	}
	
	public void setCrime_Place(String crime_Place) {
		this.crime_Place = crime_Place;
	}
	
	public Date getCrime_Date() {
		return crime_Date;
	}
	
	public void setCrime_Date(Date crime_Date) {
		this.crime_Date = crime_Date;
	}
	
	public String getCrime_Description() {
		return crime_Description;
	}
	
	public void setCrime_Description(String crime_Description) {
		this.crime_Description = crime_Description;
	}
	
	public List<String> getVictims() {
		return victims;
	}
	
	public void setVictims(List<String> victims) {
		this.victims = victims;
	}
	
	public List<String> getCrime_Suspect() {
		return crime_Suspect;
	}
	
	public void setCrime_Suspect(List<String> crime_Suspect) {
		this.crime_Suspect = crime_Suspect;
	}
	
}
