package com.ironhack.project01.service.impl;

import com.ironhack.project01.model.Arrangements;
import com.ironhack.project01.model.Audition;
import com.ironhack.project01.model.Collection;
import com.ironhack.project01.repository.ArrangementsRepository;
import com.ironhack.project01.repository.CollectionRepository;
import com.ironhack.project01.service.interfaces.ICollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollectionService implements ICollectionService {

    @Autowired
    CollectionRepository collectionRepository;

    ////////////////////////////////////////// GET

    @Override
    public List<Collection> getAllCollection() {
        return collectionRepository.findAll();
    }

    @Override
    public Collection getCollectionById(Integer id) {
        return collectionRepository.findById(id).get();
    }

    ////////////////////////////////////////// POST

    @Override
    public void saveCollection(Collection collection) {
        collectionRepository.save(collection);
    }

    ////////////////////////////////////////// UPDATE

    @Override
    public void updateCollection(Collection collection, Integer id){
        Optional<Collection> optionalCollection = collectionRepository.findById(id);
        if(optionalCollection.isEmpty()) return;
        collection.setCollectionId(optionalCollection.get().getCollectionId());
        collectionRepository.save(collection);
    }

    ////////////////////////////////////////// DELETE

    @Override
    public void deleteCollection(Integer id){
       Optional<Collection> optionalCollection = collectionRepository.findById(id);
       if (optionalCollection.isEmpty()) return;
       collectionRepository.delete(optionalCollection.get());
    }

    ////////////////////////////////////////// MORE OPTIONS

    @Override
    public List<Collection> getCollectionByForm(String form){
        return collectionRepository.findByForm(form);
    }

    @Override
    public List<Collection> getCollectionByComposer(String composer){
        return collectionRepository.findByComposer(composer);
    }

    @Override
    public List<Collection> getCollectionByStyle(String style){
        return collectionRepository.findByForm(style);
    }

}
