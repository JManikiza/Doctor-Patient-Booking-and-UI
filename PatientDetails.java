package Project;


//This class receives the information stored from other classes and also gets read
//through other classes
public class PatientDetails {

	private String name;
	private String surname;
	private String DOB;
	private String number;

        public PatientDetails(String name, String surname, String DOB, String number) {
		super();
		this.name = name;
		this.surname = surname;
		this.DOB = DOB;
		this.number = number;
	}
        
//Standard get/set methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}


}
