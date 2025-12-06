package com.example.studentcrud.controller;

import com.example.studentcrud.dto.StudentDTO;
import com.example.studentcrud.dto.StudentResponseDTO;
import com.example.studentcrud.model.Student;
import com.example.studentcrud.service.StudentService;
import com.example.studentcrud.util.StudentMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> create(@Valid @RequestBody StudentDTO dto) {
        Student created = service.create(dto);
        StudentResponseDTO resp = StudentMapper.toResponse(created);
        return ResponseEntity.created(URI.create("/api/students/" + resp.getId())).body(resp);
    }

    @GetMapping
    public List<StudentResponseDTO> listAll() {
        return service.listAll().stream().map(StudentMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public StudentResponseDTO getById(@PathVariable Long id) {
        Student s = service.getById(id);
        return StudentMapper.toResponse(s);
    }

    @PutMapping("/{id}")
    public StudentResponseDTO update(@PathVariable Long id, @Valid @RequestBody StudentDTO dto) {
        Student updated = service.update(id, dto);
        return StudentMapper.toResponse(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
