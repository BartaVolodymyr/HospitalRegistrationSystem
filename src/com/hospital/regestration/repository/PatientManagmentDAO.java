package com.hospital.regestration.repository;

import java.util.ArrayList;
import java.util.List;

import com.hospital.regestration.domain.Patient;

public class PatientManagmentDAO {
	private long nextId = 0;
	private List<Patient> listPatients;
	
	public PatientManagmentDAO() {
		listPatients = new ArrayList<>();
		listPatients.add(new Patient(nextId++, "Vasia", "Pupkin"));
		listPatients.add(new Patient(nextId++, "Ivan", "Petrov"));
		listPatients.add(new Patient(nextId++, "Igor", "Petrenko"));
	}
	
	public long getNextPatientId() {
		return nextId++;
	}
	
	public List<Patient> getListPatients() {
		return listPatients;
	}
	
}
