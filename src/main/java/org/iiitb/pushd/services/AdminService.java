package org.iiitb.pushd.services;

import java.util.List;

import org.iiitb.pushd.models.Admin;
import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.models.Specialist;
import org.iiitb.pushd.models.Status;

public interface AdminService {
	Admin saveAdmin(Admin a);

	Admin login(String username, String password);

	boolean remAdmin(String username);

	List<Admin> getAdmins();

	Doctor addDoctor(Doctor d);

	Status remDoctor(String username);

	List<Doctor> getDoctors();

	Patient addPatient(Patient p);

	Status remPatient(String username);

	List<Patient> getPatients();

	Specialist addSpec(Specialist s);

	Status remSpec(String username);

	List<Specialist> getSpecs();
}
