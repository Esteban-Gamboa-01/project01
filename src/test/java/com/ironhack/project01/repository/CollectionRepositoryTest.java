package com.ironhack.project01.repository;

import com.ironhack.project01.model.Arrangements;
import com.ironhack.project01.model.Audition;
import com.ironhack.project01.model.Collection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

    @SpringBootTest
    public class CollectionRepositoryTest {

        @Autowired
        CollectionRepository collectionRepository;

        @Autowired
        AuditionRepository auditionRepository;

        @Autowired
        ArrangementsRepository arrangementsRepository;

        Collection collection01;
        Collection collection03;
        Audition audition;
        Arrangements arrangements;

        @BeforeEach
        void sepUp(){
            collection01 = new Collection();
            collection01.setComposer("Beethoven");
            collection01.setOpus("Opus 67");
            collection01.setForm("Symphony");
            collection01.setNumberForm(5);
            collection01.setInstruments("Orchestral");
            collection01.setTitle("Schicksalssinfonie");
            collection01.setTone("Do m");
            collectionRepository.save(collection01);

            audition = new Audition();
            audition.setCollection(collection01);
            audition.setDirector("Gustavo Dudamel");
            audition.setBandOrchestraCoral("Symphonic Orchestra Simón Bolívar");
            audition.setLinkAudition("https://www.youtube.com/watch?v=SSypujlLlNI");
            auditionRepository.save(audition);

            arrangements = new Arrangements();
            arrangements.setCollection(collection01);
            arrangements.setInstruments("2 Pianofortes");
            arrangements.setLinkArrangements("https://ks15.imslp.org/files/imglnks/usimg/4/4f/IMSLP147758-PMLP01586-Beethoven-Op067_2Pf8H_piano1.pdf");
            arrangementsRepository.save(arrangements);
        }

        @AfterEach
        void tearDown(){
            auditionRepository.deleteAll();
            arrangementsRepository.deleteAll();
            collectionRepository.deleteAll();
        }

        @Test
        void getComposer_valueAudition_composerIsCorrect(){
            assertEquals("Beethoven",audition.getCollection().getComposer());
        }

        @Test
        void getAuditionOfCollection_valueArrangements_auditionIsCorrect(){
            Collection collection02 = arrangements.getCollection();
            List<Audition> audition01 = auditionRepository.findByCollection(collection02);
            assertEquals(audition01.get(0).getLinkAudition(), audition.getLinkAudition());
            assertEquals(audition01.get(0).getDirector(), audition.getDirector());
        }

        @Test
        void getOpusSameForm_valueForm(){
            List<Collection> listForm = new ArrayList<>();
            listForm = collectionRepository.findByForm("Symphony");
            assertEquals(1,listForm.size());

            collection03 = new Collection();
            collection03.setComposer("Beethoven");
            collection03.setOpus("Opus 55");
            collection03.setForm("Symphony");
            collection03.setNumberForm(3);
            collection03.setInstruments("Orchestra");
            collection03.setTitle("Eroica");
            collection03.setTone("Mib M");
            collectionRepository.save(collection03);

            listForm = collectionRepository.findByForm("Symphony");
            assertEquals(2, listForm.size());
        }
    }

