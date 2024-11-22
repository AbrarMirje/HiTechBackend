package com.codecrafter.hitect.controllers;

import com.codecrafter.hitect.entities.Product;
import com.codecrafter.hitect.entities.SubCategory;
import com.codecrafter.hitect.entities.SubMainCategory;
import com.codecrafter.hitect.entities.dtos.ProductDto;
import com.codecrafter.hitect.services.IProductService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {

    private final IProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(
            @RequestParam("productName") String productName,
            @RequestParam("productImages") List<MultipartFile> productImages,
            @RequestParam(value = "subMainCategoryId", required = false) @Nullable Long subMainCategoryId,
            @RequestParam(value = "subCategoryId", required = false) @Nullable Long subCategoryId
            ) throws IOException {
        try {
            // Upload product with multiple images
            Map<String, Object> response = productService.addProduct(productName, productImages,subMainCategoryId,subCategoryId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(500).body("Error uploading product or images: " + e.getMessage());
        }
    }

    @GetMapping("/getProducts")
    public ResponseEntity<?> getProducts() {
        try {
            List<ProductDto> products = productService.getAllProducts();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(500).body("Error getting products: " + e.getMessage());
        }
    }
}
