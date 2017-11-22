package studentsservice.service.Impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studentsservice.entities.HeadOfPracticeEntity;
import studentsservice.repository.HeadOfPracticeRepository;
import studentsservice.service.HeadOfPracticeService;

import java.util.List;

@Service("jpaHeadOfPracticeService")
@Transactional
public class HeadOfPracticeServiceImpl implements HeadOfPracticeService {

    @Autowired
    private  HeadOfPracticeRepository headOfPracticeRepository;

    @Override
    public HeadOfPracticeEntity save(HeadOfPracticeEntity entity) {
        return headOfPracticeRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        headOfPracticeRepository.delete(id);
    }

    @Override
    public List<HeadOfPracticeEntity> findAll() {
        return Lists.newArrayList(headOfPracticeRepository.findAll());
    }

    @Override
    public HeadOfPracticeEntity findById(int id) {
        return headOfPracticeRepository.findOne(id);
    }

    @Override
    public HeadOfPracticeEntity findByUserId(int user_id) {
        return headOfPracticeRepository.findByUserId(user_id);
    }

    @Override
    public HeadOfPracticeEntity findByName(String name) {
        return headOfPracticeRepository.findByName(name);
    }
}
