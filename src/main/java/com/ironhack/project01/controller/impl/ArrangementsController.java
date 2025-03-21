package com.ironhack.project01.controller.impl;

import com.ironhack.project01.controller.interfaces.IArrangementsController;
import com.ironhack.project01.model.Arrangements;
import com.ironhack.project01.model.Audition;
import com.ironhack.project01.service.impl.ArrangementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArrangementsController implements IArrangementsController {

    @Autowired
    ArrangementsService arrangementsService;

    @GetMapping("/arrangements")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Arrangements> getArrangements() {
        return arrangementsService.getAllArrangements();
    }

    @GetMapping("/arrangements/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Arrangements getArrangementsById(@PathVariable Integer id) {
        return arrangementsService.getArrangementsById(id);
    }

    @PostMapping("/arrangements")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public void saveArrangements(@RequestBody Arrangements arrangements) {
        arrangementsService.saveArrangements(arrangements);
    }

    @PutMapping("/arrangements/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Override
    public void updateArrangements(@RequestBody Arrangements arrangements, @PathVariable Integer id) {
        arrangementsService.updateArrangements(arrangements,id);
    }

    @DeleteMapping("/arrangements")
    @Override
    public void deleteArrangements(@PathVariable Integer id) {
        arrangementsService.deleteArrangements(id);
    }

    ////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/arrangements/collection/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Arrangements> getArrangementsByCollection(@PathVariable Integer id) {
        return arrangementsService.getArrangementsByCollection(id);
    }

    @DeleteMapping("/arrangements/collection/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void deleteArrangementsByCollection(@PathVariable Integer id) {
        arrangementsService.deleteArrangementsByCollection(id);
    }
}
