package com.codecrafter.hitect.repositories;

import com.codecrafter.hitect.entities.ImageDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageDetailsRepository extends JpaRepository<ImageDetails, Long> {
}
