package org.iiitb.pushd.repositories;

import org.iiitb.pushd.models.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findByToken(String token);
    PasswordResetToken findByAppUser_Username(String uname);

    @Transactional
    @Modifying
    @Query("UPDATE PasswordResetToken p " +
            "SET p.isTokenUsed = ?2 " +
            "WHERE p.token = ?1")
    int setTokenUsed(String token,
                          boolean used);
}
