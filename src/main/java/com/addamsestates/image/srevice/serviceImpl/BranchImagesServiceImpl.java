package com.addamsestates.image.srevice.serviceImpl;

import com.addamsestates.image.model.BranchImages;
import com.addamsestates.image.repo.BranchImagesRepository;
import com.addamsestates.image.srevice.BranchImagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class BranchImagesServiceImpl implements BranchImagesService {

    @Autowired
    BranchImagesRepository branchImagesRepository;

    @Override
    public BranchImages getImageBySectionUsed(String section) {
        return branchImagesRepository.getImageBySectionUsed(section);
    }
    @Override
    public BranchImages getImageById(Long id) {
        return branchImagesRepository.getById( id);
    }

    @Override
    public List<BranchImages> getAllImages(){
        return branchImagesRepository.findAll();
    }
}
