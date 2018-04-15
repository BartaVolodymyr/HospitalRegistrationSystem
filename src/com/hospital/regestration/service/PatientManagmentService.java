package com.hospital.regestration.service;

import java.util.Scanner;

import com.hospital.regestration.domain.Patient;
import com.hospital.regestration.repository.PatientManagmentDAO;

public class PatientManagmentService {
	private static Scanner scanner = new Scanner(System.in);
	private PatientManagmentDAO patientManagmentDAO;

	public PatientManagmentService(PatientManagmentDAO patientManagmentDAO) {
		this.patientManagmentDAO = patientManagmentDAO;
	}

	public long getNextPatientId() {
		return patientManagmentDAO.getNextPatientId();
	}
	
	public Patient registerPatient() {
				
		System.out.println("Введіть ім'я: ");
		String firstName = scanner.nextLine();
		
		System.out.println("Введіть прізвеще: ");
		String lastName = scanner.nextLine();	
		
		if(firstName == null || lastName == null) {
			System.out.println("Ви ввели невірні дані!");
			return null;
		}
		
		long id = getNextPatientId();
		Patient patient = new Patient(id, firstName, lastName);
		patientManagmentDAO.getListPatients().add(patient);
		
		return patient;
	}
	
	public Patient getRegisteredPatient() {
		System.out.println("Введіть ваше ID: ");
		long id = scanner.nextLong();
		
		for(Patient patient: this.patientManagmentDAO.getListPatients()) {
			if(patient.getId() == id) {
				return patient;
			}
		}
		System.out.println("Пацієнт з ID: " + id + " не існує.");
		return null;
	}
	
}
