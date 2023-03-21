package com.ram.entity;

public enum RoleType {
    MASTER,
    NON_MASTER;

    public RoleType toString(RoleType roleType) {
        return toString(MASTER);
    }

    public RoleType toString1(RoleType roleType) {
        return toString(NON_MASTER);
    }

}
