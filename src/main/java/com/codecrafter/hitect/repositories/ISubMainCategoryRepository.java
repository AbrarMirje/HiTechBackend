package com.codecrafter.hitect.repositories;

import com.codecrafter.hitect.entities.SubMainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubMainCategoryRepository extends JpaRepository<SubMainCategory,Long> {
}
