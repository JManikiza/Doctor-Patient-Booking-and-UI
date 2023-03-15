package Project;


import javax.swing.*;
import java.util.List;
import java.awt.event.*;
import java.awt.*;

import java.util.ArrayList;

//This class is the initial GUI where the user will see four buttons that will
//take them to the right class they need.

public class Menu extends JFrame {

    public JFrame frameGUIMenu = new JFrame();
    public List<Consultation> consultationList = new ArrayList<>();

//Launch Menu application
	public static void main(String[] args) {
            
            WestminsterSkinConsultationManager doctor = new WestminsterSkinConsultationManager();
            Menu menu = new Menu();
            menu.frameGUIMenu.setVisible(true);
            doctor.Load();
        }



//Creates Menu Application
	public Menu() {
                System.out.println("Menu running...");
		Initialize();
	}

//Initialize the JFrame and its contents
	private void Initialize() {
             frameGUIMenu = new JFrame();
		frameGUIMenu.setTitle("Client Menu");
		frameGUIMenu.setBounds(100, 100, 483, 444);
		frameGUIMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGUIMenu.getContentPane().setLayout(null);

		JButton btnViewDoctors = new JButton("View Doctors");
		btnViewDoctors.addActionListener((ActionEvent e) -> {
                    frameGUIMenu.setVisible(false);
                                
                    DoctorsAvailable doctorsAvail = new DoctorsAvailable();
                    doctorsAvail.frameDoctorsAvailable.setVisible(true);
             });
		btnViewDoctors.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewDoctors.setBounds(117, 55, 242, 54);
		frameGUIMenu.getContentPane().add(btnViewDoctors);

		JButton btnAddConsultation = new JButton("Add Consultation");
		btnAddConsultation.addActionListener((ActionEvent e) -> {
                    frameGUIMenu.setVisible(false);
                    AddConsultation addConsultation = new AddConsultation();
                    addConsultation.frameAddConsultation.setVisible(true);
             });
		btnAddConsultation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddConsultation.setBounds(117, 119, 242, 53);
		frameGUIMenu.getContentPane().add(btnAddConsultation);


		JButton btnViewConsultation = new JButton("View Consultation");
		btnViewConsultation.addActionListener((ActionEvent e) -> {
                    
                    frameGUIMenu.setVisible(false);
                    ViewConsultation viewConsultation = new ViewConsultation();
                    viewConsultation.frameViewConsultation.setVisible(true);                    
             });
		btnViewConsultation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewConsultation.setBounds(117, 182, 242, 49);
		frameGUIMenu.getContentPane().add(btnViewConsultation);

		JButton btnHide = new JButton("Hide");
		btnHide.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHide.addActionListener((ActionEvent e) -> {
                    frameGUIMenu.setVisible(false);

             });
		btnHide.setBounds(117, 241, 242, 49);
		frameGUIMenu.getContentPane().add(btnHide);
	}
}
