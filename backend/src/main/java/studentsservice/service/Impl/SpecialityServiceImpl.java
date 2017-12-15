package studentsservice.service.Impl;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import studentsservice.entities.SpecialityEntity;
import studentsservice.repository.SpecialityRepository;
import studentsservice.service.SpecialityService;

import java.util.List;

@Service("jpaSpecialityService")
@Transactional
public class SpecialityServiceImpl implements SpecialityService{

    @Autowired
    private SpecialityRepository specialityRepository;


    public SpecialityEntity save(SpecialityEntity entity) {
        return specialityRepository.save(entity);
    }


    public List<SpecialityEntity> findAll() {
        return Lists.newArrayList(specialityRepository.findAll());
    }


    public SpecialityEntity findById(int id) {
        return specialityRepository.findOne(id);
    }


    public List<SpecialityEntity> findSpecialitiesByFacultyId(int faculty_id) {

        return specialityRepository.findSpecialitiesByFacultyId(faculty_id);
    }


    public SpecialityEntity findByName(String name) {
        return specialityRepository.findByName(name);
    }
}
