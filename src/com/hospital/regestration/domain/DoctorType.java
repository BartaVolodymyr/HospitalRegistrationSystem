package com.hospital.regestration.domain;

public enum DoctorType {
	DENTIST("dentist"), PEDIATRICIAN("pediatrician"), UROLOGIST("urologist");
	
	private String title;
	
	DoctorType(String title){
		this.title = title;
	}
	
	@Override
	public String toString() {
		return this.title;
	}
}
