package org.iiitb.pushd.services.impl;

import java.util.List;

import org.iiitb.pushd.models.Admin;
import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.models.Specialist;
import org.iiitb.pushd.models.Status;
import org.iiitb.pushd.services.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AdminServiceImpl implements AdminService {

	@Override
	public Admin saveAdmin(Admin a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remAdmin(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Admin> getAdmins(Integer n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor addDoctor(Doctor d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status remDoctor(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> getDoctors(Integer n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient addPatient(Patient p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status remPatient(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getPatients(Integer n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Specialist addSpec(Specialist s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status remSpec(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Specialist> getSpecs(Integer n) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
