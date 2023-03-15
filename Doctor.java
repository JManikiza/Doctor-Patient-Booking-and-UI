package Project;


public class Doctor extends PatientDetails {

	private String expertize;
	private String nhsNumber;
	private boolean free = false;

	
	public Doctor(String name, String surname, String DOB, String number, String expertize,
			String nhsNumber) {
		super(name, surname, DOB, number);
		this.expertize = expertize;
		this.nhsNumber = nhsNumber;
	}

	public String getExpertize() {
		return expertize;
	}

	public void setExpertize(String expertize) {
		this.expertize = expertize;
	}

	public String getNhsNumber() {
		return nhsNumber;
	}

	public void setNhsNumber(String nhsNumber) {
		this.nhsNumber = nhsNumber;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	@Override
	public String toString() {
		return getName() + " " + getSurname() + " " + getDOB() + " " + getNumber() + " " + getExpertize() + " "
				+ getNhsNumber();
	}

	public String toCommaSeparatedString() {
		return getName() + ", " + getSurname() + ", " + getDOB() + ", " + getNumber() + ", " + getExpertize()
				+ ", " + getNhsNumber();
	}

}
