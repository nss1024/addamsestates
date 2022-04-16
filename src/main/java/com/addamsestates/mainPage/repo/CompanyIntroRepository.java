package com.addamsestates.mainPage.repo;

import com.addamsestates.mainPage.model.CompanyIntro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CompanyIntroRepository extends JpaRepository<CompanyIntro, Long> {

    public List<CompanyIntro> findByActive(Boolean active);

}
