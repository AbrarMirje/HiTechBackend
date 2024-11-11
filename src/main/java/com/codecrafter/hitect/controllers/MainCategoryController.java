package com.codecrafter.hitect.controllers;

import com.codecrafter.hitect.entities.MainCategory;
import com.codecrafter.hitect.services.IMainCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main-category")
@RequiredArgsConstructor
public class MainCategoryController {

    private final IMainCategoryService categoryService;

    @PostMapping("/add-main-category")
    public ResponseEntity<?> addMainCategory(@RequestBody MainCategory mainCategory){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addMainCategory(mainCategory));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
