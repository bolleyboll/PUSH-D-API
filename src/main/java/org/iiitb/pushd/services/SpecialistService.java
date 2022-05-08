package org.iiitb.pushd.services;

import java.util.List;

import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Specialist;

public interface SpecialistService {
	Specialist saveSpec(Specialist s);

	Specialist login(String username, String password);

	boolean changeDoc(String pat, String newDocUname);

	List<Doctor> getSpecDocs(String specUname);
}
