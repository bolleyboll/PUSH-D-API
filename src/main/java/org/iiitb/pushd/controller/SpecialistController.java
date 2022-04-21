package org.iiitb.pushd.controller;

import java.util.List;

import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Specialist;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("spec")
public class SpecialistController {
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

	@CrossOrigin(origins = ORIGIN_URL)
	@PostMapping("/specialist/add")
	public void addSpecialist(@RequestBody Specialist sp) {
		this.as.addSpec(sp);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@DeleteMapping("/specialist/del/{username}")
	public Long deleteSpecialist(@PathVariable String username) {
		return this.as.remSpec(username);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@GetMapping("/specialist/{username}")
	public Specialist getSpecialist(@PathVariable String username) {
		return this.as.getSpec(username);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@PutMapping("/specialist/update")
	public Specialist updateSpecialist(@RequestBody Specialist sp) {
		return this.as.updateSpecialist(sp);
	}

	@CrossOrigin(origins = ORIGIN_URL)
	@GetMapping("/specialist/{specUname}/doctors")
	public List<Doctor> getSpecDoctors(@PathVariable String specUname) {
		return ss.getSpecDocs(specUname);
	}
}
