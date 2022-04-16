package com.addamsestates.image.srevice;

import com.addamsestates.image.model.BranchImages;

import java.util.List;

public interface BranchImagesService {

    public BranchImages getImageBySectionUsed(String section);

    public BranchImages getImageById(Long id);

    public List<BranchImages> getAllImages();

}
