package org.iiitb.pushd.services.impl;

import lombok.AllArgsConstructor;
import org.iiitb.pushd.models.AppUser;
import org.iiitb.pushd.models.ConfirmationToken;
import org.iiitb.pushd.models.PasswordResetToken;
import org.iiitb.pushd.repositories.PasswordResetTokenRepository;
import org.iiitb.pushd.services.PasswordResetTokenService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {

    private final PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    public void savePasswordResetToken(PasswordResetToken token) {
        passwordResetTokenRepository.save(token);
    }

    @Override
    public Optional<PasswordResetToken> getToken(String token) {
        return passwordResetTokenRepository.findByToken(token);
    }

    @Override
    public void setTokenIsUsed(String token) {
        passwordResetTokenRepository.setTokenUsed(token, true);
    }
 
    @Override
    public String generateNewToken(AppUser appUser) {
        String token = UUID.randomUUID().toString().substring(0,5);
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByAppUser_Username(appUser.getUname());
        if(passwordResetToken != null)
        {
            passwordResetToken.setToken(token);
        }
        else
        {
            passwordResetToken = new PasswordResetToken(
                    token,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusMinutes(15),
                    appUser
            );
        }
        savePasswordResetToken(passwordResetToken);
        return token;
    }
}
