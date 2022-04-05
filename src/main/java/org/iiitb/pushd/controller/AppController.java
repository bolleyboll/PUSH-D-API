package org.iiitb.pushd.controller;

import java.util.List;

import org.apache.catalina.User;
import org.iiitb.pushd.models.Admin;
import org.iiitb.pushd.services.AdminService;
import org.iiitb.pushd.services.DoctorService;
import org.iiitb.pushd.services.PatientService;
import org.iiitb.pushd.services.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {

	@Autowired
	private AdminService as;
	@Autowired
	private DoctorService ds;
	@Autowired
	private PatientService ps;
	@Autowired
	private SpecialistService ss;

	@GetMapping
	public String login(User u) {
		return "Login Successful";
	}

	@GetMapping("/admins")
	public ResponseEntity<List<Admin>> getAdmins() {
		return ResponseEntity.ok().body(as.getAdmins());
	}
}