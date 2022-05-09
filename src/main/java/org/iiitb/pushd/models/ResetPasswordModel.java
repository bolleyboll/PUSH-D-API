package org.iiitb.pushd.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResetPasswordModel {
    private String email;
    private String newpassword;
    private String token;
}
