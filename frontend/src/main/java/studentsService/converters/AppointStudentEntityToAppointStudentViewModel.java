package studentsService.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import studentsService.beans.AppointStudentViewModel;
import studentsService.beans.PracticeViewModel;
import studentsService.beans.StudentViewModel;
import studentsservice.entities.AppointStudentEntity;

public class AppointStudentEntityToAppointStudentViewModel implements Converter<AppointStudentEntity, AppointStudentViewModel>{

    @Autowired
    private ConversionService conversionService;

    @Override
    public AppointStudentViewModel convert(AppointStudentEntity appointStudentEntity) {
        AppointStudentViewModel appointStudentViewModel = new AppointStudentViewModel();
        appointStudentViewModel.setId(String.valueOf(appointStudentEntity.getId()));
        appointStudentViewModel.setStudentViewModel(conversionService.convert(appointStudentEntity.getStudentsByStudentId(), StudentViewModel.class));
        appointStudentViewModel.setPracticeViewModel(conversionService.convert(appointStudentEntity.getPracticesByPracticeId(), PracticeViewModel.class));
        return appointStudentViewModel;
    }
}
