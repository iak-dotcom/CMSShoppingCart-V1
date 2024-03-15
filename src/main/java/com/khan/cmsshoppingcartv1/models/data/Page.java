package com.khan.cmsshoppingcartv1.models.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "pages")
// @Getter
// @Setter
@Data
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 2, message = "Title must be at least 2 characters long")
    @NotEmpty
    // @NotNull

    private String title;

    private String slug;
    
    @NotNull
    @NotEmpty
    @Size(min = 5, message = "Content must be at least 5 characters long")
    private String content;

    private int sorting;
}