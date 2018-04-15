package com.hospital.regestration.service;

import java.util.ArrayList;
import java.util.List;

import com.hospital.regestration.domain.Doctor;
import com.hospital.regestration.domain.DoctorType;
import com.hospital.regestration.domain.Patient;
import com.hospital.regestration.domain.Scheduel;
import com.hospital.regestration.repository.DoctorManagmentDAO;

public class DoctorManagmentService {
	
	private Scheduel scheduel;
	private DoctorManagmentDAO doctorManagmentDAO;
	
	public DoctorManagmentService(Scheduel scheduel, DoctorManagmentDAO doctorManagmentDAO) {
		super();
		this.scheduel = scheduel;
		this.doctorManagmentDAO = doctorManagmentDAO;
		this.scheduel.populateTimesheet(this.doctorManagmentDAO.getListOfDoctors());
	}

	public List<Doctor> getSpecficTypeDoctors(DoctorType doctorType) {
		List<Doctor> result = new ArrayList<>();
		for(Doctor doctor: doctorManagmentDAO.getListOfDoctors()) {
			if(doctor.getDoctorType().equals(doctorType)) {
				result.add(doctor);
			}
		}
		return result;
	}
	
	public List<Doctor> getAllDoctors(){
		return doctorManagmentDAO.getListOfDoctors();
	}
	
	
	
	public DoctorManagmentDAO getDoctorManagmentDAO() {
		return doctorManagmentDAO;
	}

	public void setDoctorManagmentDAO(DoctorManagmentDAO doctorManagmentDAO) {
		this.doctorManagmentDAO = doctorManagmentDAO;
	}

	public Doctor getDoctorById(long doctorId) {
		for(Doctor doctor: doctorManagmentDAO.getListOfDoctors()) {
			if(doctor.getId() == doctorId) {
				return doctor;
			}
		}
		return null;
	}
	
	public DoctorType[] getAllTypesOfDoctors() {
		return DoctorType.values();
	}
	
	public boolean isDoctorAvailable(Doctor doctor) {
		if(getDoctorById(doctor.getId()) == null) {
			return false;
		}
		List<Patient> listPatients = scheduel.getTimesheet().get(doctor);
		if(listPatients.size() < Scheduel.MAX_PATIENT_PER_SHIFT) {
			return true;
		}else {
			return false;
		}
	}
	
	public int addPatientToScheduel(Doctor doctor, Patient patient) {
		List<Patient> patients = scheduel.getTimesheet().get(doctor);
		patients.add(patient);
		return patients.size();
	}

	public Scheduel getScheduel() {
		return scheduel;
	}

	public void setScheduel(Scheduel scheduel) {
		this.scheduel = scheduel;
	}
	
	
}
