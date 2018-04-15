package com.hospital.regestration.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hospital.regestration.repository.DoctorManagmentDAO;

public class Scheduel {
	public final static int MAX_PATIENT_PER_SHIFT = 15;
	
	
	private Map<Doctor, ArrayList<Patient>> timesheet;
	
	public Scheduel() {
		timesheet = new HashMap<>();
	}
	
	public void populateTimesheet(List<Doctor> doctors) {
		for(Doctor doctor: doctors) {
			timesheet.put(doctor, new ArrayList<>());
		}
	}
	public Map<Doctor, ArrayList<Patient>> getTimesheet(){
		return this.timesheet;
	}
}
