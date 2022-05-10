package org.iiitb.pushd.services.impl;

import lombok.AllArgsConstructor;
import org.iiitb.pushd.mail.MailService;
import org.iiitb.pushd.models.*;
import org.iiitb.pushd.services.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Locale;

@Service
@AllArgsConstructor
public class UnableLoginServiceImpl implements UnableLoginService {

    private final AppUserService appUserService;
    private final PatientService patientService;
    private final DoctorService doctorService;
    private final SpecialistService specialistService;
    private final AdminService adminService;
    private final PasswordResetTokenService passwordResetTokenService;
    private final MailService mailService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String initResetPassword(String email) {
        AppUser appUser = (AppUser) appUserService.loadUserByUsername(email);
        String token = passwordResetTokenService.generateNewToken(appUser);
        getPasswordChangeEmail(token, appUser.getEmail(), appUser.getUname(), appUser.getAppUserRole().toString().toLowerCase(Locale.ENGLISH));
        return "Password change email sent to " + appUser.getEmail();

    }

    private void getPasswordChangeEmail(String token, String email, String name, String type)
    {

        String link = "http://localhost:3000/enterfpd";
        Mail mail = new Mail();
        mail.setMailFrom("kunal0199@gmail.com");
        mail.setMailTo(email);
        mail.setMailSubject("Reset Password");
        mail.setMailContent(buildPasswordChangeEmail(name, link, token));
        mailService.sendEmail(mail);

    }

    public boolean changePassword(String email, String newPassword) {
        String newEncodedPassword = bCryptPasswordEncoder.encode(newPassword);
        AppUser appUser = (AppUser) appUserService.loadUserByUsername(email);
        appUser.setPassword(newEncodedPassword);
        appUserService.saveAppUser(appUser);
        if(appUser.getAppUserRole() == AppUserRole.PATIENT)
        {
            Patient pat = adminService.getPatient(appUser.getUname());
            pat.setPassword(newPassword);
            patientService.savePatient(pat);
        }
        else if(appUser.getAppUserRole() == AppUserRole.DOCTOR)
        {
            Doctor doc = adminService.getDoctor(appUser.getUname());
            doc.setPassword(newPassword);
            doctorService.saveDoctor(doc);
        }
        else if(appUser.getAppUserRole() == AppUserRole.SPECIALIST)
        {
            Specialist spe = adminService.getSpec(appUser.getUname());
            spe.setPassword(newPassword);
            specialistService.saveSpec(spe);
        }
        else
        {
            Admin adm = adminService.getAdmin(appUser.getUname());
            adm.setPassword(newPassword);
            adminService.saveAdmin(adm);
        }
        return true;

    }

    @Override
    public String resetPassword(String email, String newPassword, String token) {
        AppUser appUser = (AppUser) appUserService.loadUserByUsername(email);
        PasswordResetToken passwordResetToken = passwordResetTokenService.getTokenByEmail(appUser.getUname());
        if(passwordResetToken == null)
        {
            System.out.println("Token entry not found");
        }
        if(passwordResetToken.isTokenUsed())
        {
            throw new IllegalStateException("link already used");
        }
        LocalDateTime expiredAt = passwordResetToken.getExpiresAt();
        if(expiredAt.isBefore(LocalDateTime.now()))
        {
            throw new IllegalStateException("password change token expired");
        }

        if(changePassword(email, newPassword))
        {
            passwordResetToken.setTokenUsed(true);
            passwordResetTokenService.savePasswordResetToken(passwordResetToken);
            return "Password changed";
        }
        else {
            return "Old password not matched";
        }
    }

    @Override
    public void resendPasswordChangeToken(String email) {
        AppUser appUser = (AppUser) appUserService.loadUserByUsername(email);
        String token = passwordResetTokenService.generateNewToken(appUser);
        getPasswordChangeEmail(token,appUser.getEmail(),appUser.getUname(),appUser.getAppUserRole().toString().toLowerCase(Locale.ENGLISH));

    }

    @Override
    public String buildPasswordChangeEmail(String name, String link, String token) {
        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Reset your password</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + name + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">" + token + " is the verification token for password reset. Please click on the below link to reset your password: </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> <a href=\"" + link + "\">Reset Now</a> </p></blockquote>\n Token will expire in 15 minutes. <p>See you soon</p>" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";
    }
}
