package org.iiitb.pushd.startup;

import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.models.Specialist;
import org.iiitb.pushd.repositories.DoctorRepository;
import org.iiitb.pushd.repositories.PatientRepository;
import org.iiitb.pushd.repositories.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {
	@Autowired
	private PatientRepository pr;

	@Autowired
	private DoctorRepository dr;

	@Autowired
	private SpecialistRepository sr;

	@EventListener(ContextRefreshedEvent.class)
	public void te() {
		System.out.println("Henlo");
		// Specialist s = new Specialist(100, "spec1", "password", "Spec", "spec@gmail.com");
		// sr.save(s);

		// Doctor d = new Doctor(500, "doc1", "pass", "Doc1", "doc@gmail.com");
		// d.setSpecialist(s);
		// dr.save(d);

		// Patient p = new Patient(200, "pat1", "pass", "Pat1", "pat@gmai.com");
		// p.setDoctor(d);
		// pr.save(p);
	}
}
