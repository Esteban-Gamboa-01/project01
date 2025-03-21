package com.ironhack.project01.service.impl;

import com.ironhack.project01.model.Arrangements;
import com.ironhack.project01.model.Audition;
import com.ironhack.project01.model.Collection;
import com.ironhack.project01.repository.ArrangementsRepository;
import com.ironhack.project01.repository.AuditionRepository;
import com.ironhack.project01.repository.CollectionRepository;
import com.ironhack.project01.service.interfaces.IAuditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditionService implements IAuditionService {

    @Autowired
    AuditionRepository auditionRepository;

    @Autowired
    CollectionRepository collectionRepository;

    ////////////////////////////////////////// GET

    @Override
    public List<Audition> getAllAudition() {
        return auditionRepository.findAll();
    }

    @Override
    public Audition getAuditionById(Integer id) {
        return auditionRepository.findById(id).get();
    }

    ////////////////////////////////////////// POST

    @Override
    public void saveAudition(Audition audition) {
        auditionRepository.save(audition);
    }

    ////////////////////////////////////////// UPDATE

    @Override
    public void updateAudition(Audition audition, Integer id) {
        Optional<Audition> optionalAudition = auditionRepository.findById(id);
        if(optionalAudition.isEmpty()) return;
        audition.setAuditionId(optionalAudition.get().getAuditionId());
        auditionRepository.save(audition);
    }

    ////////////////////////////////////////// DELETE

    @Override
    public void deleteAudition(Integer id) {
        Optional<Audition> optionalAudition = auditionRepository.findById(id);
        if (optionalAudition.isEmpty()) return;
        auditionRepository.delete(optionalAudition.get());
    }

    ////////////////////////////////////////// MORE OPTIONS

    @Override
    public List<Audition> getAuditionByCollection(Integer id){
        if(collectionRepository.findById(id).isEmpty()) return null;
        return collectionRepository.findById(id).get().getAudition();
    }
}
