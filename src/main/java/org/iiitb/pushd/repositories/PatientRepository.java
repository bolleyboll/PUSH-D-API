package org.iiitb.pushd.repositories;

import java.util.List;

import org.iiitb.pushd.models.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long>{
	List<Patient> findByUsername(String username);
} 
