package org.iiitb.pushd.controller;

import lombok.AllArgsConstructor;
import org.iiitb.pushd.services.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;
import org.springframework.http.ResponseEntity;

@RestController
@AllArgsConstructor
@RequestMapping("doctor")
public class DoctorController {
	private static final String ORIGIN_URL = "http://localhost:3000";

	private final AdminService as;

	private final DoctorService ds;

	private final PatientService ps;

	private final SpecialistService ss;

	private final RegistrationService rs;

	private final UnableLoginService uls;

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
	public ResponseEntity<String> addDoctor(@RequestBody Doctor doc)
	{
		Doctor dbDoc = as.getDoctor(doc.getUsername());
		if (dbDoc == null) {
			this.as.addDoctor(doc);
			rs.register(doc);
			return ResponseEntity.ok(doc.getUsername() + " Registered");
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
	@GetMapping("del/{username}")
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

	@CrossOrigin(origins = ORIGIN_URL)
	@PutMapping("restrictsection/{username}/{sec}")
	public ResponseEntity<String> restrictSections(@PathVariable String username, @PathVariable Integer sec)
	{
		if(ds.restrictPatientSec(username,sec))
		{
			return ResponseEntity.ok("Restricted section " + sec);
		}
		else
		{
			return ResponseEntity.ok("Section doesn't exist");
		}
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@PutMapping("sectionorder/{username}")
	public ResponseEntity<String> reorderSection(@PathVariable String username, @RequestBody String sectionOrder)
	{
		if(ds.alterPatientSecOrder(username,sectionOrder))
		{
			return ResponseEntity.ok("New order updated to " + sectionOrder);
		}
		else
		{
			return ResponseEntity.ok("New order not updated");
		}
	}
}
