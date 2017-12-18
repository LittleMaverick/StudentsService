package studentsService.dto;

public class SpecialityDTO {

    public String name;
    public String facultyId;

    public SpecialityDTO() {
    }

    public SpecialityDTO(String name, String facultyId) {
        this.name = name;
        this.facultyId = facultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }
}
