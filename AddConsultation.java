package Project;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.*;
import java.util.ArrayList;
import javax.swing.*;

//This class is the AddConsultation GUI where the user will be presented with
//text fields to fill out. At the moment the text fields can be filled with 
//any characters but not 'consultationDate' and 'consultationTime'

public class AddConsultation extends JFrame {

	protected static final String AESUtil = null;
	public JFrame frameAddConsultation = new JFrame();
	private JTextField patientName;
	private JTextField patientSurname;
	private JTextField patientDOB;
	private JTextField patientNumber;
	private JTextField consultationDate;
	private JTextField consultationTime;
	private JTextField notes;

//Launches the JFrame window
	public void main(String[] args) {
            EventQueue.invokeLater(() -> {
                AddConsultation window = new AddConsultation();
                window.frameAddConsultation.setVisible(true);
            });
	}

//Creates the application
	public AddConsultation() {
		initialize();
	}

//Initializes the JFrame contents
//Stores user input to varibles to be read by 'ViewConsultations' class
	private void initialize() {
            
         
		frameAddConsultation = new JFrame();
		frameAddConsultation.setTitle("Add Consultation");
		frameAddConsultation.setBounds(100, 100, 696, 698);
		frameAddConsultation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAddConsultation.getContentPane().setLayout(null);

		JLabel labelDoctor = new JLabel("Doctor");
		labelDoctor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelDoctor.setBounds(93, 74, 94, 24);
		frameAddConsultation.getContentPane().add(labelDoctor);

		java.util.List<Doctor> doctorList = Main.doctorArr;
		java.util.List<String> doctorConsultationList = new ArrayList<>();
		for (int i = 0; i < doctorList.size(); i++) {
			doctorConsultationList.add(doctorList.get(i).getNhsNumber() + "@" + doctorList.get(i).getName());
		}
		JComboBox<?> cbDoctor = new JComboBox<>(doctorConsultationList.toArray());
		cbDoctor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbDoctor.setBounds(267, 71, 206, 34);
		frameAddConsultation.getContentPane().add(cbDoctor);

		JLabel labelPatientName = new JLabel("Patient Name");
		labelPatientName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelPatientName.setBounds(93, 145, 94, 24);
		frameAddConsultation.getContentPane().add(labelPatientName);

		patientName = new JTextField();
		patientName.setBounds(267, 143, 206, 34);
		frameAddConsultation.getContentPane().add(patientName);
		patientName.setColumns(10);

		JLabel labelSurname = new JLabel("Patient Surname");
		labelSurname.setBounds(93, 212, 94, 24);
		frameAddConsultation.getContentPane().add(labelSurname);
		labelSurname.setFont(new Font("Tahoma", Font.PLAIN, 14));

		patientSurname = new JTextField();
		patientSurname.setColumns(10);
		patientSurname.setBounds(267, 202, 206, 34);
		frameAddConsultation.getContentPane().add(patientSurname);

		JLabel lblDOB = new JLabel("Date Of Birth");
		lblDOB.setBounds(93, 272, 94, 24);
		frameAddConsultation.getContentPane().add(lblDOB);
		lblDOB.setFont(new Font("Tahoma", Font.PLAIN, 14));

		patientDOB = new JTextField();
		patientDOB.setColumns(10);
		patientDOB.setBounds(267, 262, 206, 34);
		frameAddConsultation.getContentPane().add(patientDOB);

		JLabel labelContact = new JLabel("Contact No.");
		labelContact.setBounds(93, 326, 94, 24);
		frameAddConsultation.getContentPane().add(labelContact);
		labelContact.setFont(new Font("Tahoma", Font.PLAIN, 14));

		patientNumber= new JTextField();
		patientNumber.setColumns(10);
		patientNumber.setBounds(267, 316, 206, 34);
		frameAddConsultation.getContentPane().add(patientNumber);

		JButton buttonBook = new JButton("Book");
		buttonBook.addActionListener((ActionEvent e) -> {
                    Patient patient = new Patient(patientName.getText(), patientSurname.getText(), patientDOB.getText(),
                            patientNumber.getText());
                    LocalDate conDate = LocalDate.parse(consultationDate.getText());
                    LocalTime conTime = LocalTime.parse(consultationTime.getText());
                    String notes1 = "";
                    String cost = "";
                    int index = cbDoctor.getSelectedIndex();
                    if (index == 0) {
                        cost = "£15";
                    } else {
                        cost = "£25";
                    }
                    String[] selectedDoctor = cbDoctor.getSelectedItem().toString().trim().split("@", 2);
                    Doctor doctor = null;
                    for (int i = 0; i < Main.doctorArr.size(); i++) {
                        if (Main.doctorArr.get(i).getNhsNumber().trim()
                                .equals(selectedDoctor[0])) {
                            doctor = Main.doctorArr.get(i);
                            break;
                            
                        }
                    }
                    Consultation consultation = new Consultation(conDate, conTime, cost, notes1, new Patient(
                            patientName.getText(), patientSurname.getText(), patientDOB.getText(), patientNumber.getText()), doctor);
                    Menu menu = new Menu();
                    menu.consultationList.add(consultation);
                    JOptionPane.showMessageDialog(frameAddConsultation, "Consultation added.");
                });
		buttonBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonBook.setBounds(244, 573, 107, 25);
		frameAddConsultation.getContentPane().add(buttonBook);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener((ActionEvent e) -> {
                    frameAddConsultation.setVisible(false);
                    Menu menu = new Menu();
                    menu.frameGUIMenu.setVisible(true);
                });
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(244, 608, 107, 25);
		frameAddConsultation.getContentPane().add(btnBack);

		consultationDate = new JTextField();
		consultationDate.setColumns(10);
		consultationDate.setBounds(267, 374, 206, 34);
		frameAddConsultation.getContentPane().add(consultationDate);

		JLabel labelConsultationDate = new JLabel("Consultation Date");
		labelConsultationDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelConsultationDate.setBounds(93, 384, 148, 24);
		frameAddConsultation.getContentPane().add(labelConsultationDate);

		consultationTime = new JTextField();
		consultationTime.setColumns(10);
		consultationTime.setBounds(267, 430, 206, 34);
		frameAddConsultation.getContentPane().add(consultationTime);

		JLabel labelConsultationTime = new JLabel("Consultation Time");
		labelConsultationTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelConsultationTime.setBounds(93, 440, 148, 24);
		frameAddConsultation.getContentPane().add(labelConsultationTime);

		JLabel labelTime = new JLabel("e.g. 14:00");
		labelTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelTime.setBounds(483, 430, 148, 24);
		frameAddConsultation.getContentPane().add(labelTime);

		JLabel labelDate = new JLabel("e.g. yyyy-mm-dd");
		labelDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelDate.setBounds(483, 374, 148, 24);
		frameAddConsultation.getContentPane().add(labelDate);

		JLabel labelNotes = new JLabel("Notes");
		labelNotes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNotes.setBounds(93, 497, 148, 24);
		frameAddConsultation.getContentPane().add(labelNotes);

		notes = new JTextField();
		notes.setColumns(10);
		notes.setBounds(267, 487, 206, 34);
		frameAddConsultation.getContentPane().add(notes);
	}

}
