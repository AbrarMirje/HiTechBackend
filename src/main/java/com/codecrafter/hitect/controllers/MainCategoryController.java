package com.codecrafter.hitect.controllers;

import com.codecrafter.hitect.entities.MainCategory;
import com.codecrafter.hitect.services.IMainCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/main-category")
@RequiredArgsConstructor
@CrossOrigin("*")
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

    @GetMapping("/get-main-categories")
    public ResponseEntity<?> getMainCategories(){
        return ResponseEntity.ok(categoryService.getAllMainCategories());
    }
}
