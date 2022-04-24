package org.iiitb.pushd.services.impl;

import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.repositories.PatientRepository;
import org.iiitb.pushd.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository pr;

	@Override
	public Patient savePatient(Patient p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateCompletedSections(String newSectionList) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Patient login(String username, String password) {
		return pr.findByUsernameAndPassword(username, password);
	}

	@Override
	public Patient logout(String username) { return pr.findByUsername(username); }

}
