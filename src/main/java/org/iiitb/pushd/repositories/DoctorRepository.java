package org.iiitb.pushd.repositories;

import org.iiitb.pushd.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, String>{
	Doctor findByUsername(String username);
	Integer deleteByUsername(String username);
}
