package Project;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

//This class manages the system

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

	@Override
	public void EnterDoctor(Doctor doctor) {
		Main.doctorArr.add(doctor);
	}
        
	@Override
	public void EraseDoctor(Doctor doctor) {
		int index = Main.doctorArr.indexOf(doctor);
		Main.doctorArr.remove(index);
	}
	@Override
	public void PrintDoctor() {
		System.out.println("Doctor Details");
		for (int i = 0; i < Main.doctorArr.size(); i++) {
			System.out.println(Main.doctorArr.get(i).toString());
		}
	}
//Save to file already created        
	@Override
        public void Save() {
		try (FileOutputStream file = new FileOutputStream("Doctors.csv");
                    OutputStreamWriter out = new OutputStreamWriter(file, StandardCharsets.UTF_8);
                    BufferedWriter buf = new BufferedWriter(out);
                    PrintWriter writer = new PrintWriter(buf)) {
                    for (Doctor doctor : Main.doctorArr) {
                    writer.println(doctor.toCommaSeparatedString());
                    }
		} catch (Exception ignored) {
                }

	}

// Load File Content
	public void Load() {
		Scanner fin = null;
		try {
                    try {
                        File myFile = new File("Doctors.csv");
                        if (myFile.createNewFile()) {
                            System.out.println("File created: " + myFile.getName());
                        } else {
                            System.out.println("File already exists.");
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                    }
                    System.out.println("Trying to load");
                    fin = new Scanner(new File("Doctors.csv"));
		} catch (Exception ex) {
		}
		int count = 0;
		while (fin.hasNext()) {
                    String r = fin.nextLine();
                    String[] A = r.split(",");// A[0] = Name, A[1] = Surname, etc
                    Doctor doctor = new Doctor(A[0], A[1], A[2], A[3], A[4], A[5]);
                    Main.doctorArr.add(doctor);
                    count++;
		}
		System.out.println("There are " + count + " doctors.");
		fin.close();
	}

	


}
