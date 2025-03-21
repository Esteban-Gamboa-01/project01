package com.ironhack.project01.controller.impl;

import com.ironhack.project01.controller.interfaces.ICollectionController;
import com.ironhack.project01.model.Collection;
import com.ironhack.project01.service.impl.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CollectionController implements ICollectionController {

    @Autowired
    CollectionService collectionService;

    @GetMapping("/collections")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Collection> getCollection() {
        return collectionService.getAllCollection();
    }

    @GetMapping("/collections/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Collection getCollectionById(@PathVariable Integer id) {
        return collectionService.getCollectionById(id);
    }

    @PostMapping("/collections")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public void saveCollection(@RequestBody Collection collection) {
        collectionService.saveCollection(collection);
    }

    @PutMapping("/collections/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Override
    public void updateCollection(@RequestBody Collection collection, @PathVariable Integer id) {
        collectionService.updateCollection(collection,id);
    }

    @DeleteMapping("/collections/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void deleteCollection(@PathVariable Integer id) {
        collectionService.deleteCollection(id);
    }

    ////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/collections/composer")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Collection> getCollectionByComposer(@RequestParam String composer){
        return collectionService.getCollectionByComposer(composer);
    }

    @GetMapping("/collections/form")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Collection> getCollectionByForm(@RequestParam String form){
        return collectionService.getCollectionByForm(form);
    }

    @GetMapping("/collections/style")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<Collection> getCollectionByStyle(@RequestParam String style){
        return collectionService.getCollectionByStyle(style);
    }

}
