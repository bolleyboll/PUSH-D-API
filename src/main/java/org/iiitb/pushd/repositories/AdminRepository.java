package org.iiitb.pushd.repositories;


import org.iiitb.pushd.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String>{
	Admin findByUsername(String username);
}
