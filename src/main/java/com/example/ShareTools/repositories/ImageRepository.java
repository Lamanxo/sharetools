package com.example.ShareTools.repositories;

import com.example.ShareTools.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
