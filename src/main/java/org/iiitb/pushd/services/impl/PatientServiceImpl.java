package org.iiitb.pushd.services.impl;

import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.models.Status;
import org.iiitb.pushd.services.PatientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService{

	@Override
	public Patient savePatient(Patient p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status updateCompletedSections(String newSectionList) {
		// TODO Auto-generated method stub
		return null;
	}

}
