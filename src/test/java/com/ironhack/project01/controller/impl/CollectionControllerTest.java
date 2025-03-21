package com.ironhack.project01.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.project01.model.Arrangements;
import com.ironhack.project01.model.Audition;
import com.ironhack.project01.model.Collection;
import com.ironhack.project01.repository.ArrangementsRepository;
import com.ironhack.project01.repository.AuditionRepository;
import com.ironhack.project01.repository.CollectionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class CollectionControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    AuditionRepository auditionRepository;

    @Autowired
    ArrangementsRepository arrangementsRepository;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Collection collection01 = new Collection();
        collection01.setComposer("Beethoven");
        collection01.setOpus("Opus 67");
        collection01.setForm("Symphony");
        collection01.setNumberForm(5);
        collection01.setInstruments("Orchestral");
        collection01.setTitle("Schicksalssinfonie");
        collection01.setTone("Do m");
        collectionRepository.save(collection01);

        Audition audition = new Audition();
        audition.setCollection(collection01);
        audition.setDirector("Gustavo Dudamel");
        audition.setBandOrchestraCoral("Symphonic Orchestra Simón Bolívar");
        audition.setLinkAudition("https://www.youtube.com/watch?v=SSypujlLlNI");
        auditionRepository.save(audition);

        Arrangements arrangements = new Arrangements();
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
    void getAllCollection_returnCollection() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/collections"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Beethoven"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Schicksalssinfonie"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Gustavo Dudamel"));
    }

    @Test
    void createCollection_collection_collectionIsCreated() throws Exception{
        Collection collection02 = new Collection();
        collection02.setComposer("Beethoven");
        collection02.setOpus("Opus 55");
        collection02.setForm("Symphony");
        collection02.setNumberForm(3);
        collection02.setInstruments("Orchestra");
        collection02.setTitle("Eroica");
        collection02.setTone("Mib M");
        collectionRepository.save(collection02);

        String body = objectMapper.writeValueAsString(collection02);
        MvcResult mvcResult = mockMvc.perform(post("/collections")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated()).andReturn();

        assertEquals(2,collectionRepository.findAll().size());
    }

    @Test
    void deleteCollection_collectionIsDeleted() throws Exception{
        assertEquals(1,collectionRepository.findAll().size());
        Integer id = collectionRepository.findAll().get(0).getCollectionId();
        MvcResult mvcResult = mockMvc.perform(delete("/collections/"+id))
                .andExpect(status().isNoContent())
                .andReturn();
        assertEquals(0,collectionRepository.findAll().size());
    }
}
