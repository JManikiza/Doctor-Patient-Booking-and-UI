package Project;


public class Patient extends PatientDetails {

	private int ID;


	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public Patient(String name, String surname, String DOB, String number) {
		super(name, surname, DOB, number);
		
	}
	
}
