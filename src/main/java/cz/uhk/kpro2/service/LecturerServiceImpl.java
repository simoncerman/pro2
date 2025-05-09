package cz.uhk.kpro2.service;

import cz.uhk.kpro2.model.Lecturer;
import cz.uhk.kpro2.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LecturerServiceImpl implements LecturerService {

    private final LecturerRepository lecturerRepository;

    @Autowired
    public LecturerServiceImpl(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    @Override
    public List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    @Override
    public Lecturer getLecturer(long id) {
        Optional<Lecturer> lecturer = lecturerRepository.findById(id);
        return lecturer.orElse(null);
    }

    @Override
    public void saveLecturer(Lecturer lecturer) {
        lecturerRepository.save(lecturer);
    }

    @Override
    public void deleteLecturer(long id) {
        lecturerRepository.deleteById(id);
    }
}
