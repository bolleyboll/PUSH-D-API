package org.iiitb.pushd.services;

import java.util.List;

import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Specialist;

public interface SpecialistService {
	Specialist saveSpec(Specialist d);

	Specialist login(String username, String password);

	String changeDoc(String pat, String newDocUname);

	List<Doctor> getSpecDocs(String specUname);
}
