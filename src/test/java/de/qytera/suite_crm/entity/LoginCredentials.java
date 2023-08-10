package de.qytera.suite_crm.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginCredentials {
    /**
     * Username
     */
    private String username;

    /**
     * Password
     */
    private String password;

    /**
     * Factory method for default credentials
     * @return default cerdentials
     */
    public static LoginCredentials defaultUser() {
        return LoginCredentials.builder()
                .username("user")
                .password("bitnami")
                .build();
    }
}
