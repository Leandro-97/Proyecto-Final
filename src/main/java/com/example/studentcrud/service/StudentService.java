package com.example.studentcrud.service;

import com.example.studentcrud.dto.StudentDTO;
import com.example.studentcrud.exception.NotFoundException;
import com.example.studentcrud.model.Student;
import com.example.studentcrud.repository.StudentRepository;
import com.example.studentcrud.util.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student create(StudentDTO dto) {
        Student s = StudentMapper.toModel(dto);
        return repo.save(s);
    }

    public List<Student> listAll() {
        // example of streams usage
        return repo.findAll().stream().collect(Collectors.toList());
    }

    public Student getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Student not found with id: " + id));
    }

    public Student update(Long id, StudentDTO dto) {
        Student existing = getById(id);
        StudentMapper.updateModel(existing, dto);
        return repo.save(existing);
    }

    public void delete(Long id) {
        // ensure exists
        getById(id);
        repo.deleteById(id);
    }
}
