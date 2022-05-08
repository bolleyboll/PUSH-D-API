package org.iiitb.pushd.services;

import org.iiitb.pushd.models.Doctor;
import org.iiitb.pushd.models.Patient;
import org.iiitb.pushd.models.Specialist;

public interface UnableLoginService {
    String initResetPassword(String email);
    String resetPassword(String token, String oldPassword, String newPassword);
    void resendPasswordChangeToken(String email);
    String buildPasswordChangeEmail(String name, String link);
}
