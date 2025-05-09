package cz.uhk.kpro2.service;

import cz.uhk.kpro2.model.Lecturer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LecturerService {
    List<Lecturer> getAllLecturers();
    Lecturer getLecturer(long id);
    void saveLecturer(Lecturer lecturer);
    void deleteLecturer(long id);
}
