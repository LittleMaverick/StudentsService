package studentsservice.repository;

import org.springframework.data.repository.CrudRepository;
import studentsservice.entities.PracticeEntity;

import java.util.List;


public interface PracticeRepository extends CrudRepository<PracticeEntity, Integer> {

    List<PracticeEntity> findByHeadOfPracticeId(int headOfPractice_id);
    List<PracticeEntity> findByStatus(String status);
    PracticeEntity findByCompany(String company);
}
