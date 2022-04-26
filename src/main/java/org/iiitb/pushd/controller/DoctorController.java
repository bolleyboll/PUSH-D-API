package org.iiitb.pushd.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.services.AdminService;
import org.iiitb.pushd.services.DoctorService;
import org.iiitb.pushd.services.PatientService;
import org.iiitb.pushd.services.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("doctor")
public class DoctorController {
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
	@PostMapping("signin")
	public ResponseEntity<String> docLogin(@RequestBody Doctor doc) {
		String uname = doc.getUsername();
		String pass = doc.getPassword();

		Doctor dbDoc = ds.login(uname, pass);
		if (dbDoc != null) {
			return ResponseEntity.ok(dbDoc.getUsername());
		} else {
			return ResponseEntity.ok("Username or Password don't match!");
		}
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@PostMapping("register")
	public void addDoctor(@RequestBody Doctor d) {
		this.as.addDoctor(d);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@DeleteMapping("del/{username}")
	public Integer remDoctor(@PathVariable String username) {
		return this.as.remDoctor(username);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@PutMapping("update")
	public Doctor updateDoctor(@RequestBody Doctor dr) {
		return this.as.updateDoctor(dr);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@GetMapping("{docUname}/patients")
	public List<Patient> getDocPatients(@PathVariable String docUname) {
		return ds.getDocPatients(docUname);
	}
}
