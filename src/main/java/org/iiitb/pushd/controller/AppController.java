package org.iiitb.pushd.controller;

import java.util.List;

import org.apache.catalina.User;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@Autowired
	private AdminService as;
	@Autowired
	private DoctorService ds;
	@Autowired
	private PatientService ps;
	@Autowired
	private SpecialistService ss;

	@PostMapping("/patient/signin")
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

	@PostMapping("/doctor/signin")
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

	@PostMapping("/admin/signin")
	public ResponseEntity<String> adminLogin(@RequestBody Admin admin) {
		String uname = admin.getUsername();
		String pass = admin.getPassword();

		Admin dbAdmin = as.login(uname, pass);
		if (dbAdmin != null) {
			return ResponseEntity.ok(dbAdmin.getUsername());
		} else {
			return ResponseEntity.ok("Username or Password don't match!");
		}
	}

	@PostMapping("/spec/signin")
	public ResponseEntity<String> specLogin(@RequestBody Specialist spec) {
		String uname = spec.getUsername();
		String pass = spec.getPassword();

		Specialist dbSpec = ss.login(uname, pass);
		if (dbSpec != null) {
			return ResponseEntity.ok(dbSpec.getUsername());
		} else {
			return ResponseEntity.ok("Username or Password don't match!");
		}
	}

	@GetMapping("/admins")
	public ResponseEntity<List<Admin>> getAdmins() {
		return ResponseEntity.ok().body(as.getAdmins());
	}
}