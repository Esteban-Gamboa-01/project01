package com.ironhack.project01.service.interfaces;

import com.ironhack.project01.model.Arrangements;
import com.ironhack.project01.model.Collection;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface ICollectionService {

    List<Collection> getAllCollection();
    Collection getCollectionById(Integer id);
    void saveCollection(Collection collection);
    void updateCollection(Collection collection, Integer id);
    void deleteCollection(Integer id);


    List<Collection> getCollectionByComposer(String composer);
    List<Collection> getCollectionByForm(String form);
    List<Collection> getCollectionByStyle(String style);
    //saveCollectionIfNotExist(Collection collection);

    //List<Collection> getCollectionByString(String word);
    //Show the subclass mov-nature
}
