package com.codecrafter.hitect.services.impl;

import com.codecrafter.hitect.entities.MainCategory;
import com.codecrafter.hitect.repositories.IMainCategoryRepository;
import com.codecrafter.hitect.services.IMainCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MainCategoryServiceImpl implements IMainCategoryService {

    private final IMainCategoryRepository mainCategoryRepository;
    @Override
    public MainCategory addMainCategory(MainCategory mainCategory) {
        mainCategory.setMainCategoryAddedDate(LocalDate.now());
        return mainCategoryRepository.save(mainCategory);
    }


}
