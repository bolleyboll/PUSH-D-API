package org.iiitb.pushd.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import org.iiitb.pushd.models.*;
import org.iiitb.pushd.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class RootController {
	private static final String ORIGIN_URL = "http://localhost:3000";

	private final AdminService as;

	private final DoctorService ds;

	private final PatientService ps;

	private final SpecialistService ss;

	private final UnableLoginService uls;



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
	@GetMapping("changedoctor/{username}")
	public ResponseEntity<Patient> assignPatient(@PathVariable String username)
	{
		Patient pat = ss.assignChangeDoctor(username);
		ps.savePatient(pat);
		return ResponseEntity.ok().body(pat);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@GetMapping("signin/resetpassword")
	public String initResetPassword(@RequestParam("userEmail")String email)
	{
		uls.initResetPassword(email);
		return "Reset password link sent";
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@GetMapping("signin/resendresetpassword")
	public String resendResetPassword(@RequestParam("userEmail") String email)
	{
		uls.resendPasswordChangeToken(email);
		return "Re-Verification sent";
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@PostMapping("signin/resetpassword")
	public String resetPassword(@RequestBody ResetPasswordModel resetPasswordModel)
	{
		return uls.resetPassword(resetPasswordModel.getEmail(),resetPasswordModel.getNewpassword(),resetPasswordModel.getToken());
	}

}