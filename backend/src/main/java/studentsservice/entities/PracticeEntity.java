package studentsservice.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "practices", schema = "students_service", catalog = "")
public class PracticeEntity {
    private int id;
    private int facultyId;
    private int headOfPracticeId;
    private Date startDate;
    private Date finishDate;
    private String status;
    private String company;
    private int totalQuantity;
    private int availableQuantity;
    private int firstModuleMark;
    private int secondModuleMark;
    private double averageMark;
    private Collection<AppointStudentEntity> appointStudentsById;
    private SpecialityEntity specialitiesBySpecialityId;
    private FacultyEntity facultiesByFacultyId;
    private HeadOfPracticeEntity headofpracticesByHeadOfPracticeId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "faculty_id", nullable = false)
    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    @Basic
    @Column(name = "headOfPractice_id", nullable = false)
    public int getHeadOfPracticeId() {
        return headOfPracticeId;
    }

    public void setHeadOfPracticeId(int headOfPracticeId) {
        this.headOfPracticeId = headOfPracticeId;
    }

    @Basic
    @Column(name = "startDate", nullable = false)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "finishDate", nullable = false)
    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 50)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "company", nullable = false, length = 50)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "totalQuantity", nullable = false)
    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    @Basic
    @Column(name = "availableQuantity", nullable = false)
    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    @Basic
    @Column(name = "firstModuleMark", nullable = false)
    public int getFirstModuleMark() {
        return firstModuleMark;
    }

    public void setFirstModuleMark(int firstModuleMark) {
        this.firstModuleMark = firstModuleMark;
    }

    @Basic
    @Column(name = "secondModuleMark", nullable = false)
    public int getSecondModuleMark() {
        return secondModuleMark;
    }

    public void setSecondModuleMark(int secondModuleMark) {
        this.secondModuleMark = secondModuleMark;
    }

    @Basic
    @Column(name = "averageMark", nullable = false, precision = 0)
    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PracticeEntity that = (PracticeEntity) o;

        if (id != that.id) return false;
        if (facultyId != that.facultyId) return false;
        if (headOfPracticeId != that.headOfPracticeId) return false;
        if (totalQuantity != that.totalQuantity) return false;
        if (availableQuantity != that.availableQuantity) return false;
        if (firstModuleMark != that.firstModuleMark) return false;
        if (secondModuleMark != that.secondModuleMark) return false;
        if (Double.compare(that.averageMark, averageMark) != 0) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (finishDate != null ? !finishDate.equals(that.finishDate) : that.finishDate != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (appointStudentsById != null ? !appointStudentsById.equals(that.appointStudentsById) : that.appointStudentsById != null)
            return false;
        if (specialitiesBySpecialityId != null ? !specialitiesBySpecialityId.equals(that.specialitiesBySpecialityId) : that.specialitiesBySpecialityId != null)
            return false;
        if (facultiesByFacultyId != null ? !facultiesByFacultyId.equals(that.facultiesByFacultyId) : that.facultiesByFacultyId != null)
            return false;
        return headofpracticesByHeadOfPracticeId != null ? headofpracticesByHeadOfPracticeId.equals(that.headofpracticesByHeadOfPracticeId) : that.headofpracticesByHeadOfPracticeId == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + facultyId;
        result = 31 * result + headOfPracticeId;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (finishDate != null ? finishDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + totalQuantity;
        result = 31 * result + availableQuantity;
        result = 31 * result + firstModuleMark;
        result = 31 * result + secondModuleMark;
        temp = Double.doubleToLongBits(averageMark);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (appointStudentsById != null ? appointStudentsById.hashCode() : 0);
        result = 31 * result + (specialitiesBySpecialityId != null ? specialitiesBySpecialityId.hashCode() : 0);
        result = 31 * result + (facultiesByFacultyId != null ? facultiesByFacultyId.hashCode() : 0);
        result = 31 * result + (headofpracticesByHeadOfPracticeId != null ? headofpracticesByHeadOfPracticeId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "practicesByPracticeId")
    public Collection<AppointStudentEntity> getAppointStudentsById() {
        return appointStudentsById;
    }

    public void setAppointStudentsById(Collection<AppointStudentEntity> appointStudentsById) {
        this.appointStudentsById = appointStudentsById;
    }

    @ManyToOne
    @JoinColumn(name = "speciality_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public SpecialityEntity getSpecialitiesBySpecialityId() {
        return specialitiesBySpecialityId;
    }

    public void setSpecialitiesBySpecialityId(SpecialityEntity specialitiesBySpecialityId) {
        this.specialitiesBySpecialityId = specialitiesBySpecialityId;
    }

    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public FacultyEntity getFacultiesByFacultyId() {
        return facultiesByFacultyId;
    }

    public void setFacultiesByFacultyId(FacultyEntity facultiesByFacultyId) {
        this.facultiesByFacultyId = facultiesByFacultyId;
    }

    @ManyToOne
    @JoinColumn(name = "headOfPractice_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public HeadOfPracticeEntity getHeadofpracticesByHeadOfPracticeId() {
        return headofpracticesByHeadOfPracticeId;
    }

    public void setHeadofpracticesByHeadOfPracticeId(HeadOfPracticeEntity headofpracticesByHeadOfPracticeId) {
        this.headofpracticesByHeadOfPracticeId = headofpracticesByHeadOfPracticeId;
    }
}
