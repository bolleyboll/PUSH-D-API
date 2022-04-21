package org.iiitb.pushd.controller;

import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.services.AdminService;
import org.iiitb.pushd.services.DoctorService;
import org.iiitb.pushd.services.PatientService;
import org.iiitb.pushd.services.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patient")
public class PatientController {
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
	@PostMapping("register")
	public ResponseEntity<String> patRegister(@RequestBody Patient pat) {
		Patient dbPat = as.getPatient(pat.getUsername());
		if (dbPat == null) {
			this.as.addPatient(pat);
			return ResponseEntity.ok(pat.getUsername() + " Registered");
		} else {
			return ResponseEntity.ok("USER ALREADY EXISTS");
		}

	}

	@CrossOrigin(origins = ORIGIN_URL)
	@PostMapping("signin")
	public ResponseEntity<String> patLogin(@RequestBody Patient pat) {
		String uname = pat.getUsername();
		String pass = pat.getPassword();

		Patient dbPat = ps.login(uname, pass);
		if (dbPat != null) {
			return ResponseEntity.ok(pat.getUsername());
		} else {
			return ResponseEntity.ok("Username or Password don't match!");
		}
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@DeleteMapping("/patient/del/{username}")
	public Long deletePatient(@PathVariable String username) {
		return this.as.remPatient(username);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@GetMapping("/patient/{username}")
	public Patient getPatient(@PathVariable String username) {
		return this.as.getPatient(username);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@PutMapping("/patient/update")
	public Patient updatePatient(@RequestBody Patient pt) {
		return this.as.updatePatient(pt);
	}
}
