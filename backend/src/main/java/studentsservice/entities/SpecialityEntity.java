package studentsservice.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "specialities", schema = "students_service", catalog = "")
public class SpecialityEntity {
    private int id;
    private String name;
    private int facultyId;
    private Collection<PracticeEntity> practicesById;
    private FacultyEntity facultiesByFacultyId;
    private Collection<StudentEntity> studentsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "faculty_id", nullable = false, insertable = false, updatable = false)
    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecialityEntity that = (SpecialityEntity) o;

        if (id != that.id) return false;
        if (facultyId != that.facultyId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + facultyId;
        return result;
    }

    @OneToMany(mappedBy = "specialitiesBySpecialityId")
    public Collection<PracticeEntity> getPracticesById() {
        return practicesById;
    }

    public void setPracticesById(Collection<PracticeEntity> practicesById) {
        this.practicesById = practicesById;
    }

    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "id", nullable = false)
    public FacultyEntity getFacultiesByFacultyId() {
        return facultiesByFacultyId;
    }

    public void setFacultiesByFacultyId(FacultyEntity facultiesByFacultyId) {
        this.facultiesByFacultyId = facultiesByFacultyId;
    }

    @OneToMany(mappedBy = "specialitiesBySpecialityId")
    public Collection<StudentEntity> getStudentsById() {
        return studentsById;
    }

    public void setStudentsById(Collection<StudentEntity> studentsById) {
        this.studentsById = studentsById;
    }
}
