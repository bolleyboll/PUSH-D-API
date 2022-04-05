package org.iiitb.pushd.repositories;


import org.iiitb.pushd.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, String>{
	Patient findByUsername(String username);
	Patient findByUsernameAndPassword(String username, String password);
	Long deleteByUsername(String username);
} 
