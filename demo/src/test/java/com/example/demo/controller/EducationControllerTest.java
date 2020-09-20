package com.example.demo.controller;

import com.example.demo.entity.EducationEntity;
import com.example.demo.entity.PersonEntity;
import com.example.demo.repository.EducationRepository;
import com.example.demo.repository.PersonRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EducationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    EducationRepository educationRepository;
    @Autowired
    PersonRepository personRepository;


    @Test
    public void shouldGetEducation() throws Exception {
        mockMvc.perform(get("/users/1/educations"))
                .andExpect(jsonPath("$[0].userId", is(1)));
    }

    @Test
    public void shouldNotGetEducation() throws Exception {
        mockMvc.perform(get("/users/3/educations"))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void shouldSuccessAddEducationInfo() throws Exception {
        EducationEntity info = EducationEntity.builder()
                .title("Secondary school specializing in artistic")
                .year(2005)
                .description("Eos, explicabo, nam, tenetur et ab eius deserunt aspernatur ipsum ducimus quibusdam quis voluptatibus.")
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(info);
        System.out.println(requestJson);
        mockMvc.perform(post("/users/1/educations").content(requestJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        assertEquals(educationRepository.findAll().size(), 3);
    }

    @Test
    public void shouldFailAddEducationInfo() throws Exception {
        EducationEntity info = EducationEntity.builder()
                .title("Secondary school specializing in artistic")
                .year(2005)
                .description("Eos, explicabo, nam, tenetur et ab eius deserunt aspernatur ipsum ducimus quibusdam quis voluptatibus.")
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(info);
        System.out.println(requestJson);

        mockMvc.perform(post("/users/3/educations").content(requestJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}