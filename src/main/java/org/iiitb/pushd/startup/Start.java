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
		System.out.println("Henlo");

		Admin a = new Admin(1, "bolleyboll", "password", "Aman Gupta", "aman.iv0012@gmail.com");
		ar.save(a);

		Specialist s = new Specialist(1, "vishalg", "password", "Vishal Govil", "Vishal.Govil@iiitb.ac.in");
		sr.save(s);

		Doctor d = new Doctor(1, "nikhilm", "password", "Nikhil Mittal", "Nikhil.Mittal@iiitb.ac.in", s);
		Doctor d1 = new Doctor(2, "shubhamn", "password", "Shubham Nigam", "Shubham.Nigam@iiitb.ac.in", s);
		dr.save(d);
		dr.save(d1);

		Patient p = new Patient(1, "kunals", "password", "Kunal Sharma", "Kunal.Sharma@iiitb.ac.in",new Date(), d);
		Patient p1 = new Patient(2, "suchil", "password", "Suchi Laad", "suchi.laad@iiitb.ac.in",new Date(), d);
		Patient p2 = new Patient(3, "nikhilm", "password", "Nikhil Mittal", "nikhil.mittal@iiitb.ac.in",new Date(), d1);
		Patient p3 = new Patient(4, "amang", "password", "Aman Gupta", "aman.gupta@iiitb.ac.in",new Date(), d1);
		pr.save(p);
		pr.save(p1);
		pr.save(p2);
		pr.save(p3);
	}
}
