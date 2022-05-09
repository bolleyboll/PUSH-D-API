package org.iiitb.pushd.controller;

import java.util.List;

import org.iiitb.pushd.models.Admin;
import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.models.Specialist;
import org.iiitb.pushd.services.AdminService;
import org.iiitb.pushd.services.DoctorService;
import org.iiitb.pushd.services.PatientService;
import org.iiitb.pushd.services.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
	private static final String ORIGIN_URL = "http://localhost:3000";

	@Autowired
	private AdminService as;

	@Autowired
	private DoctorService ds;

	@Autowired
	private PatientService ps;

	@Autowired
	private SpecialistService ss;

	@CrossOrigin(origins = ORIGIN_URL)
	@GetMapping("/admins")
	public ResponseEntity<List<Admin>> getAdmins() {
		return ResponseEntity.ok().body(as.getAdmins());
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@GetMapping("/doctors")
	public List<Doctor> getDoctors() {
		return as.getDoctors();
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@GetMapping("/patients")
	public List<Patient> getPatients() {
		return this.as.getPatients();
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@GetMapping("/specialists")
	public List<Specialist> getSpecialists() {
		return this.as.getSpecs();
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@PutMapping("/docUpdateRequest/{patUname}/{newDocUname}")
	public boolean changeDoc(@PathVariable String patUname, @PathVariable String newDocUname) {
		return ss.changeDoc(patUname, newDocUname);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@PutMapping("/{username}/changedoctor")
	public ResponseEntity<Patient> assignPatient(@PathVariable String username)
	{
		Patient pat = ss.assignChangeDoctor(username);
		ps.savePatient(pat);
		return ResponseEntity.ok().body(pat);
	}

}