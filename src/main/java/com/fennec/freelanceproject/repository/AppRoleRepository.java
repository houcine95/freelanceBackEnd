package com.fennec.freelanceproject.repository;

import com.fennec.freelanceproject.model.AppRole;
import com.fennec.freelanceproject.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRolename(String rolename);
}
