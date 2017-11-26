package studentsService.converters;

import org.springframework.core.convert.converter.Converter;
import studentsService.beans.HeadOfPracticeViewModel;
import studentsservice.entities.HeadOfPracticeEntity;

public class HeadOfPracticeEntityToHeadOfPracticeViewModel implements Converter<HeadOfPracticeEntity, HeadOfPracticeViewModel>{

    @Override
    public HeadOfPracticeViewModel convert(HeadOfPracticeEntity headOfPracticeEntity) {
        HeadOfPracticeViewModel headOfPracticeViewModel = new HeadOfPracticeViewModel();
        headOfPracticeViewModel.setId(String.valueOf(headOfPracticeEntity.getId()));
        headOfPracticeViewModel.setName(headOfPracticeEntity.getName());
        return headOfPracticeViewModel;
    }
}
