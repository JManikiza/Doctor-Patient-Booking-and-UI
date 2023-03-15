package Project;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

//This class is the ViewConsultation GUI where the user will be presented with
//a dropdown menu to print to screen different patient consultations.

//Was working as of 28/12/2022, made a few changes but now it doesn't work.
//It won't help my score but if you do see my error please if you could add it to
//my marking as I have not got a clue, my IDE and multiple others show no errors,
//it compiles, but now doesn't seem to run ANY of the methods below...

public class ViewConsultation {

	public JFrame frameViewConsultation = new JFrame();


//Should launch the application
	public void main(String[] args) {

		EventQueue.invokeLater(() -> {
                    try {
                        System.out.println("View Consultation Running...");
                        
                        ViewConsultation viewConsultation = new ViewConsultation();
                        viewConsultation.frameViewConsultation.setVisible(true);
                    } catch (Exception e) {                                                
                    }
                });
	}

//Should create the application
	public void ViewConsultation() {
                System.out.println("View Consultation Running...");
		Initialize();
	}

//Should initialize the JFrame and the contents
	private void Initialize() {
		frameViewConsultation = new JFrame();
		frameViewConsultation.setTitle("View Consultation");
		frameViewConsultation.setBounds(100, 100, 666, 686);
		frameViewConsultation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameViewConsultation.getContentPane().setLayout(null);

                                       

                Menu menu = new Menu();
		List<Consultation> consultList = menu.consultationList;
		List<String> consults = new ArrayList<>();
		for (int i = 0; i < consultList.size(); i++) {

			consults.add(consultList.get(i).getPatient().getName());
		}
		frameViewConsultation.getContentPane().setLayout(null);

		JLabel lblDoctor = new JLabel("Patient");
		lblDoctor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDoctor.setBounds(84, 43, 94, 24);
		frameViewConsultation.getContentPane().add(lblDoctor);

		JComboBox cbPatient = new JComboBox(consults.toArray());
		cbPatient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbPatient.setBounds(258, 40, 206, 34);
		frameViewConsultation.getContentPane().add(cbPatient);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(119, 139, 345, 306);
		frameViewConsultation.getContentPane().add(textPane);

		JButton btnView = new JButton("View");
		btnView.addActionListener((ActionEvent e) -> {
                    int index = cbPatient.getSelectedIndex();
                    Consultation consultation = menu.consultationList.get(index);
                    
                    String richText = "";
                    richText += "Patient Name: " + consultation.getPatient().getName() + "\n";
                    richText += "Patient SurName: " + consultation.getPatient().getSurname() + "\n";
                    richText += "Patient Mobile: " + consultation.getPatient().getNumber() + "\n";
                    richText += "Patient Mobile: " + consultation.getPatient().getDOB() + "\n";
                    richText += "\n";
                    richText += "Consultation Cost: " + consultation.getCost() + "\n";
                    richText += "Consultation Time: " + consultation.getTime() + "\n";
                    richText += "Consultation Date: " + consultation.getDate() + "\n";
                    
                    
                    richText += "Consultation Notes: " + consultation.getNotes() + "\n";
                    textPane.setText(richText);
             });
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnView.setBounds(258, 508, 107, 25);
		frameViewConsultation.getContentPane().add(btnView);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener((ActionEvent e) -> {
                    frameViewConsultation.setVisible(false);
                    Menu menu1 = new Menu();
                 menu1.frameGUIMenu.setVisible(true);
             });
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(258, 543, 107, 25);
		frameViewConsultation.getContentPane().add(btnBack);
	}

}
        