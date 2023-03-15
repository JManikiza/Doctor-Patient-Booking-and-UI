package Project;


import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.Font;
import java.util.List;
import java.awt.event.ActionEvent;

//This class is for the GUI and after pressing the corresponding button will
//show the user Doctors that have been added from the console menu
public class DoctorsAvailable extends JFrame {

	public JFrame frameDoctorsAvailable = new JFrame();
	private JTable table;
	Object[] columns;

//Launch the application
	public void main(String[] args) {
                    frameDoctorsAvailable.setVisible(true);
               
	}

//Creates the application
	public DoctorsAvailable() {
		initialize();
	}

//Initializes the JFrame and its contents
	private void initialize() {
		frameDoctorsAvailable = new JFrame();
		frameDoctorsAvailable.setTitle("Doctors");
		frameDoctorsAvailable.setBounds(100, 100, 1112, 600);
		frameDoctorsAvailable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameDoctorsAvailable.getContentPane().setLayout(null);

		String[] column = {"S. No.",  "Name", "Surname", "DOB", "Mobile", "Expertize", "NHS Number" };
		
		DefaultTableModel tableModel = new DefaultTableModel(column, 0);
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setLocation(36, 27);
		table.setSize(1023, 417);
		List<Doctor> doctorArr = Main.doctorArr;
		for (int i = 0; i < doctorArr.size(); i++) {
			Object[] colValues = { i + 1, doctorArr.get(i).getName(), doctorArr.get(i).getSurname(),
					doctorArr.get(i).getDOB(), doctorArr.get(i).getNumber(), doctorArr.get(i).getExpertize(),
					doctorArr.get(i).getNhsNumber() };
			tableModel.addRow(colValues);
		}
		table.setModel(tableModel);
		
		frameDoctorsAvailable.getContentPane().add(table);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener((ActionEvent e) -> {
                    frameDoctorsAvailable.setVisible(false);
                    Menu menu = new Menu();
                    menu.frameGUIMenu.setVisible(true);
                });
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(489, 475, 107, 25);
		frameDoctorsAvailable.getContentPane().add(btnBack);
	}
}

