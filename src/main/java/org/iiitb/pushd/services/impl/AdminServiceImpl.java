package org.iiitb.pushd.services.impl;

import java.util.List;

import org.iiitb.pushd.models.Admin;
import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.models.Specialist;
import org.iiitb.pushd.repositories.AdminRepository;
import org.iiitb.pushd.repositories.DoctorRepository;
import org.iiitb.pushd.repositories.PatientRepository;
import org.iiitb.pushd.repositories.SpecialistRepository;
import org.iiitb.pushd.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository ar;

	@Autowired
	private DoctorRepository dr;

	@Autowired
	private PatientRepository pr;

	@Autowired
	private SpecialistRepository sr;

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
		return dr.save(d);
	}

	@Override
	public Integer remDoctor(String username) {
		return dr.deleteByUsername(username);
	}

	@Override
	public List<Doctor> getDoctors() {
		return dr.findAll();
	}

	@Override
	public Doctor getDoctor(String username) {
		return dr.findByUsername(username);
	}

	@Override
	public Patient addPatient(Patient p) {
		return pr.save(p);
	}

	@Override
	public Long remPatient(String username) {
		return pr.deleteByUsername(username);
	}

	@Override
	public List<Patient> getPatients() {
		return pr.findAll();
	}

	@Override
	public Patient getPatient(String username) {
		return pr.findByUsername(username);
	}

	@Override
	public Specialist addSpec(Specialist s) {
		return sr.save(s);
	}

	@Override
	public Long remSpec(String username) {
		return sr.deleteByUsername(username);
	}

	@Override
	public List<Specialist> getSpecs() {
		return sr.findAll();
	}

	@Override
	public Specialist getSpec(String username) {
		return sr.findByUsername(username);
	}

	@Override
	public Admin login(String username, String password) {
		return ar.findByUsernameAndPassword(username, password);
	}

	public Specialist updateSpecialist(Specialist specialist) {
		return sr.save(specialist);
	}

	@Override
	public Patient updatePatient(Patient patient) {
		return pr.save(patient);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		return dr.save(doctor);

	}

}
