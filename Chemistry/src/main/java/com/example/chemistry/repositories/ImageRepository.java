package com.example.chemistry.repositories;

import com.example.chemistry.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByName(String name);
}
