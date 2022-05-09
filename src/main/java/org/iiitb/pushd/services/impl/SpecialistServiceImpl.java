package org.iiitb.pushd.services.impl;

import java.util.List;
import java.util.Random;

import lombok.AllArgsConstructor;
import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.models.Specialist;
import org.iiitb.pushd.repositories.DoctorRepository;
import org.iiitb.pushd.repositories.PatientRepository;
import org.iiitb.pushd.repositories.SpecialistRepository;
import org.iiitb.pushd.services.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class SpecialistServiceImpl implements SpecialistService {

	private final SpecialistRepository sr;
	private final DoctorRepository dr;
	private final PatientRepository pr;
	private final Random rand = new Random();

	@Override
	public Specialist saveSpec(Specialist s) {
		return sr.save(s);
	}

	@Override
	public boolean changeDoc(String patUname, String newDocUname) {
		Patient p = pr.findByUsername(patUname);
		Doctor d = dr.findByUsername(newDocUname);
		p.setDoctor(d);
		pr.save(p);
		return true;
	}

	@Override
	public List<Doctor> getSpecDocs(String specUname) {
		return dr.findDoctorsBySpecialist_Username(specUname);
	}

	@Override
	public Patient assignChangeDoctor(String username) {
		Patient dbPat = pr.findByUsername(username);
		List<Doctor> doctors = dr.findAll();
		Doctor doc;
		if (dbPat.getDoctor() != null)
		{
			do{
				doc = doctors.get(rand.nextInt(doctors.size()));
			}while(dbPat.getDoctor().equals(doc));
		} else
		{
			doc = doctors.get(rand.nextInt(doctors.size()));
		}
		dbPat.setDoctor(doc);
		return dbPat;
	}

	@Override
	public Specialist login(String username, String password) {
		return sr.findByUsernameAndPassword(username, password);
	}

}
