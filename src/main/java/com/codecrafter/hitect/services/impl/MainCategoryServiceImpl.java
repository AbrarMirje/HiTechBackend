package com.codecrafter.hitect.services.impl;

import com.codecrafter.hitect.entities.MainCategory;
import com.codecrafter.hitect.repositories.IMainCategoryRepository;
import com.codecrafter.hitect.services.IMainCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainCategoryServiceImpl implements IMainCategoryService {

    private final IMainCategoryRepository mainCategoryRepository;
    @Override
    public MainCategory addMainCategory(MainCategory mainCategory) {
        mainCategory.setMainCategoryAddedDate(LocalDate.now());
        return mainCategoryRepository.save(mainCategory);
    }

    @Override
    public List<MainCategory> getAllMainCategories() {
        return mainCategoryRepository.findAll();
    }


}
