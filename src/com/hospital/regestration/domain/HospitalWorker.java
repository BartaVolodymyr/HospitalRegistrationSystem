package com.hospital.regestration.domain;

public abstract class HospitalWorker {
	
	private long id;
	private String firstName;
	private String lastName;
	private long salaryPerMonth;
	
		
	public HospitalWorker(long id, String firstName, String lastName, long salaryPerMonth) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salaryPerMonth = salaryPerMonth;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getSalaryPerMonth() {
		return salaryPerMonth;
	}

	public void setSalaryPerMonth(long salaryPerMonth) {
		this.salaryPerMonth = salaryPerMonth;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + (int) (salaryPerMonth ^ (salaryPerMonth >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HospitalWorker other = (HospitalWorker) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (salaryPerMonth != other.salaryPerMonth)
			return false;
		return true;
	}

}
