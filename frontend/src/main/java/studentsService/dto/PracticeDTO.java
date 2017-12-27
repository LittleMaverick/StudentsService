package studentsService.dto;


public class PracticeDTO {

    private String headOfPracticeId;
    private String company;
    private String startDate;
    private String finishDate;
    private String facultyId;
    private String specialityId;
    private String averageMark;
    private String totalQuantity;

    public PracticeDTO() {
    }

    public PracticeDTO(String headOfPracticeId, String company, String startDate, String finishDate, String facultyId, String specialityId, String averageMark, String totalQuantity) {
        this.headOfPracticeId = headOfPracticeId;
        this.company = company;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.facultyId = facultyId;
        this.specialityId = specialityId;
        this.averageMark = averageMark;
        this.totalQuantity = totalQuantity;
    }

    public String getHeadOfPracticeId() {
        return headOfPracticeId;
    }

    public void setHeadOfPracticeId(String headOfPracticeId) {
        this.headOfPracticeId = headOfPracticeId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(String specialityId) {
        this.specialityId = specialityId;
    }

    public String getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(String averageMark) {
        this.averageMark = averageMark;
    }

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
