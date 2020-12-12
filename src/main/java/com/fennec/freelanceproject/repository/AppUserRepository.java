package com.fennec.freelanceproject.repository;

import com.fennec.freelanceproject.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@RepositoryRestResource
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);
}
