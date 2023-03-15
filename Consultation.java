package Project;

import java.time.*;


//This class receives the information stored from other classes and also gets read
//through other classes
public class Consultation {

	private LocalDate date;
	private LocalTime time;
	private String cost;
	private String notes;
	private Patient patient;
	private Doctor doctor;

	public Consultation(LocalDate date, LocalTime time, String cost, String notes, Patient patient, Doctor doctor) {
		super();
		this.date = date;
		this.time = time;
		this.cost = cost;
		this.notes = notes;
		this.patient = patient;
		this.doctor = doctor;
	}
//Standard get/set methods
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
