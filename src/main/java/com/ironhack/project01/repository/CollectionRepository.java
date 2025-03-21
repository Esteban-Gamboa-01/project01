package com.ironhack.project01.repository;

import com.ironhack.project01.model.Audition;
import com.ironhack.project01.model.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Integer> {
    List<Collection> findByForm(String form);
    List<Collection> findByComposer(String composer);
    List<Collection> findByStyle(String style);
}
