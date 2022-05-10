package org.iiitb.pushd.services.impl;

import java.util.List;
import java.util.Random;

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

	Random rand = new Random();

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
	public Admin getAdmin(String username) {
		return ar.findByUsername(username);
	}

	@Override
	public Doctor addDoctor(Doctor d)
	{
		List<Specialist> specialists = sr.findAll();
		Specialist spe = specialists.get(rand.nextInt(specialists.size()));
		d.setSpecialist(spe);
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
		List<Doctor> doctors = dr.findAll();
		Doctor doc = doctors.get(rand.nextInt(doctors.size()));
		p.setDoctor(doc);
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
	public Patient getPatient(String username)
	{
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
	public Patient updatePatient(Patient patient)
	{
		Patient dbPat = pr.findByUsername(patient.getUsername());
		patient.setDoctor(dbPat.getDoctor());
		return pr.save(patient);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		Doctor dbDoc = dr.findByUsername(doctor.getUsername());
		doctor.setSpecialist(dbDoc.getSpecialist());
		return dr.save(doctor);

	}

}
