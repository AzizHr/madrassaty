package com.example.madrassaty.repositories;

import com.example.madrassaty.models.SpecialtySubject;
import com.example.madrassaty.models.embeddables.SpecialtySubjectId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtySubjectRepository extends JpaRepository<SpecialtySubject, SpecialtySubjectId> {}
