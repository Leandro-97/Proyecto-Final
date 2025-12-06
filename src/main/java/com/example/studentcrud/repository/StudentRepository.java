package com.example.studentcrud.repository;

import com.example.studentcrud.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class StudentRepository {
    private final Map<Long, Student> storage = new LinkedHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Student save(Student s) {
        if (s.getId() == null) s.setId(idGenerator.getAndIncrement());
        storage.put(s.getId(), s);
        return s;
    }

    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Student> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }

    public void clear() {
        storage.clear();
    }
}
