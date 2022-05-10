package org.iiitb.pushd.services;

import org.iiitb.pushd.models.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AppUserService extends UserDetailsService {
    void saveAppUser(AppUser appUser);
    AppUser getAppUserByEmailAndPassword(String email, String password);
    String signUpUser(AppUser appUser);
    int enableAppUser(String email);
}
