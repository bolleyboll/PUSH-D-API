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
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/doctors")
	public List<Doctor> getDoctors()
	{
		return as.getDoctors();
	}

	@PostMapping("/doctors")
	public void addDoctor(@RequestBody Doctor d)
	{
		this.as.addDoctor(d);
	}

	@DeleteMapping("/doctors/{username}")
	public Integer remDoctor(@PathVariable String username)
	{
		return this.as.remDoctor(username);
	}

	@PostMapping("/patients")
	public void addPatient(@RequestBody Patient p)
	{
		this.as.addPatient(p);
	}

	@GetMapping("/patients")
	public List<Patient> getPatients()
	{
		return this.as.getPatients();
	}

	@DeleteMapping("/patients/{username}")
	public Long deletePatient(@PathVariable String username)
	{
		return this.as.remPatient(username);
	}

	@GetMapping("/patients/{username}")
	public Patient getPatient(@PathVariable String username)
	{
		return this.as.getPatient(username);
	}

	@PostMapping("/specialists")
	public void addSpecialist(@RequestBody Specialist sp)
	{
		this.as.addSpec(sp);
	}

	@DeleteMapping("/specialists/{username}")
	public Long deleteSpecialist(@PathVariable String username)
	{
		return this.as.remSpec(username);
	}

	@GetMapping("/specialists/{username}")
	public Specialist getSpecialist(@PathVariable String username)
	{
		return this.as.getSpec(username);
	}

	@GetMapping("/specialists")
	public List<Specialist> getSpecialists()
	{
		return this.as.getSpecs();
	}

	@PutMapping("/specialists")
	public Specialist updateSpecialist(@RequestBody Specialist sp)
	{
		return this.as.updateSpecialist(sp);
	}

	@PutMapping("/patients")
	public Patient updatePatient(@RequestBody Patient pt)
	{
		return this.as.updatePatient(pt);
	}

	@PutMapping("/doctors")
	public Doctor updateDoctor(@RequestBody Doctor dr)
	{
		return this.as.updateDoctor(dr);
	}
}