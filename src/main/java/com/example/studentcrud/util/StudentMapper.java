package com.example.studentcrud.util;

import com.example.studentcrud.model.Student;
import com.example.studentcrud.dto.StudentDTO;
import com.example.studentcrud.dto.StudentResponseDTO;

public class StudentMapper {
    public static Student toModel(StudentDTO dto) {
        return new Student(null, dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getBirthDate());
    }

    public static StudentResponseDTO toResponse(Student s) {
        return new StudentResponseDTO(s.getId(), s.getFirstName(), s.getLastName(), s.getEmail(), s.getBirthDate());
    }

    public static void updateModel(Student s, StudentDTO dto) {
        s.setFirstName(dto.getFirstName());
        s.setLastName(dto.getLastName());
        s.setEmail(dto.getEmail());
        s.setBirthDate(dto.getBirthDate());
    }
}
