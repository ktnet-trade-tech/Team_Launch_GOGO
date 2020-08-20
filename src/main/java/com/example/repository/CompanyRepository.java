package com.example.repository;

import com.example.domain.company.Company;
import com.example.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    Optional<Company> findByName(String name);
}
