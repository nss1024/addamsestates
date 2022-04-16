package com.addamsestates.mainPage.service;

import com.addamsestates.mainPage.model.CompanyIntro;

import java.util.List;

public interface CompanyIntroService {

    List<CompanyIntro> getAll();
    List<CompanyIntro> getActiveCompanyIntro(Boolean isActive);


}
