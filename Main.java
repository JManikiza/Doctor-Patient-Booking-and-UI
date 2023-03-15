package Project;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class Main {
//The Doctors will be called to this List
	public static List<Doctor> doctorArr = new ArrayList<Doctor>();
//Make WestminsterSkinConsultationManager Object
	public static WestminsterSkinConsultationManager doctor = new WestminsterSkinConsultationManager();

	public static void main(String[] args) throws IOException {
            
//Call and load stored file, if no file on system it will create a new one
        doctor.Load();

//Call the Menu() method
		Menu();
                
//Call the SwitchCase() Method
                SwitchCase();
        }
        
        public static void SwitchCase() throws IOException{
            
//Input from user will be stored in 'input' varible from scanner for navigating
//through the menu system, also involving Switch case and recurssion
            Scanner scan = new Scanner(System.in);
            int input = scan.nextInt();
            
//In the switch, most inputs will call Menu() and SwitchCase()		
            switch (input) {
                case 1:
                    AddDoctor();
                    SaveFile();
                    Menu();
                    SwitchCase();
                    break;

		case 2:
                    EraseDoctor();
                    SaveFile();
                    Menu();
                    SwitchCase();
                    break;

		case 3:
                    GUI();
                    Menu();
                    SwitchCase();
                    break;
				
		case 4:
                    PrintDoctor();
                    
//This code will open the file created by the program                   
                    Desktop.getDesktop().open(new File("Doctors.csv"));
                    Menu();
                    SwitchCase();
                    break;
			

		case 5:
                    SaveFile();
                    Menu();
                    SwitchCase();
                    break;
				
		case 6:
                    System.out.println("Goodbye.");
                    SaveFile();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Error...\nPlease use only numbers 1 to 6...\n");
                    Menu();
                    SwitchCase();
                    break;
		}
		
	}
//Menu() method is just a simple print statement and SwitchCase() takes the input
	public static void Menu() {

		System.out.println("Hello and welcome to the SCC\n1 - Add Doctor\n2 - Delete Doctor\n3 - GUI\n4 - Print Doctors\n5 - Save\n6 - Exit\n"
                            );

	}
//Attach the Doctors details to Strings to be stored 
	public static void AddDoctor() {
        
		Scanner scan = new Scanner(System.in);
		System.out.println("Add New Doctor\nName: ");
		String dName = scan.nextLine();

		System.out.println("Surname: ");
		String dSurname = scan.nextLine();

		System.out.println("DOB: ");
		String DOB = scan.nextLine();

		System.out.println("Contact Number: ");
		String number = scan.nextLine();

		System.out.println("Expertise: ");
		String expertise = scan.nextLine();

		System.out.println("NHS Number: ");
		String nhsNumber = scan.nextLine();
                
//The Doctors details gets stored from the WestminsterSkinConsultationManager object
		WestminsterSkinConsultationManager doctorUI = new WestminsterSkinConsultationManager();
		doctorUI.EnterDoctor(new Doctor(dName, dSurname, DOB, number, expertise, nhsNumber));
		
		System.out.println("Doctor " + dSurname + " has been added.\n");
		
	}

	public static void EraseDoctor() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Input NHS Number: ");
            String nhsNumber = scan.nextLine();
            
//For loop looks through the Doctor ArrayList and finds the exact NHS Number of
//Doctor to be deleted
		for (int i = 0; i < doctorArr.size(); i++) {
                    if (doctorArr.get(i).getNhsNumber().equals(nhsNumber)) {
                        Doctor eDoctor = doctorArr.get(i);
                        doctor.EraseDoctor(eDoctor);
			System.out.println("Deleted");
			break;
			}
		}

	}

	public static void PrintDoctor() {
            doctor.PrintDoctor();
	}

	public static void SaveFile() {
            System.out.println("Saving...\n");
            doctor.Save();
            System.out.println("Saved...\n");
	}

	public static void GUI() {
            Menu menu = new Menu();
            menu.frameGUIMenu.setVisible(true);
	}
	
}
