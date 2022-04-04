package org.iiitb.pushd.services;

import org.iiitb.pushd.models.Status;

public interface PatientService {
	Status updateCompletedSections(String newSectionList);
}
