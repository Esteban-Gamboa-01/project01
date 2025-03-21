package com.ironhack.project01.service.interfaces;

import com.ironhack.project01.model.Audition;
import com.ironhack.project01.model.Collection;

import java.util.List;

public interface IAuditionService {

    List<Audition> getAllAudition();
    Audition getAuditionById(Integer id);
    void saveAudition(Audition audition);
    void updateAudition(Audition audition, Integer id);
    void deleteAudition(Integer id);

    List<Audition> getAuditionByCollection(Integer id);
    //saveCollectionIfNotExist(Audition audition);  //modified the method line 12
    //saveAuditionIfNotExist(Audition collection);
}
