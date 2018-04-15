package com.hospital.regestration.controller;

import java.util.Scanner;

import com.hospital.regestration.domain.Scheduel;
import com.hospital.regestration.repository.DoctorManagmentDAO;
import com.hospital.regestration.repository.PatientManagmentDAO;
import com.hospital.regestration.service.DoctorManagmentService;
import com.hospital.regestration.service.PatientManagmentService;

public class HospitalRegistrationSystem {
	
	private DoctorManagmentService doctorManagmentService;
	private PatientManagmentService patientManagmentService;
	
	

	public HospitalRegistrationSystem(DoctorManagmentService doctorManagmentService,
			PatientManagmentService patientManagmentService) {
		this.doctorManagmentService = doctorManagmentService;
		this.patientManagmentService = patientManagmentService;
	}

	public static void main(String[] args) {
		HospitalRegistrationSystem hospitalRegistrationSystem = 
				new HospitalRegistrationSystem(new DoctorManagmentService(new Scheduel(), new DoctorManagmentDAO()),
											   new PatientManagmentService(new PatientManagmentDAO()));
		
		HospitalRegistrationController controller = new HospitalRegistrationController(hospitalRegistrationSystem.getDoctorManagmentService(), hospitalRegistrationSystem.patientManagmentService);
		
		int choice = -1;
		
		System.out.println("Ласкаво просимо до реєстратури лікарні.");
		
		do{
			System.out.println("\n\t***Головне меню***"); 
			System.out.println("Якщо Ви хочете обрати лікаря - введіть: 1");
			System.out.println("Якщо Ви хочете побачити список лікарів - введіть: 2");
			System.out.println("Якщо Ви хочете зареєструватися - введіть: 3");
			System.out.println("Якщо Ви хочете закінчити роботу - введіть: -1");
			Scanner scanner = new Scanner(System.in);
			
			try {
				choice = scanner.nextInt();
			}catch(Exception e) {
			}
			
			switch(choice) {
				case 1:
					controller.findDoctor();
					break;
				case 2:
					controller.showAllDoctors();
					break;
				case 3:
					controller.registration();
					break;				
			}
			
		}while(choice != -1);
		
		
	}
	
	public DoctorManagmentService getDoctorManagmentService() {
		return doctorManagmentService;
	}

	public void setDoctorManagmentService(DoctorManagmentService doctorManagmentService) {
		this.doctorManagmentService = doctorManagmentService;
	}

}
