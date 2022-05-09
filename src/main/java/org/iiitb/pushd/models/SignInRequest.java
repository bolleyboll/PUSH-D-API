package org.iiitb.pushd.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SignInRequest {
    private String username;
    private String password;
    private String role;
}
