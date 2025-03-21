package com.ironhack.project01.repository;

import com.ironhack.project01.model.Audition;
import com.ironhack.project01.model.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuditionRepository extends JpaRepository<Audition, Integer> {
    List<Audition> findByCollection(Collection collection);
}
