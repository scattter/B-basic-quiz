package com.example.demo.controller;

import com.example.demo.entity.EducationEntity;
import com.example.demo.entity.PersonEntity;
import com.example.demo.exception.UserIdNotExistException;
import com.example.demo.repository.EducationRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.EducationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EducationController.class)
@AutoConfigureMockMvc
class EducationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    EducationService educationService;


    @Test
    public void shouldGetEducation() throws Exception {
        List<EducationEntity> result = new ArrayList<>();
        result.add(EducationEntity.builder()
                .year(2005)
                .build());
        when(educationService.getEducationInfoById((long) 1)).thenReturn(result);
        mockMvc.perform(get("/users/1/educations"))
                .andExpect(jsonPath("$[0].year", is(2005)));
    }

    @Test
    public void shouldNotGetEducation() throws Exception {
        List<EducationEntity> result = new ArrayList<>();
        when(educationService.getEducationInfoById((long) 3)).thenReturn(result);
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

        doNothing().when(educationService).addEducationInfo((long) 1,info);
        mockMvc.perform(post("/users/1/educations").content(requestJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
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

        doThrow(new UserIdNotExistException("this user isn't exist")).when(educationService).addEducationInfo((long) 3,info);
        mockMvc.perform(post("/users/3/educations")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}