package org.iiitb.pushd.services;

import java.util.List;

import org.iiitb.pushd.models.Admin;

public interface AdminService {
	Admin saveAdmin(Admin a);

	boolean remAdmin(String username);

	List<Admin> getAdmins(Integer n);
}
