package com.example.ShareTools.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Arrays;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Table(name = "images")
@RequiredArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "size")
    private Long size;
    @Column(name = "filename")
    private String fileName;
    @Column(name = "contenttype")
    private String contentType;
    @Column(name = "isdefaultimage")
    private boolean isDefaultImage;
    @Lob
    private byte[] bytes;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private HouseholdTool tool;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Image image = (Image) o;
        return id != null && Objects.equals(id, image.id);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, size, fileName, contentType, isDefaultImage, tool);
        result = 31 * result + Arrays.hashCode(bytes);
        return result;
    }
}
