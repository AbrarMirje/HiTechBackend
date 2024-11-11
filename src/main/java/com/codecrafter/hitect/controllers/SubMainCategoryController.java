package com.codecrafter.hitect.controllers;

import com.codecrafter.hitect.entities.SubCategory;
import com.codecrafter.hitect.entities.SubMainCategory;
import com.codecrafter.hitect.services.ISubCategoryService;
import com.codecrafter.hitect.services.ISubMainCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sub-main-category")
@RequiredArgsConstructor
public class SubMainCategoryController {
    private final ISubMainCategoryService subMainCategoryService;

    @PostMapping("/add-sub-main-category")
    public ResponseEntity<?> addSubMainCategory(@RequestBody SubMainCategory subMainCategory){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(subMainCategoryService.addSubMainCategory(subMainCategory));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
