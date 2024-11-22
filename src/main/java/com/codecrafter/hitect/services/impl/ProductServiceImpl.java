package com.codecrafter.hitect.services.impl;


import com.codecrafter.hitect.entities.ImageDetails;
import com.codecrafter.hitect.entities.Product;
import com.codecrafter.hitect.entities.SubCategory;
import com.codecrafter.hitect.entities.SubMainCategory;
import com.codecrafter.hitect.entities.dtos.ProductDto;
import com.codecrafter.hitect.repositories.IImageDetailsRepository;
import com.codecrafter.hitect.repositories.IProductRepository;
import com.codecrafter.hitect.services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.core.sync.RequestBody;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;
    private final IImageDetailsRepository imageDetailsRepository;

    private final S3Client s3Client;
    @Override
    public Map<String, Object> addProduct(String productName, List<MultipartFile> imageFiles, Long subMainCategoryId, Long subCategoryId) throws IOException {
        Product p = new Product();
        p.setProductName(productName);
        if(subCategoryId!=null){
            SubCategory subCategory=new SubCategory();
            subCategory.setSubCategoryId(subCategoryId);
            p.setSubCategory(subCategory);
        }
        if(subMainCategoryId!=null){
            SubMainCategory subMainCategory=new SubMainCategory();
            subMainCategory.setSubMainCategoryId(subMainCategoryId);
            p.setSubMainCategory(subMainCategory);
        }

        Product savedProduct = productRepository.save(p);


        List<String> imageUrls = new ArrayList<>();

        for (MultipartFile imageFile : imageFiles) {
            String imageName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();

            File file = convertMultipartFileToFile(imageFile);
            String bucketName = "springboot-test-0076";

            // Upload file to S3
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(imageName)
                    .build();

            PutObjectResponse response = s3Client.putObject(putObjectRequest, RequestBody.fromFile(file));

            file.delete(); // Remove temporary file after upload

            // Get S3 URL
            String imageUrl = String.format("https://%s.s3.amazonaws.com/%s", bucketName, imageName);
            imageUrls.add(imageUrl);

            // Save image details
            ImageDetails imageDetails = new ImageDetails();
            imageDetails.setImageName(imageUrl);
            imageDetails.setProduct(savedProduct);
            imageDetailsRepository.save(imageDetails);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("productId", savedProduct.getProductId());
        response.put("productName", savedProduct.getProductName());
        response.put("imageUrls", imageUrls);

        return response;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = new ProductDto();
            productDto.setProductId(product.getProductId());
            productDto.setProductName(product.getProductName());
            List<String> imageUrls = new ArrayList<>();
            List<ImageDetails> imageDetails = imageDetailsRepository.findAllByProduct(product);
            for (ImageDetails imageDetail : imageDetails) {
                imageUrls.add(imageDetail.getImageName());
            }
            productDto.setImageUrls(imageUrls);
            productDtos.add(productDto);
        }
        return productDtos;
    }


    private File convertMultipartFileToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convFile)) {
            fos.write(file.getBytes());
        }
        return convFile;
    }
}
