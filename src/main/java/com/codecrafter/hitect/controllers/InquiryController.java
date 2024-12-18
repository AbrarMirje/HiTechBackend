package com.codecrafter.hitect.controllers;

import com.codecrafter.hitect.entities.InquiryForm;
import com.codecrafter.hitect.services.IInquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inquiry")
public class InquiryController {
    private final IInquiryService inquiryService;

    @PostMapping("/add-inquiry-form")
    public ResponseEntity<?> addInquiryForm(@RequestBody InquiryForm inquiryForm) {
        return ResponseEntity.ok(inquiryService.inquiryForm(inquiryForm));
    }
    @GetMapping("/get-inquiry-forms")
    public ResponseEntity<?> getInquiryForms() {
        return ResponseEntity.ok(inquiryService.getInquiryForms());
    }
}
