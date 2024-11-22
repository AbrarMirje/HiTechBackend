package com.codecrafter.hitect.services;

import com.codecrafter.hitect.entities.SubMainCategory;

import java.util.List;

public interface ISubMainCategoryService {
    SubMainCategory addSubMainCategory(SubMainCategory subMainCategory);

    List<SubMainCategory> getAllSubMainCategories();
}
