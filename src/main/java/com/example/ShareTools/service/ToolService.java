package com.example.ShareTools.service;

import com.example.ShareTools.model.HouseholdTool;

import java.util.List;

public interface ToolService {

    public List<HouseholdTool> getAllTools();

    public void addTool(HouseholdTool tool);

    public void deleteTool(Long id);

    public HouseholdTool getTool(Long id);

    public List<HouseholdTool> searchByTitle(String title);

}
