package studentsservice.service.Impl;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studentsservice.entities.AppointStudentEntity;
import studentsservice.repository.AppointStudentRepository;
import studentsservice.service.AppointStudentService;

import java.util.List;

@Service
@Transactional
public class AppointStudentServiceImpl implements AppointStudentService{

    @Autowired
    private AppointStudentRepository appointStudentRepository;

    @Override
    public AppointStudentEntity save(AppointStudentEntity entity) {
        return appointStudentRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        appointStudentRepository.delete(id);
    }

    @Override
    public List<AppointStudentEntity> findAll() {
        return Lists.newArrayList(appointStudentRepository.findAll());
    }

    @Override
    public AppointStudentEntity findById(int id) {
        return appointStudentRepository.findOne(id);
    }

    @Override
    public List<AppointStudentEntity> findByStudentId(int studentId) {
        return appointStudentRepository.findByStudentId(studentId);
    }

    @Override
    public List<AppointStudentEntity> findByPracticeId(int practiceId) {
        return appointStudentRepository.findByPracticeId(practiceId);
    }
}
