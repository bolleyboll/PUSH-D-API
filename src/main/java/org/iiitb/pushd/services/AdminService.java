package org.iiitb.pushd.services;

import java.util.List;

import org.iiitb.pushd.models.Admin;
import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.models.Specialist;
import org.iiitb.pushd.models.Status;

public interface AdminService {
	Admin saveAdmin(Admin a);

	boolean remAdmin(String username);

	List<Admin> getAdmins(Integer n);

	Doctor addDoctor(Doctor d);

	Status remDoctor(String username);

	List<Doctor> getDoctors(Integer n);

	Patient addPatient(Patient p);

	Status remPatient(String username);

	List<Patient> getPatients(Integer n);

	Specialist addSpec(Specialist s);

	Status remSpec(String username);

	List<Specialist> getSpecs(Integer n);
}
