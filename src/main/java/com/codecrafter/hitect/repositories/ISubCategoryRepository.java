package com.codecrafter.hitect.repositories;

import com.codecrafter.hitect.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubCategoryRepository extends JpaRepository<SubCategory, Long> {
}
