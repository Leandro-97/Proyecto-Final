package com.example.studentcrud;

import com.example.studentcrud.controller.StudentController;
import com.example.studentcrud.dto.StudentDTO;
import com.example.studentcrud.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = StudentController.class)
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService service;

    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        mapper.findAndRegisterModules();
    }

    @Test
    public void createStudent_valid() throws Exception {
        StudentDTO dto = new StudentDTO();
        dto.setFirstName("Ana");
        dto.setLastName("Lopez");
        dto.setEmail("ana@example.com");
        dto.setBirthDate(LocalDate.of(1995,5,5));

        // keep simple: mock service to return a model with id
        when(service.create(any())).thenAnswer(inv -> {
            com.example.studentcrud.model.Student s = new com.example.studentcrud.model.Student(1L, dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getBirthDate());
            return s;
        });

        mockMvc.perform(post("/api/students")
                .contentType("application/json")
                .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "/api/students/1"));
    }
}
