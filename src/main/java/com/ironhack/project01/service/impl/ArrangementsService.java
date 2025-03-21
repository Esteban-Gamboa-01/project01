package com.ironhack.project01.service.impl;

import com.ironhack.project01.model.Arrangements;
import com.ironhack.project01.model.Audition;
import com.ironhack.project01.model.Collection;
import com.ironhack.project01.repository.ArrangementsRepository;
import com.ironhack.project01.repository.CollectionRepository;
import com.ironhack.project01.service.interfaces.IArrangementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArrangementsService implements IArrangementsService {

    @Autowired
    ArrangementsRepository arrangementsRepository;

    @Autowired
    CollectionRepository collectionRepository;

    ////////////////////////////////////////// GET

    @Override
    public List<Arrangements> getAllArrangements() {
        return arrangementsRepository.findAll();
    }

    @Override
    public Arrangements getArrangementsById(Integer id) {
        return arrangementsRepository.findById(id).get();
    }

    ////////////////////////////////////////// POST

    @Override
    public void saveArrangements(Arrangements arrangements) {
        arrangementsRepository.save(arrangements);
    }

    ////////////////////////////////////////// UPDATE
    @Override
    public void updateArrangements(Arrangements arrangements, Integer id) {
            Optional<Arrangements> optionalArrangements = arrangementsRepository.findById(id);
            if(optionalArrangements.isEmpty()) return;
        arrangements.setArrangementsId(optionalArrangements.get().getArrangementsId());
        arrangementsRepository.save(arrangements);
    }

    ////////////////////////////////////////// DELETE

    @Override
    public void deleteArrangements(Integer id) {
        Optional<Arrangements> optionalArrangements = arrangementsRepository.findById(id);
        if (optionalArrangements.isEmpty()) return;
        arrangementsRepository.delete(optionalArrangements.get());
    }

    ////////////////////////////////////////// MORE OPTIONS

    public List<Arrangements> getArrangementsByCollection(Integer id){
        if(collectionRepository.findById(id).isEmpty()) return null;
        return collectionRepository.findById(id).get().getArrangements();
    }

    public void deleteArrangementsByCollection(Integer id) {
        if(collectionRepository.findById(id).isEmpty()) return;
        List<Arrangements> arrangementsForDeleting = collectionRepository.findById(id).get().getArrangements();

        for (int i=0; i<arrangementsForDeleting.size(); i++){
            arrangementsRepository.delete(arrangementsForDeleting.get(i));
        }
    }
}
