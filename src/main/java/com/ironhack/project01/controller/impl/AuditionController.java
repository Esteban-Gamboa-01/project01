package com.ironhack.project01.controller.impl;

import com.ironhack.project01.controller.interfaces.IAuditionController;
import com.ironhack.project01.model.Audition;
import com.ironhack.project01.repository.CollectionRepository;
import com.ironhack.project01.service.impl.AuditionService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class AuditionController implements IAuditionController {

    @Autowired
    AuditionService auditionService;

    @GetMapping("/auditions")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Audition> getAudition() {
        return auditionService.getAllAudition();
    }

    @GetMapping("/auditions/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Audition getAuditionById(@PathVariable Integer id) {
        return auditionService.getAuditionById(id);
    }

    @PostMapping("/auditions")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public void saveAudition(@RequestBody Audition audition) {
        auditionService.saveAudition(audition);
    }

    @PutMapping("/auditions/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Override
    public void updateAudition(@RequestBody Audition audition, @PathVariable Integer id) {
        auditionService.updateAudition(audition, id);
    }

    @DeleteMapping("/auditions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void deleteAudition(@PathVariable Integer id) {
        auditionService.deleteAudition(id);
    }

    ////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/auditions/collection/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Audition> getAuditionByCollection(@PathVariable Integer id) {
        return auditionService.getAuditionByCollection(id);
    }


}
