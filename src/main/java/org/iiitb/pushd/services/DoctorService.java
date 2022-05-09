package org.iiitb.pushd.services;

import java.util.List;

import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;

public interface DoctorService {
	Doctor saveDoctor(Doctor d);

	Doctor login(String username, String password);

	List<Patient> getDocPatients(String docUname);

	boolean alterPatientSecOrder(String username, String newOrder);

	boolean restrictPatientSec(String username, Integer section);
}
