package com.hospital.regestration.repository;

import java.util.ArrayList;
import java.util.List;

import com.hospital.regestration.domain.Doctor;
import com.hospital.regestration.domain.DoctorType;

public class DoctorManagmentDAO {
	private List<Doctor> listOfDoctors;
	
	public DoctorManagmentDAO() {
		listOfDoctors = new ArrayList<>();
		listOfDoctors.add(new Doctor(1, "Victor", "Petrenko", 7000, DoctorType.PEDIATRICIAN));
		listOfDoctors.add(new Doctor(2, "Petro", "Poroshenko", 4000, DoctorType.UROLOGIST));
		listOfDoctors.add(new Doctor(3, "Yulia", "Tymoshenko", 3000, DoctorType.UROLOGIST));
		listOfDoctors.add(new Doctor(4, "Arsenii", "Yacenuk", 7000, DoctorType.PEDIATRICIAN));
		listOfDoctors.add(new Doctor(5, "Arsen", "Avakow", 2000, DoctorType.DENTIST));
		listOfDoctors.add(new Doctor(6, "Dmytro", "Yarosh", 9000, DoctorType.DENTIST));
	}

	public void setListOfDoctors(List<Doctor> listOfDoctors) {
		this.listOfDoctors = listOfDoctors;
	}
	
	public List<Doctor> getListOfDoctors(){
		return listOfDoctors;
	}
}
