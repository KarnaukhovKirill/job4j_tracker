package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public Map<String, Student> getMap(List<Student> studentList) {
        return studentList.stream()
                .distinct()
                .collect(Collectors.toMap(
                        student -> student.getSurname(),
                        student -> student
                ));
    }
}
