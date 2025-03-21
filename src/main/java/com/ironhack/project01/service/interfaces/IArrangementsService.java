package com.ironhack.project01.service.interfaces;

import com.ironhack.project01.model.Arrangements;
import com.ironhack.project01.model.Audition;

import java.util.List;

public interface IArrangementsService {

    List<Arrangements> getAllArrangements();
    Arrangements getArrangementsById(Integer id);
    void saveArrangements(Arrangements arrangements);
    void updateArrangements(Arrangements arrangements, Integer id);
    void deleteArrangements(Integer id);

    List<Arrangements> getArrangementsByCollection(Integer id);
    void deleteArrangementsByCollection(Integer id);
    //saveCollectionIfNotExist(Arrangements arrangements); //modified method line 12
    //saveAuditionIfNotExist(Arrangements arrangements);
}
