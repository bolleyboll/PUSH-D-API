package org.iiitb.pushd.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.ResetPasswordModel;
import org.iiitb.pushd.models.Specialist;
import org.iiitb.pushd.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("specialist")
public class SpecialistController {
	private static final String ORIGIN_URL = "http://localhost:3000";

	private final AdminService as;

	private final DoctorService ds;

	private final PatientService ps;

	private final SpecialistService ss;

	private final RegistrationService rs;

	private final UnableLoginService uls;

	@CrossOrigin(origins = ORIGIN_URL)
	@PostMapping("signin")
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
	public String resetPassword(@RequestParam("token") String token, @RequestBody ResetPasswordModel resetPasswordModel)
	{
		return uls.resetPassword(token,resetPasswordModel.getOldPassword(),resetPasswordModel.getNewPassword());
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@PostMapping("register")
	public ResponseEntity<String> addDoctor(@RequestBody Specialist spe)
	{
		Specialist dbSpe = as.getSpec(spe.getUsername());
		if (dbSpe == null) {
			this.as.addSpec(spe);
			rs.register(spe);
			return ResponseEntity.ok(spe.getUsername() + " Registered");
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
	@PostMapping("add")
	public void addSpecialist(@RequestBody Specialist sp) {
		this.as.addSpec(sp);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@DeleteMapping("del/{username}")
	public Long deleteSpecialist(@PathVariable String username) {
		return this.as.remSpec(username);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@GetMapping("{username}")
	public Specialist getSpecialist(@PathVariable String username) {
		return this.as.getSpec(username);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@PutMapping("update")
	public Specialist updateSpecialist(@RequestBody Specialist sp) {
		return this.as.updateSpecialist(sp);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@GetMapping("{specUname}/doctors")
	public List<Doctor> getSpecDoctors(@PathVariable String specUname) {
		return ss.getSpecDocs(specUname);
	}
}
