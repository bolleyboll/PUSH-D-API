package org.iiitb.pushd.services.impl;

import lombok.AllArgsConstructor;
import org.iiitb.pushd.models.AppUser;
import org.iiitb.pushd.models.ConfirmationToken;
import org.iiitb.pushd.repositories.ConfirmationTokenRepository;
import org.iiitb.pushd.services.ConfirmationTokenService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    @Override
    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    @Override
    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    @Override
    public int setConfirmedAt(String token) {
        return confirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }

    @Override
    public String generateNewToken(AppUser appUser) {
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = confirmationTokenRepository.findByAppUser_Username(appUser.getUname());
        if(confirmationToken != null)
        {
            confirmationToken.setCreatedAt(LocalDateTime.now());
            confirmationToken.setExpiresAt(LocalDateTime.now().plusMinutes(15));
            confirmationToken.setToken(token);
        }
        else
        {
            confirmationToken = new ConfirmationToken(
                    token,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusMinutes(15),
                    appUser
            );
        }
        saveConfirmationToken(confirmationToken);
        return token;
    }
}
