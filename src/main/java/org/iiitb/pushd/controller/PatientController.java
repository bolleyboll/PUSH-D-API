package org.iiitb.pushd.controller;

import lombok.AllArgsConstructor;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping("patient")
public class PatientController {
	private static final String ORIGIN_URL = "http://localhost:3000";

	private final AdminService as;

	private final DoctorService ds;

	private final PatientService ps;

	private final SpecialistService ss;

	private final RegistrationService rs;

	private final UnableLoginService uls;

	@CrossOrigin(origins = ORIGIN_URL)
	@PostMapping("register")
	public ResponseEntity<String> patRegister(@RequestBody Patient pat) {
		Patient dbPat = as.getPatient(pat.getUsername());
		if (dbPat == null) {
			this.as.addPatient(pat);
			rs.register(pat);
			return ResponseEntity.ok(pat.getUsername() + " Registered");
		} else {
			return ResponseEntity.ok("USER ALREADY EXISTS");
		}

	}

	@CrossOrigin(origins = ORIGIN_URL)
	@GetMapping(path = "register/confirm")
	public String confirm(@RequestParam("token") String token) {
		return rs.confirmToken(token);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@GetMapping("register/resendVerification")
	public String resendVerification(@RequestParam("userEmail") String email)
	{
		rs.resendVerificationToken(email);
		return "Re-Verification sent";
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@PostMapping("signin")
	public ResponseEntity<String> patLogin(@RequestBody Patient pat) {
		String uname = pat.getUsername();
		String pass = pat.getPassword();

		Patient dbPat = ps.login(uname, pass);
		if (dbPat != null) {
			dbPat.setIsActive(true);
			dbPat.setLastLogin(new Date());
			updatePatient(dbPat);
			return ResponseEntity.ok(pat.getUsername());
		} else {
			return ResponseEntity.ok("Username or Password don't match!");
		}
	}


	@CrossOrigin(origins = ORIGIN_URL)
	@PutMapping("/{username}/signout")
	public ResponseEntity<String> patLogout(@PathVariable String username)
	{
		Patient dbPat = ps.logout(username);
		if(dbPat != null) {
			dbPat.setLastLogin(new Date());
			dbPat.setIsActive(false);
			updatePatient(dbPat);
			return ResponseEntity.ok(username);
		}
		else {
			return ResponseEntity.ok("Username doesn't exist");
		}
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@DeleteMapping("del/{username}")
	public Long deletePatient(@PathVariable String username) {
		return this.as.remPatient(username);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@GetMapping("{username}")
	public Patient getPatient(@PathVariable String username) {
		return this.as.getPatient(username);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@PutMapping("update")
	public Patient updatePatient(@RequestBody Patient pt) {
		return this.as.updatePatient(pt);
	}
}
