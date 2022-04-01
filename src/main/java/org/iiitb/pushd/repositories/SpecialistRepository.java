package org.iiitb.pushd.repositories;

import java.util.List;

import org.iiitb.pushd.models.Specialist;
import org.springframework.data.repository.CrudRepository;

public interface SpecialistRepository extends CrudRepository<Specialist, Long>{
	List<Specialist> findByUsername(String username);
}
