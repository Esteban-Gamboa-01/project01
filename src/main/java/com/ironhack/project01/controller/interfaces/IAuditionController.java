package com.ironhack.project01.controller.interfaces;

import com.ironhack.project01.model.Audition;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IAuditionController {

    List<Audition> getAudition();
    Audition getAuditionById(Integer id);
    void saveAudition(Audition audition);
    void updateAudition(Audition audition, Integer id);
    void deleteAudition(Integer id);

    List<Audition> getAuditionByCollection(Integer id);
    //saveCollectionIfNotExist(Audition audition);  //modified the method line 12
    //saveAuditionIfNotExist(Audition collection);
}
