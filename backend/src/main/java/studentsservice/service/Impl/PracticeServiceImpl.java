package studentsservice.service.Impl;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import studentsservice.entities.PracticeEntity;
import studentsservice.repository.PracticeRepository;
import studentsservice.service.PracticeService;

import java.util.List;

@Service("jpaPracticeService")
@Transactional
public class PracticeServiceImpl implements PracticeService{

    @Autowired
    private PracticeRepository practiceRepository;

    @Override
    public PracticeEntity save(PracticeEntity entity) {
        return practiceRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        practiceRepository.delete(id);
    }

    @Override
    public List<PracticeEntity> findAll() {
        return Lists.newArrayList(practiceRepository.findAll());
    }

    @Override
    public List<PracticeEntity> findByHeadOfPracticeId(int headOfPractice_id) {
        return practiceRepository.findByHeadOfPracticeId(headOfPractice_id);
    }

    @Override
    public List<PracticeEntity> findByStatus(String status) {
        return practiceRepository.findByStatus(status);
    }

    @Override
    public PracticeEntity findById(int id) {
        return practiceRepository.findOne(id);
    }

    @Override
    public PracticeEntity findByCompany(String company) {
        return practiceRepository.findByCompany(company);
    }
}
