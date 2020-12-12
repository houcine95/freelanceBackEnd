package com.fennec.freelanceproject.service;

import com.fennec.freelanceproject.model.AppRole;
import com.fennec.freelanceproject.model.AppUser;

public interface AccountService {

    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole role);
    public AppUser findUserByUsername(String  username);
    public void addRoleToUser(String username, String role);
}
