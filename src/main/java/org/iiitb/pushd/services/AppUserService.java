package org.iiitb.pushd.services;

import org.iiitb.pushd.models.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AppUserService extends UserDetailsService {
    String signUpUser(AppUser appUser);
    int enableAppUser(String email);
}
