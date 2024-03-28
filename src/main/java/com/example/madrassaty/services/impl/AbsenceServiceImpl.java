package com.example.madrassaty.services.impl;

import com.example.madrassaty.dtos.request.AbsenceDTO;
import com.example.madrassaty.dtos.response.AbsenceResponse;
import com.example.madrassaty.exceptions.NotFoundException;
import com.example.madrassaty.models.Absence;
import com.example.madrassaty.models.Student;
import com.example.madrassaty.repositories.AbsenceRepository;
import com.example.madrassaty.repositories.StudentRepository;
import com.example.madrassaty.services.AbsenceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AbsenceServiceImpl implements AbsenceService {

    private AbsenceRepository absenceRepository;
    private StudentRepository studentRepository;
    private ModelMapper modelMapper;

    @Override
    public AbsenceResponse save(AbsenceDTO absenceDTO) throws NotFoundException {

        Absence absence = modelMapper.map(absenceDTO, Absence.class);
        if(studentRepository.findById(absenceDTO.getStudentId()).isPresent()) {
            Student student = studentRepository.findById(absenceDTO.getStudentId()).get();
            absence.setDate(LocalDate.now());
            absence.setStudent(student);
            return modelMapper.map(absenceRepository.save(absence), AbsenceResponse.class);
        }
        throw new NotFoundException("No student found");
    }

    @Override
    public AbsenceResponse update(AbsenceDTO absenceDTO) throws NotFoundException {

        Absence absence = modelMapper.map(absenceDTO, Absence.class);
        if(absenceRepository.findById(absenceDTO.getId()).isPresent()) {
            if(studentRepository.findById(absenceDTO.getStudentId()).isPresent()) {
                Student student = studentRepository.findById(absenceDTO.getStudentId()).get();
                absence.setStudent(student);
                return modelMapper.map(absenceRepository.save(absence), AbsenceResponse.class);
            }
            throw new NotFoundException("No student found");
        }
        throw new NotFoundException("No absence found");
    }

    @Override
    public void delete(UUID id) throws NotFoundException {
        if(absenceRepository.findById(id).isPresent()) {
            absenceRepository.deleteById(id);
        }
        throw new NotFoundException("No absence found");
    }

    @Override
    public AbsenceResponse findById(UUID id) throws NotFoundException {
        if(absenceRepository.findById(id).isPresent()) {
            return modelMapper.map(absenceRepository.findById(id).get(), AbsenceResponse.class);
        }
        throw new NotFoundException("No absence found");
    }

    @Override
    public List<AbsenceResponse> findAllByStudentId(UUID studentId) {
        List<Absence> absences = absenceRepository.findAllByStudentId(studentId);
        return absences.stream()
                .map(absence -> modelMapper.map(absence, AbsenceResponse.class))
                .collect(Collectors.toList());
    }
}
