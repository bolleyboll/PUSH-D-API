package org.iiitb.pushd.services;

public interface UnableLoginService {
    String initResetPassword(String email);
    String resetPassword(String email, String newpassword, String token);
    void resendPasswordChangeToken(String email);
    String buildPasswordChangeEmail(String name, String link, String token);
}
