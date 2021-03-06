package org.iiitb.pushd.services;

import org.iiitb.pushd.models.Patient;

public interface PatientService {
	Patient savePatient(Patient p);

	Patient login(String username, String password);

	Boolean updateCompletedSections(String username, String updatedCompletionList);

	Patient logout(String username);
}
