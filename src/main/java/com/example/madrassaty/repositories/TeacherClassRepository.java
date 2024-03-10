package com.example.madrassaty.repositories;

import com.example.madrassaty.models.TeacherClass;
import com.example.madrassaty.models.embeddables.TeacherClassId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherClassRepository extends JpaRepository<TeacherClass, TeacherClassId> {}
