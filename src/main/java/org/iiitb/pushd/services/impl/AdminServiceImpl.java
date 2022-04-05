package org.iiitb.pushd.services.impl;

import java.util.List;

import org.iiitb.pushd.models.Admin;
import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.models.Specialist;
import org.iiitb.pushd.models.Status;
import org.iiitb.pushd.repositories.AdminRepository;
import org.iiitb.pushd.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository ar;

	@Override
	public Admin saveAdmin(Admin a) {
		return ar.save(a);
	}

	@Override
	public boolean remAdmin(String username) {
		return ar.deleteByUsername(username);
	}

	@Override
	public List<Admin> getAdmins() {
		return ar.findAll();
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
	public List<Doctor> getDoctors() {
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
	public List<Patient> getPatients() {
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
	public List<Specialist> getSpecs() {
		// TODO Auto-generated method stub
		return null;
	}

}
