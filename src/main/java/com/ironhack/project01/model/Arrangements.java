package com.ironhack.project01.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Arrangements {

    /////////////////////////////////////// VARIABLE ///////////////////////////////////////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer arrangementsId;

    private String instruments;
    private String linkArrangements;

    //private _____ fileArrangements;

    /////////////////////////////////////// RELATIONS ///////////////////////////////////////

    @ManyToOne
    @JoinColumn(name = "opus", referencedColumnName = "collectionId")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection collection;



}
