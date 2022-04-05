package org.iiitb.pushd.services;

import java.util.List;

import org.iiitb.pushd.models.Admin;
import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.models.Specialist;

public interface AdminService {
	Admin saveAdmin(Admin a);

	Admin login(String username, String password);

	boolean remAdmin(String username);

	List<Admin> getAdmins();

	Doctor addDoctor(Doctor d);

	Integer remDoctor(String username);

	List<Doctor> getDoctors();

	Patient addPatient(Patient p);

	Long remPatient(String username);

	List<Patient> getPatients();

	Patient getPatient(String username);

	Specialist addSpec(Specialist s);

	Long remSpec(String username);

	List<Specialist> getSpecs();

	Specialist getSpec(String username);

	Specialist updateSpecialist(Specialist specialist);

	Patient updatePatient(Patient patient);

	Doctor updateDoctor(Doctor doctor);
}
