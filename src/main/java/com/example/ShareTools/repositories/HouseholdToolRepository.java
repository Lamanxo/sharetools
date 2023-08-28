package com.example.ShareTools.repositories;

import com.example.ShareTools.model.HouseholdTool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseholdToolRepository extends JpaRepository<HouseholdTool, Long> {

    List<HouseholdTool> findByTitle(String title);

}
