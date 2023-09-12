package com.example.ShareTools.service;

import com.example.ShareTools.model.HouseholdTool;
import com.example.ShareTools.model.Image;
import com.example.ShareTools.model.User;
import com.example.ShareTools.repositories.HouseholdToolRepository;
import com.example.ShareTools.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Slf4j
@Primary
@Service
@RequiredArgsConstructor
public class ToolServiceDb {

    private final HouseholdToolRepository toolRepository;
    private final UserRepository userRepo;
    public List<HouseholdTool> getAllTools() {
        return toolRepository.findAll();
    }

    public void addTool(Principal principal, HouseholdTool tool, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        tool.setUser(getUserByPrincipal(principal));
        Image image1;
        Image image2;
        Image image3;
        if(file1.getSize() != 0) {
            image1 = makeImage(file1);
            image1.setDefaultImage(true);
            tool.addImages(image1);
        }
        if(file2.getSize() != 0) {
            image2 = makeImage(file2);
            tool.addImages(image2);
        }
        if(file3.getSize() != 0) {
            image3 = makeImage(file3);
            tool.addImages(image3);
        }

        tool.setAvailable(true);
        HouseholdTool toolFromDb = toolRepository.save(tool);
        if(!toolFromDb.getImages().isEmpty()) {
            toolFromDb.setDefaultImageId(toolFromDb.getImages().get(0).getId());
        }
        toolRepository.save(toolFromDb);
    }

    public User getUserByPrincipal(Principal principal) {
        if(principal == null) return new User();
        return userRepo.findByEmail(principal.getName());
    }

    private Image makeImage(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setSize(file.getSize());
        image.setFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteTool(Long id) {
        toolRepository.deleteById(id);
    }

    public HouseholdTool getTool(Long id) {
        HouseholdTool tool = toolRepository.findById(id).orElse(null);
        log.warn("Actual size {}", tool.getImages().size());
        return tool;
    }

    public List<HouseholdTool> searchByTitle(String title) {
        if(title != null) {
            return toolRepository.findByTitle(title);
        }
        return getAllTools();
    }
}