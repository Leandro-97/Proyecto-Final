package com.example.studentcrud;

import com.example.studentcrud.dto.StudentDTO;
import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.StudentRepository;
import com.example.studentcrud.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {
    private StudentRepository repo;
    private StudentService service;

    @BeforeEach
    public void setup() {
        repo = new StudentRepository();
        service = new StudentService(repo);
    }

    @Test
    public void createAndGetStudent() {
        StudentDTO dto = new StudentDTO();
        dto.setFirstName("Juan");
        dto.setLastName("Perez");
        dto.setEmail("juan@example.com");
        dto.setBirthDate(LocalDate.of(2000,1,1));

        Student created = service.create(dto);
        assertNotNull(created.getId());

        Student fetched = service.getById(created.getId());
        assertEquals("Juan", fetched.getFirstName());
    }

    @Test
    public void listAll_emptyThenOne() {
        assertTrue(service.listAll().isEmpty());
        StudentDTO dto = new StudentDTO();
        dto.setFirstName("A");
        dto.setLastName("B");
        dto.setEmail("a@b.com");
        dto.setBirthDate(LocalDate.of(1990,1,1));
        service.create(dto);
        assertEquals(1, service.listAll().size());
    }
}
