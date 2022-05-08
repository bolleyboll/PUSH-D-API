package org.iiitb.pushd.services.impl;

import java.util.List;

import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.repositories.DoctorRepository;
import org.iiitb.pushd.repositories.PatientRepository;
import org.iiitb.pushd.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository dr;
	@Autowired
	private PatientRepository pr;

	@Override
	public Doctor saveDoctor(Doctor d) {
		return dr.save(d);
	}

	@Override
	public List<Patient> getDocPatients(String docUname) {
		return pr.findPatientsByDoctor_Username(docUname);
	}

	@Override
	public boolean alterPatientSecOrder(String username, String newOrder) {
		Patient p = pr.findByUsername(username);
		p.setSectionOrder(newOrder);
		Patient dbPat = pr.save(p);
		if (dbPat.getSectionOrder().equalsIgnoreCase(newOrder)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Doctor login(String username, String password) {
		return dr.findByUsernameAndPassword(username, password);
	}

}
