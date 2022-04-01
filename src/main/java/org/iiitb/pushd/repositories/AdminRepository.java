package org.iiitb.pushd.repositories;

import java.util.List;

import org.iiitb.pushd.models.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long>{
	List<Admin> findByUsername(String username);
}
