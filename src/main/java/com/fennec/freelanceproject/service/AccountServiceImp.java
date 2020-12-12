package com.fennec.freelanceproject.service;

import com.fennec.freelanceproject.model.AppRole;
import com.fennec.freelanceproject.model.AppUser;
import com.fennec.freelanceproject.repository.AppRoleRepository;
import com.fennec.freelanceproject.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImp implements AccountService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Bean
    private BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public AppUser saveUser(AppUser user) {
        user.setPassword(bCryptPasswordEncoder().encode(user.getPassword()));
        return appUserRepository.save(user);
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public AppUser findUserByUsername(String username) {
        AppUser user = appUserRepository.findByUsername(username);
        return user;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = appUserRepository.findByUsername(username);
        AppRole role = appRoleRepository.findByRolename(roleName);
        user.getRoles().add(role);
    }
}
