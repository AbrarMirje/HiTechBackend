package com.codecrafter.hitect.services.impl;

import com.codecrafter.hitect.entities.SubCategory;
import com.codecrafter.hitect.entities.SubMainCategory;
import com.codecrafter.hitect.repositories.ISubCategoryRepository;
import com.codecrafter.hitect.services.ISubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements ISubCategoryService {

    private final ISubCategoryRepository subCategoryRepository;
    @Override
    public SubCategory addSubCategory(SubCategory subCategory) {
        subCategory.setSubCategoryAddedDate(LocalDate.now());
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public List<SubCategory> getSubCategories() {
        return subCategoryRepository.findAll();
    }
}
