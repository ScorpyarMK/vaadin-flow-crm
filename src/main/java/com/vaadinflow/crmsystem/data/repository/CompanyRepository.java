package com.vaadinflow.crmsystem.data.repository;

import com.vaadinflow.crmsystem.data.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
