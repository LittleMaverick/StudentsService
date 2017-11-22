package studentsservice.service.Impl;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studentsservice.entities.FacultyEntity;
import studentsservice.repository.FacultyRepository;
import studentsservice.service.FacultyService;

import java.util.List;

@Service("jpaFacultyService")
@Transactional
public class FacultyServiceImpl implements FacultyService{

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public FacultyEntity save(FacultyEntity entity) {
        return facultyRepository.save(entity);
    }

    @Override
    public List<FacultyEntity> findAll() {
        return Lists.newArrayList(facultyRepository.findAll());
    }

    @Override
    public FacultyEntity findById(int id) {
        return facultyRepository.findOne(id);
    }

    @Override
    public FacultyEntity findByName(String name) {
        return facultyRepository.findByName(name);
    }
}
