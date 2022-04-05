package org.iiitb.pushd.services.impl;

import java.util.List;

import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.models.Specialist;
import org.iiitb.pushd.models.Status;
import org.iiitb.pushd.repositories.DoctorRepository;
import org.iiitb.pushd.repositories.PatientRepository;
import org.iiitb.pushd.repositories.SpecialistRepository;
import org.iiitb.pushd.services.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SpecialistServiceImpl implements SpecialistService {

	@Autowired
	private SpecialistRepository sr;
	@Autowired
	private DoctorRepository dr;
	@Autowired
	private PatientRepository pr;
	
	@Override
	public Specialist saveSpec(Specialist d) {
		// TODO Auto-generated method stub
		return null;
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
	public Specialist login(String username, String password) {
		return sr.findByUsernameAndPassword(username, password);
	}

}
