package studentsService.dto;


import java.util.List;

public class AppointStudentsDTO {

    private String practiceId;
    private List<String> studentIDs;

    public AppointStudentsDTO() {
    }

    public AppointStudentsDTO(String practiceId, List<String> studentIDs) {
        this.practiceId = practiceId;
        this.studentIDs = studentIDs;
    }

    public String getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(String practiceId) {
        this.practiceId = practiceId;
    }

    public List<String> getStudentIDs() {
        return studentIDs;
    }

    public void setStudentIDs(List<String> studentIDs) {
        this.studentIDs = studentIDs;
    }
}
