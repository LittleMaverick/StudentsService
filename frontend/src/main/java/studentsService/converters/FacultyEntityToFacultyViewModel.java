package studentsService.converters;

import org.springframework.core.convert.converter.Converter;
import studentsService.beans.FacultyViewModel;
import studentsservice.entities.FacultyEntity;

public class FacultyEntityToFacultyViewModel implements Converter<FacultyEntity, FacultyViewModel>{

    @Override
    public FacultyViewModel convert(FacultyEntity facultyEntity) {
        FacultyViewModel facultyViewModel = new FacultyViewModel();
        facultyViewModel.setId(String.valueOf(facultyEntity.getId()));
        facultyViewModel.setName(facultyEntity.getName());
        return facultyViewModel;
    }
}
