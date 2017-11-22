package studentsservice.repository;

import org.springframework.data.repository.CrudRepository;
import studentsservice.entities.HeadOfPracticeEntity;


public interface HeadOfPracticeRepository extends CrudRepository<HeadOfPracticeEntity, Integer> {

    HeadOfPracticeEntity findByUserId(int user_id);
    HeadOfPracticeEntity findByName(String name);
}
