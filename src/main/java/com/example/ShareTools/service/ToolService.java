package com.example.ShareTools.service;

import com.example.ShareTools.model.HouseholdTool;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ToolService {

    public List<HouseholdTool> getAllTools();

    public void addTool(HouseholdTool tool, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException;

    public void deleteTool(Long id);

    public HouseholdTool getTool(Long id);

    public List<HouseholdTool> searchByTitle(String title);

}
