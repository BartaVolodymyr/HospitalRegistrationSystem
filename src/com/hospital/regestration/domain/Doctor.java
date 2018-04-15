package com.hospital.regestration.domain;

public class Doctor extends HospitalWorker {
	
	private DoctorType doctorType;
	
	public Doctor(long id, String firstName, String lastName, long salaryPerMonth, DoctorType doctorType) {
		super(id, firstName, lastName, salaryPerMonth);
		this.doctorType = doctorType;
	}

	public DoctorType getDoctorType() {
		return doctorType;
	}

	public void setDoctorType(DoctorType doctorType) {
		this.doctorType = doctorType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((doctorType == null) ? 0 : doctorType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (doctorType != other.doctorType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getFirstName() + " " + this.getLastName();
	}
	
	

}
