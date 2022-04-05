package org.iiitb.pushd.services;

import java.util.List;

import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Specialist;
import org.iiitb.pushd.models.Status;

public interface SpecialistService {
	Specialist saveSpec(Specialist d);

	Specialist login(String username, String password);

	Status changeDoc(String pat, String newDocUname);

	List<Doctor> getSpecDocs(String specUname);
}
