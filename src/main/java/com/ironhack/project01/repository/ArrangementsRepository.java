package com.ironhack.project01.repository;

import com.ironhack.project01.model.Arrangements;
import com.ironhack.project01.model.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArrangementsRepository extends JpaRepository<Arrangements, Integer> {
    List<Arrangements> findByCollection (Collection collection);
}
