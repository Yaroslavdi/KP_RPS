package com.example.chemistry.controllers;

import com.example.chemistry.models.Image;
import com.example.chemistry.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageRepository imageRepository;

    @GetMapping("/admin/images/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Long id) {
        Image image = imageRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
    @GetMapping("/main/images/{id}")
    private ResponseEntity<?> mainGetImageById(@PathVariable Long id) {
        Image image1 = imageRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName", image1.getOriginalFileName())
                .contentType(MediaType.valueOf(image1.getContentType()))
                .contentLength(image1.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image1.getBytes())));
    }
}
