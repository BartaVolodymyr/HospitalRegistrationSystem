package com.hospital.regestration.controller;

import java.util.List;
import java.util.Scanner;

import com.hospital.regestration.domain.Doctor;
import com.hospital.regestration.domain.DoctorType;
import com.hospital.regestration.domain.Patient;
import com.hospital.regestration.service.DoctorManagmentService;
import com.hospital.regestration.service.PatientManagmentService;

public class HospitalRegistrationController {
	private static Scanner scanner = new Scanner( System.in );
	
	private DoctorManagmentService doctorManagmentService;
	private PatientManagmentService patientManagmentService;
		
	
	
	public HospitalRegistrationController(DoctorManagmentService doctorManagmentService, PatientManagmentService patientManagmentService) {
		this.doctorManagmentService = doctorManagmentService;
		this.patientManagmentService = patientManagmentService;
	}

	
	public void findDoctor() {
		DoctorType doctorType = this.selectDoctorTypes();
		if(doctorType == null) return;
		Doctor desiredDoctor = findDesiredDoctor(doctorType);
		if(desiredDoctor == null) return;
		if(doctorManagmentService.isDoctorAvailable(desiredDoctor)) {
			signup(desiredDoctor);
		}else {
			System.out.println(desiredDoctor + " зайнятий. Виберіть іншого лікаря.");
			return;
		}
	}
	
	public void showAllDoctors() {
		System.out.println("\n\t***Список лікарів***");
		List<Doctor> doctors = doctorManagmentService.getAllDoctors();
		System.out.printf("%2s %20s %20s", "№", "ПІ лікаря", "Спеціалізація\n");
		for(Doctor doctor: doctors) {
			System.out.format("%2d %20s %20s\n", doctor.getId(), (doctor.getFirstName() + " " + doctor.getLastName()),
					doctor.getDoctorType().toString());
		}
	}
	
	public void registration() {
		Patient patient = patientManagmentService.registerPatient();
		System.out.println("\nВи(" + patient + ") успішно зареєструвалися. Ваш ID: " + patient.getId());
	}

	private DoctorType selectDoctorTypes() {
		System.out.println("\nДо якого спеціаліста Ви бажаєте звернутися?");
		System.out.println("Введіть відповідний код:");
		
		for(DoctorType doctorType: doctorManagmentService.getAllTypesOfDoctors()) {
			System.out.println(doctorType.ordinal() + " - " + doctorType);
		}
		System.out.println("Для повернення до основного меню введіть: -1");
		int choice = receiveInputFromUser(0, doctorManagmentService.getAllTypesOfDoctors().length);
		if(choice == -1) return null;
	
		return DoctorType.values()[choice];
		
	}
	
	private Doctor findDesiredDoctor(DoctorType doctorType) {
		List<Doctor> doctors = doctorManagmentService.getSpecficTypeDoctors(doctorType);
		System.out.println("\nДо якого " + doctorType.toString().toUpperCase() + " Ви хочете звернутися?");
		System.out.println("Введіть відповідний код::");
		
		for(int i = 0; i < doctors.size(); i++) {
			System.out.println(i + " - " + doctors.get(i));
		}
		System.out.println("Для повернення до основного меню - введіть: -1");
		int selectedDoctorCode = receiveInputFromUser(0, doctors.size());
		if(selectedDoctorCode == -1) return null;
				
		return doctors.get(selectedDoctorCode);
	}
	
	public void signup(Doctor doctor) {
		System.out.println("\nЯкщо Ви зареєстровані - натисніть - 0");
		System.out.println("Якщо не зареєстровані - натисніть - 1");
		int choice = receiveInputFromUser(0, 2);
		
		
		Patient patient = null;
		switch(choice) {
			case 0:
				patient = patientManagmentService.getRegisteredPatient();
				if(patient == null) {
					return;
				}
				System.out.println("\nВи успішно увійшли.");
				break;
			case 1:
				patient = patientManagmentService.registerPatient();
				System.out.println("\nВи(" + patient + ") успішно зареєструвалтся. Ваш ID: " + patient.getId());
				break;
			default:
				return;
		}
		
		int num = doctorManagmentService.addPatientToScheduel(doctor, patient);
		System.out.println("Ви(" + patient + ") записані на прийом до " + doctor + ". Номер Вашого талона - " + num);
	}
	
	private int receiveInputFromUser(int beginConstraint, int endConstraint) {
		int choice = -1;
				
		if(scanner.hasNextInt()) {
			choice = scanner.nextInt();
		}
		
		if((choice >= beginConstraint && choice < endConstraint) || choice == -1) {
			return choice;
		}else {
			System.out.println("Ви ввели неправильний код. Код не повинен бути меншим '-1' і більшим " + (endConstraint-1));
		}
		return -1;
	}
	
	
}
