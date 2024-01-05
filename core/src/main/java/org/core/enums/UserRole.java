package org.core.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {

    ROLE_ADMIN, ROLE_USER, ROLE_CLIENT, ROLE_DOCTOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
