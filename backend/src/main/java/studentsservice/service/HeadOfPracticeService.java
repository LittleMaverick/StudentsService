package studentsservice.service;


import studentsservice.entities.HeadOfPracticeEntity;

import java.util.List;

public interface HeadOfPracticeService {

    HeadOfPracticeEntity save( HeadOfPracticeEntity entity);
    void delete(int id);

    List< HeadOfPracticeEntity> findAll();
    HeadOfPracticeEntity findById(int id);
    HeadOfPracticeEntity findByUserId(int user_id);
    HeadOfPracticeEntity findByName(String name);

}
