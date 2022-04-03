package org.iiitb.pushd.services;

import java.util.List;

import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;

public interface DoctorService {
	Doctor saveDoctor(Doctor d);

	boolean remDoctor(String username);

	List<Patient> getDocPatients(Integer n);

	boolean alterPatientSecOrder(String username, String newOrder);
}
