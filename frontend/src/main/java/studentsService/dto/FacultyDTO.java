package studentsService.dto;

public class FacultyDTO {

    private String name;

    public FacultyDTO() {
    }

    public FacultyDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
