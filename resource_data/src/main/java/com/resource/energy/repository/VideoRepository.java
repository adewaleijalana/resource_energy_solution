package com.resource.energy.repository;

import com.resource.energy.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, String> {

    @Query("select a from Video a where a.title = ?1")
    Optional<Video> findByTitle(String title);
}
