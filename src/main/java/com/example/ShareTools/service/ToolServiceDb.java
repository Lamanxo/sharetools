package com.example.ShareTools.service;

import com.example.ShareTools.model.HouseholdTool;
import com.example.ShareTools.repositories.HouseholdToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
@RequiredArgsConstructor
public class ToolServiceDb implements ToolService {

    private final HouseholdToolRepository toolRepository;
    @Override
    public List<HouseholdTool> getAllTools() {
        return toolRepository.findAll();
    }

    @Override
    public void addTool(HouseholdTool tool) {
        tool.setAvailable(true);
        toolRepository.save(tool);
    }

    @Override
    public void deleteTool(Long id) {
        toolRepository.deleteById(id);
    }

    @Override
    public HouseholdTool getTool(Long id) {
        return toolRepository.findById(id).orElse(null);
    }

    @Override
    public List<HouseholdTool> searchByTitle(String title) {
        if(title != null) {
            return toolRepository.findByTitle(title);
        }
        return getAllTools();
    }
}
