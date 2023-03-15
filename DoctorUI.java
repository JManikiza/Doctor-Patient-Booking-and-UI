import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import SCC;
import Main;

public class DoctorUI implements SCC {

	@Override
	public void AddDoctor(Doctor doctor) {
		Main.doctorsList.add(doctor);
	}

	@Override
	public void DeleteDoctor(Doctor doctor) {
		int index = Main.doctorsList.indexOf(doctor);
		Main.doctorsList.remove(index);
	}

	@Override
	public void PrintDoctors() {
		System.out.println("Doctor Details");
		for (int i = 0; i < Main.doctorsList.size(); i++) {
			System.out.println(Main.doctorsList.get(i).toString());
		}
	}

	@Override
	public void Save() {
		try (FileOutputStream file = new FileOutputStream("Doctors.csv");
				OutputStreamWriter out = new OutputStreamWriter(file, StandardCharsets.UTF_8);
				BufferedWriter buf = new BufferedWriter(out);
				PrintWriter writer = new PrintWriter(buf)) {
			for (Doctor doctor : Main.doctorsList) {
				writer.println(doctor.toCommaSeparatedString());
			}
		} catch (Exception ignored) {

		}

	}

	// Load File Content Method
	public void LoadFileContent() {
		Scanner fin = null;
		try {
			fin = new Scanner(new File("Doctors.csv"));
		} catch (Exception ex) {
			System.out.println(ex);
			System.exit(0);
		}
		int count = 0;
		while (fin.hasNext()) {
			String r = fin.nextLine();
			String[] A = r.split(",");// A[0] = name, A[1] = code, etc
			Doctor doctor = new Doctor(A[0], A[1], A[2], A[3], A[4], A[5]);
			WestminsterSkinConsultationManager.doctorsList.add(doctor);
			count++;
		}
		System.out.println("There are " + count + " doctors.");
		fin.close();
	}

}
