package org.iiitb.pushd.controller;

import org.iiitb.pushd.models.Admin;
import org.iiitb.pushd.services.AdminService;
import org.iiitb.pushd.services.DoctorService;
import org.iiitb.pushd.services.PatientService;
import org.iiitb.pushd.services.SpecialistService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("admin")
public class AdminController {
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
}
