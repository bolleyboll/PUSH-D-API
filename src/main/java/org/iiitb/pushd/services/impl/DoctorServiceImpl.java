package org.iiitb.pushd.services.impl;

import java.util.List;

import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.services.DoctorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DoctorServiceImpl implements DoctorService {

	@Override
	public Doctor saveDoctor(Doctor d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remDoctor(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Patient> getDocPatients(Integer n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterPatientSecOrder(String username, String newOrder) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
