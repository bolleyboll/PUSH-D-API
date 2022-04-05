package org.iiitb.pushd.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.*;

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

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/patient/register")
	public ResponseEntity<String> patRegister(@RequestBody Patient pat)
	{
		Patient dbPat = as.getPatient(pat.getUsername());
		if(dbPat == null)
		{
			addPatient(pat);
			return  ResponseEntity.ok(pat.getUsername()+" Registered");
		}
		else {
			return ResponseEntity.ok("USER ALREADY EXISTS");
		}

	}

	@CrossOrigin(origins = "http://localhost:3000")
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

	@CrossOrigin(origins = "http://localhost:3000")
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

	@CrossOrigin(origins = "http://localhost:3000")
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

	@CrossOrigin(origins = "http://localhost:3000")
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

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/admins")
	public ResponseEntity<List<Admin>> getAdmins() {
		return ResponseEntity.ok().body(as.getAdmins());
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/doctors")
	public List<Doctor> getDoctors() {
		return as.getDoctors();
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/doctor/add")
	public void addDoctor(@RequestBody Doctor d) {
		this.as.addDoctor(d);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/doctors/{username}")
	public Integer remDoctor(@PathVariable String username) {
		return this.as.remDoctor(username);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/patient/add")
	public void addPatient(@RequestBody Patient p) {
		this.as.addPatient(p);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/patients")
	public List<Patient> getPatients() {
		return this.as.getPatients();
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/patients/{username}")
	public Long deletePatient(@PathVariable String username) {
		return this.as.remPatient(username);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/patients/{username}")
	public Patient getPatient(@PathVariable String username) {
		return this.as.getPatient(username);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/specialist/add")
	public void addSpecialist(@RequestBody Specialist sp) {
		this.as.addSpec(sp);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/specialists/{username}")
	public Long deleteSpecialist(@PathVariable String username) {
		return this.as.remSpec(username);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/specialists/{username}")
	public Specialist getSpecialist(@PathVariable String username) {
		return this.as.getSpec(username);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/specialists")
	public List<Specialist> getSpecialists() {
		return this.as.getSpecs();
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/specialist/update")
	public Specialist updateSpecialist(@RequestBody Specialist sp) {
		return this.as.updateSpecialist(sp);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/patient/update")
	public Patient updatePatient(@RequestBody Patient pt) {
		return this.as.updatePatient(pt);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/doctor/update")
	public Doctor updateDoctor(@RequestBody Doctor dr) {
		return this.as.updateDoctor(dr);
	}
}