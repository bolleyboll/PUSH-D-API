package org.iiitb.pushd.services;

import org.iiitb.pushd.models.AppUser;
import org.iiitb.pushd.models.ConfirmationToken;

import java.util.Optional;

public interface ConfirmationTokenService {
    void saveConfirmationToken(ConfirmationToken token);
    Optional<ConfirmationToken> getToken(String token);
    int setConfirmedAt(String token);
    String generateNewToken(AppUser user);
}
