package org.iiitb.pushd.repositories;

import java.util.List;

import org.iiitb.pushd.models.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Long>{
	List<Doctor> findByUsername(String username);
}
