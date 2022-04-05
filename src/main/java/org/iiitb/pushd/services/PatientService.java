package org.iiitb.pushd.services;

import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.models.Status;

public interface PatientService {
	Patient savePatient(Patient p);

	Patient login(String username, String password);

	Status updateCompletedSections(String newSectionList);
}
