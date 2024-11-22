package com.codecrafter.hitect.services.impl;

import com.codecrafter.hitect.entities.SubMainCategory;
import com.codecrafter.hitect.repositories.ISubMainCategoryRepository;
import com.codecrafter.hitect.services.ISubMainCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubMainCategoryServiceImpl implements ISubMainCategoryService {

    private final ISubMainCategoryRepository subMainCategoryRepository;
    @Override
    public SubMainCategory addSubMainCategory(SubMainCategory subMainCategory) {
        subMainCategory.setSubMainCategoryAddedDate(LocalDate.now());
        return subMainCategoryRepository.save(subMainCategory);
    }

    @Override
    public List<SubMainCategory> getAllSubMainCategories() {
        return subMainCategoryRepository.findAll();
    }
}
