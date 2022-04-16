package com.addamsestates.mainPage.service.serviceImplementation;

import lombok.RequiredArgsConstructor;
import com.addamsestates.mainPage.model.CompanyIntro;
import com.addamsestates.mainPage.repo.CompanyIntroRepository;
import com.addamsestates.mainPage.service.CompanyIntroService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class CompanyIntroServiceImpl implements CompanyIntroService {

    private final CompanyIntroRepository ciRepo;

    @Override
    public List<CompanyIntro> getAll() {
        return ciRepo.findAll();
    }

    @Override
    public List<CompanyIntro> getActiveCompanyIntro(Boolean isActive) {
        return ciRepo.findByActive(isActive);
    }
}
