package studentsservice.entities;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "practices", schema = "students_service", catalog = "")
public class PracticeEntity {
    private int id;
    private Date startDate;
    private Date finishDate;
    private String company;
    private String status;
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
    @Column(name = "company", nullable = false, length = 50)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 50)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PracticeEntity that = (PracticeEntity) o;

        if (id != that.id) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (finishDate != null ? !finishDate.equals(that.finishDate) : that.finishDate != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (specialitiesBySpecialityId != null ? !specialitiesBySpecialityId.equals(that.specialitiesBySpecialityId) : that.specialitiesBySpecialityId != null)
            return false;
        if (facultiesByFacultyId != null ? !facultiesByFacultyId.equals(that.facultiesByFacultyId) : that.facultiesByFacultyId != null)
            return false;
        return headofpracticesByHeadOfPracticeId != null ? headofpracticesByHeadOfPracticeId.equals(that.headofpracticesByHeadOfPracticeId) : that.headofpracticesByHeadOfPracticeId == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (finishDate != null ? finishDate.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (specialitiesBySpecialityId != null ? specialitiesBySpecialityId.hashCode() : 0);
        result = 31 * result + (facultiesByFacultyId != null ? facultiesByFacultyId.hashCode() : 0);
        result = 31 * result + (headofpracticesByHeadOfPracticeId != null ? headofpracticesByHeadOfPracticeId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "speciality_id", referencedColumnName = "id", nullable = false)
    public SpecialityEntity getSpecialitiesBySpecialityId() {
        return specialitiesBySpecialityId;
    }

    public void setSpecialitiesBySpecialityId(SpecialityEntity specialitiesBySpecialityId) {
        this.specialitiesBySpecialityId = specialitiesBySpecialityId;
    }

    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "id", nullable = false)
    public FacultyEntity getFacultiesByFacultyId() {
        return facultiesByFacultyId;
    }

    public void setFacultiesByFacultyId(FacultyEntity facultiesByFacultyId) {
        this.facultiesByFacultyId = facultiesByFacultyId;
    }

    @ManyToOne
    @JoinColumn(name = "headOfPractice_id", referencedColumnName = "id", nullable = false)
    public HeadOfPracticeEntity getHeadofpracticesByHeadOfPracticeId() {
        return headofpracticesByHeadOfPracticeId;
    }

    public void setHeadofpracticesByHeadOfPracticeId(HeadOfPracticeEntity headofpracticesByHeadOfPracticeId) {
        this.headofpracticesByHeadOfPracticeId = headofpracticesByHeadOfPracticeId;
    }
}
