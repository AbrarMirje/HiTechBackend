package com.codecrafter.hitect.controllers;

import com.codecrafter.hitect.entities.SubCategory;
import com.codecrafter.hitect.entities.SubMainCategory;
import com.codecrafter.hitect.services.ISubCategoryService;
import com.codecrafter.hitect.services.ISubMainCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sub-main-category")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SubMainCategoryController {
    private final ISubMainCategoryService subMainCategoryService;

    @PostMapping("/add-sub-main-category")
    public ResponseEntity<?> addSubMainCategory(@RequestBody SubMainCategory subMainCategory){

        System.out.println(subMainCategory);
        try {
            System.out.println("fine");
            return ResponseEntity.status(HttpStatus.CREATED).body(subMainCategoryService.addSubMainCategory(subMainCategory));
        } catch (Exception e){
            System.out.println("jhgh");
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/get-sub-main-categories")
    public ResponseEntity<?> getSubMainCategories(){
        return ResponseEntity.ok(subMainCategoryService.getAllSubMainCategories());
    }
}
