package org.iiitb.pushd.repositories;


import org.iiitb.pushd.models.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialistRepository extends JpaRepository<Specialist, String>{
	Specialist findByUsername(String username);
	Specialist findByUsernameAndPassword(String username, String password);
	Long deleteByUsername(String username);
}
