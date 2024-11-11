package com.codecrafter.hitect.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "submaincategories")
public class SubMainCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subMainCategoryId;
    private String subMainCategoryName;
    private LocalDate subMainCategoryAddedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mainCategoryId")
    private MainCategory mainCategory;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subMainCategory", cascade = CascadeType.ALL)
    private List<Product> products;


}
