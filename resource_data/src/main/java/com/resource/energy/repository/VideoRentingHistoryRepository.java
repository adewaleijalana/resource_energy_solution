package com.resource.energy.repository;

import com.resource.energy.domain.VideoRentingHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.Date;

@Repository
public interface VideoRentingHistoryRepository extends JpaRepository<VideoRentingHistory, String> {

    @Query(nativeQuery = true,
            value = "select * from renting_history  where username = ?1 or DATE(created_date) = ?2")
    Page<VideoRentingHistory>
    findAllByUsernameOrCreatedBy(String username, ZonedDateTime createdDate, Pageable pageable);

    Page<VideoRentingHistory>
    findAllByUsername(String username, Pageable pageable);
}
