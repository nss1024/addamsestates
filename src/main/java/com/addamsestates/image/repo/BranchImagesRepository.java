package com.addamsestates.image.repo;

import com.addamsestates.image.model.BranchImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BranchImagesRepository extends JpaRepository<BranchImages, Long> {

   // @Query("SELECT fileUrl from BranchImages bi where bi.sectionUsed = ?1")
    public BranchImages getImageBySectionUsed(String section);

}
