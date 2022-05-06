package org.iiitb.pushd.startup;

import org.iiitb.pushd.models.Admin;
import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.models.Specialist;
import org.iiitb.pushd.repositories.AdminRepository;
import org.iiitb.pushd.repositories.DoctorRepository;
import org.iiitb.pushd.repositories.PatientRepository;
import org.iiitb.pushd.repositories.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Start {

	@Autowired
	private AdminRepository ar;

	@Autowired
	private PatientRepository pr;

	@Autowired
	private DoctorRepository dr;

	@Autowired
	private SpecialistRepository sr;

	@EventListener(ContextRefreshedEvent.class)
	public void te() {

		System.out.println("Startup Starts");

		Admin a = new Admin();
		a.setAdminID(1);
		a.setUsername("bolleyboll");
		a.setPassword("password");
		a.setName("Aman Gupta");
		a.setEmail("aman.iv0012@gmail.com");
		ar.save(a);

		Specialist s = new Specialist();
		s.setSpecID(1);
		s.setUsername("vishalg");
		s.setPassword("password");
		s.setName("Vishal Govil");
		s.setEmail("Vishal.Govil@iiitb.ac.in");
		sr.save(s);

		Doctor d = new Doctor();
		d.setDoctorID(1);
		d.setUsername("nikhilm");
		d.setPassword("password");
		d.setName("Nikhil Mittal");
		d.setEmail("Nikhil.Mittal@iiitb.ac.in");
		d.setSpecialist(s);
		dr.save(d);

		Doctor d1 = new Doctor();
		d1.setDoctorID(2);
		d1.setUsername("shubhamn");
		d1.setPassword("password");
		d1.setName("Shubham Nigam");
		d1.setEmail("Shubham.Nigam@iiitb.ac.in");
		d1.setSpecialist(s);
		dr.save(d1);

		Patient p = new Patient();
		p.setPatientID(1);
		p.setUsername("kunals");
		p.setPassword("password");
		p.setName("Kunal Sharma");
		p.setEmail("Kunal.Sharma@iiitb.ac.in");
		p.setLastLogin(new Date());
		p.setDoctor(d);
		pr.save(p);

		Patient p1 = new Patient();
		p1.setPatientID(2);
		p1.setUsername("suchil");
		p1.setPassword("password");
		p1.setName("Suchi Laad");
		p1.setEmail("suchi.laad@iiitb.ac.in");
		p1.setLastLogin(new Date());
		p1.setDoctor(d);
		pr.save(p1);

		Patient p2 = new Patient();
		p2.setPatientID(3);
		p2.setUsername("nikhilm");
		p2.setPassword("password");
		p2.setName("Nikhil Mittal");
		p2.setEmail("nikhil.mittal@iiitb.ac.in");
		p2.setLastLogin(new Date());
		p2.setDoctor(d1);
		pr.save(p2);

		Patient p3 = new Patient();
		p3.setPatientID(4);
		p3.setUsername("amang");
		p3.setPassword("password");
		p3.setName("Aman Gupta");
		p3.setEmail("aman.gupta@iiitb.ac.in");
		p3.setLastLogin(new Date());
		p3.setDoctor(d1);
		pr.save(p3);

		System.out.println("Startup End");

	}
}
