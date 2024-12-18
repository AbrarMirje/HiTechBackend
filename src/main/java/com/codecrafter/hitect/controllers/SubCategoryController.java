package com.codecrafter.hitect.controllers;

import com.codecrafter.hitect.entities.MainCategory;
import com.codecrafter.hitect.entities.SubCategory;
import com.codecrafter.hitect.services.ISubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sub-category")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SubCategoryController {

    private final ISubCategoryService subCategoryService;

    @PostMapping("/add-sub-category")
    public ResponseEntity<?> addSubCategory(@RequestBody SubCategory subCategory){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(subCategoryService.addSubCategory(subCategory));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/get-sub-categories")
    public ResponseEntity<?> getSubCategories(){
        return ResponseEntity.ok(subCategoryService.getSubCategories());
    }
}
