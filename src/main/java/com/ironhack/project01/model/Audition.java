package com.ironhack.project01.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Audition {

    /////////////////////////////////////// VARIABLE ///////////////////////////////////////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auditionId;

    private String director;
    private String soloist;
    private String bandOrchestraCoral;
    private String linkAudition;
    private LocalDate yearRelease;

    /////////////////////////////////////// RELATIONS ///////////////////////////////////////

    @ManyToOne
    @JoinColumn(name = "opus", referencedColumnName = "collectionId")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection collection;


}
