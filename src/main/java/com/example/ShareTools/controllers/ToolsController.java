package com.example.ShareTools.controllers;

import com.example.ShareTools.model.HouseholdTool;
import com.example.ShareTools.service.ToolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ToolsController {

    private final ToolService toolService;

    @GetMapping("/")
    public String tools(Model model,
                        @RequestParam (name = "title", required = false) String title) {
        model.addAttribute("tools", toolService.searchByTitle(title));
        return "tools";
    }
    @GetMapping("/tool/{id}")
    public String getToolById(Model model, @PathVariable Long id) {
        model.addAttribute("tool", toolService.getTool(id));
        return "tool-desc";
    }

    @PostMapping("/tool/create")
    public String createTool(HouseholdTool tool) {
        toolService.addTool(tool);
        return "redirect:/";
    }

    @PostMapping("/tool/delete/{id}")
    public String deleteTool(@PathVariable Long id) {
        toolService.deleteTool(id);
        return "redirect:/";
    }
}
