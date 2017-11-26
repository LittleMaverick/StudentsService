package studentsService.converters;

import org.springframework.core.convert.converter.Converter;
import studentsService.beans.SpecialityViewModel;
import studentsservice.entities.SpecialityEntity;

public class SpecialityEntityToSpecialityViewModel implements Converter<SpecialityEntity, SpecialityViewModel>{

    @Override
    public SpecialityViewModel convert(SpecialityEntity specialityEntity) {
        SpecialityViewModel specialityViewModel = new SpecialityViewModel();
        specialityViewModel.setId(String.valueOf(specialityEntity.getId()));
        specialityViewModel.setName(specialityEntity.getName());
        specialityViewModel.setFaculty(specialityEntity.getFacultiesByFacultyId().getName());
        return specialityViewModel;
    }
}
