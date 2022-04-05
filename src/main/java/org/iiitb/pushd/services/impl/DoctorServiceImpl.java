package org.iiitb.pushd.services.impl;

import java.util.List;

import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.repositories.DoctorRepository;
import org.iiitb.pushd.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository dr;
	
	@Override
	public Doctor saveDoctor(Doctor d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getDocPatients(String docUname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterPatientSecOrder(String username, String newOrder) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Doctor login(String username, String password) {
		return dr.findByUsernameAndPassword(username, password);
	}

}
