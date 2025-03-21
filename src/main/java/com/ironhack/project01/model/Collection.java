package com.ironhack.project01.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Collection {

    /////////////////////////////////////// VARIABLE ///////////////////////////////////////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer collectionId;

    private String composer;
    private String opus;
    private String form;
    private Integer numberForm;
    private String instruments;
    private String title;
    private String tone;

    private String style;
    private LocalDate yearRelease;
    //private LocalDate yearComposition;
    private String linkScore;

    //private String keyword

    //private Integer mov;
    //private String nature;

    //private _____ fileScore;

    /////////////////////////////////////// RELATIONS ///////////////////////////////////////

    @OneToMany(mappedBy = "collection", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = {"collection"}, allowSetters = true)
    private List<Audition> audition;

    @OneToMany(mappedBy = "collection", cascade = CascadeType.REMOVE)
    private  List<Arrangements> arrangements;


}
