package com.ninad.bean;

public class Inspector {
	
	private String inspector_Name;
	private Integer inspector_Id;
	
	public Inspector() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Inspector(String inspector_Name, int inspector_Id) {
		super();
		this.inspector_Name = inspector_Name;
		this.inspector_Id = inspector_Id;
	}
	
	@Override
	public String toString() {
		return "PoliceOfficerBean [inspector_Name=" + inspector_Name + ", inspector_Id=" + inspector_Id + "]";
	}
	
	public String getInspector_Name() {
		return inspector_Name;
	}
	
	public void setInspector_Name(String inspector_Name) {
		this.inspector_Name = inspector_Name;
	}
	
	public int getInspector_Id() {
		return inspector_Id;
	}
	
	public void setInspector_Id(int inspector_Id) {
		this.inspector_Id = inspector_Id;
	}
	
}
