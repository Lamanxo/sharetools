package com.example.ShareTools.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "householdtools")
public class HouseholdTool {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(name = "price")
    private Double price;
    @Column(name = "address")
    private String address;
    @Column(name = "available")
    private boolean available;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "tool")
    private List<Image> images = new ArrayList<>();
    @Column(name = "default_image_id")
    private Long defaultImageId;
    @Column(name = "created")
    private LocalDateTime created;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    User user;

    @PrePersist
    private void init() {
        created = LocalDateTime.now();
    }

    public void addImages(Image image) {
        image.setTool(this);
        images.add(image);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseholdTool tool = (HouseholdTool) o;
        return available == tool.available && Objects.equals(id, tool.id) && Objects.equals(title, tool.title) && Objects.equals(description, tool.description) && Objects.equals(price, tool.price) && Objects.equals(address, tool.address) && Objects.equals(images, tool.images) && Objects.equals(defaultImageId, tool.defaultImageId) && Objects.equals(created, tool.created) && Objects.equals(user, tool.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, price, address, available, images, defaultImageId, created, user);
    }
}
