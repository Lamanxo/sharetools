package com.example.ShareTools.service;

import com.example.ShareTools.model.HouseholdTool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ToolServiceMem implements ToolService {
private final List<HouseholdTool> tools = new ArrayList<>();

private long ID;

    {
        tools.add(new HouseholdTool(++ID, "Drill", "Drill Makita", 10.0, "Grozny", "Salam69", true));
        tools.add(new HouseholdTool(++ID, "Saw", "Electric Saw Hitli", 15.0, "Prigorod", "IslamYuvelir", true));
    }

    @Override
    public List<HouseholdTool> getAllTools() {
        return tools;
    }
    @Override
    public void addTool(HouseholdTool tool) {
        tool.setId(++ID);
        tool.setAvailable(true);
        tools.add(tool);
    }

    @Override
    public void deleteTool(Long id) {
        tools.removeIf(tool -> tool.getId().equals(id));
    }

    @Override
    public HouseholdTool getTool(Long id) {
        for(HouseholdTool tool : tools) {
            if(tool.getId().equals(id)) {
                return tool;
            }

        } return null;
    }

    @Override
    public List<HouseholdTool> searchByTitle(String title) {
        return null;
    }
}
