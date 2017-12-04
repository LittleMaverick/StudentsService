package studentsService.converters;

import org.springframework.core.convert.converter.Converter;
import studentsService.beans.PracticeViewModel;
import studentsservice.entities.PracticeEntity;

public class PracticeEntityToPracticeViewModel implements Converter<PracticeEntity, PracticeViewModel> {

    @Override
    public PracticeViewModel convert(PracticeEntity practiceEntity) {
        PracticeViewModel practiceViewModel = new PracticeViewModel();
        practiceViewModel.setId(String.valueOf(practiceEntity.getId()));
        practiceViewModel.setCompany(practiceEntity.getCompany());
        practiceViewModel.setHeadOfPractice(practiceEntity.getHeadofpracticesByHeadOfPracticeId().getName());
        practiceViewModel.setStartDate(String.valueOf(practiceEntity.getStartDate()));
        practiceViewModel.setFinishDate(String.valueOf(practiceEntity.getFinishDate()));
        practiceViewModel.setStatus(practiceEntity.getStatus());
        practiceViewModel.setFirstModuleMark(String.valueOf(practiceEntity.getFirstModuleMark()));
        practiceViewModel.setSecondModuleMark(String.valueOf(practiceEntity.getSecondModuleMark()));
        practiceViewModel.setAverageMark(String.valueOf(practiceEntity.getAverageMark()));
        practiceViewModel.setTotalQuantity(String.valueOf(practiceEntity.getTotalQuantity()));
        practiceViewModel.setAvailableQuantity(String.valueOf(practiceEntity.getAvailableQuantity()));

        practiceViewModel.setFaculty(practiceEntity.getFacultiesByFacultyId().getName());
        practiceViewModel.setSpeciality(practiceEntity.getSpecialitiesBySpecialityId().getName());


        return practiceViewModel;
    }
}
