package org.iiitb.pushd.services.impl;

import java.util.List;

import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Specialist;
import org.iiitb.pushd.models.Status;
import org.iiitb.pushd.services.SpecialistService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SpecialistServiceImpl implements SpecialistService{

	@Override
	public Specialist saveSpec(Specialist d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remSpec(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Status changeDoc(String pat, String newDocUname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> getSpecDocs(String specUname) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
