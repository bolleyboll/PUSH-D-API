package org.iiitb.pushd.services;

import org.iiitb.pushd.models.AppUserRole;
import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.models.Specialist;

public interface RegistrationService {
    String register(Patient pat);
    String register(Doctor doc);
    String register(Specialist spe);
    String confirmToken(String token);
    String buildEmail(String name, String link);
}
