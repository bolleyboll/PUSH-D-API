package org.iiitb.pushd.services;

import org.iiitb.pushd.models.AppUser;
import org.iiitb.pushd.models.PasswordResetToken;

import java.util.Optional;

public interface PasswordResetTokenService {
    void savePasswordResetToken (PasswordResetToken token);
    Optional<PasswordResetToken> getToken(String token);
    void setTokenIsUsed(String token);
    String generateNewToken(AppUser user);
}
