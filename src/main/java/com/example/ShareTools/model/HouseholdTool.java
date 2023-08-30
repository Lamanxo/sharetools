package com.example.ShareTools.model;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "owner")
    private String owner;
    @Column(name = "available")
    private boolean available;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "tool")
    private List<Image> images = new ArrayList<>();
    @Column(name = "default_image_id")
    private Long defaultImageId;
    @Column(name = "created")
    private LocalDateTime created;

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
        HouseholdTool that = (HouseholdTool) o;
        return available == that.available && Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(address, that.address) && Objects.equals(owner, that.owner) && Objects.equals(images, that.images) && Objects.equals(defaultImageId, that.defaultImageId) && Objects.equals(created, that.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, price, address, owner, available, images, defaultImageId, created);
    }
}
