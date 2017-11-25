package studentsservice.service;


import studentsservice.entities.PracticeEntity;

import java.util.List;

public interface PracticeService {

    PracticeEntity save(PracticeEntity entity);
    void delete(int id);

    List<PracticeEntity> findAll();
    List<PracticeEntity> findByHeadOfPracticeId(int headOfPractice_id);
    List<PracticeEntity> findByStatus(String status);
    PracticeEntity findById(int id);
    PracticeEntity findByCompany(String company);

}
