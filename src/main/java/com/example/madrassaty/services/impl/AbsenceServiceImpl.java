package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.AbsenceDTO;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Absence;
import com.example.madrassaty.models.Student;
import com.example.madrassaty.repositories.AbsenceRepository;
import com.example.madrassaty.repositories.StudentRepository;
import com.example.madrassaty.services.AbsenceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AbsenceServiceImpl implements AbsenceService {

    private AbsenceRepository absenceRepository;
    private StudentRepository studentRepository;
    private ModelMapper modelMapper;

    @Override
    public Absence save(AbsenceDTO absenceDTO) throws NotFoundException {

        Absence absence = modelMapper.map(absenceDTO, Absence.class);
        if(studentRepository.findById(absenceDTO.getStudentId()).isPresent()) {
            Student student = studentRepository.findById(absenceDTO.getStudentId()).get();
            absence.setStudent(student);
            return absenceRepository.save(absence);
        }
        throw new NotFoundException("No student found");
    }

    @Override
    public Absence update(AbsenceDTO absenceDTO) throws NotFoundException {

        Absence absence = modelMapper.map(absenceDTO, Absence.class);
        if(absenceRepository.findById(absenceDTO.getId()).isPresent()) {
            if(studentRepository.findById(absenceDTO.getStudentId()).isPresent()) {
                Student student = studentRepository.findById(absenceDTO.getStudentId()).get();
                absence.setStudent(student);
                return absenceRepository.save(absence);
            }
            throw new NotFoundException("No student found");
        }
        throw new NotFoundException("No absence found");
    }

    @Override
    public void delete(long id) throws NotFoundException {
        if(absenceRepository.findById(id).isPresent()) {
            absenceRepository.deleteById(id);
        }
        throw new NotFoundException("No absence found");
    }

    @Override
    public Absence findById(long id) throws NotFoundException {
        if(absenceRepository.findById(id).isPresent()) {
            return absenceRepository.findById(id).get();
        }
        throw new NotFoundException("No absence found");
    }
}
