package studentsservice.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "faculties", schema = "students_service", catalog = "")
public class FacultyEntity {
    private int id;
    private String name;
    private Collection<PracticeEntity> practicesById;
    private Collection<SpecialityEntity> specialitiesById;

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


    @OneToMany(mappedBy = "facultiesByFacultyId")
    public Collection<PracticeEntity> getPracticesById() {
        return practicesById;
    }

    public void setPracticesById(Collection<PracticeEntity> practicesById) {
        this.practicesById = practicesById;
    }

    @OneToMany(mappedBy = "facultiesByFacultyId")
    public Collection<SpecialityEntity> getSpecialitiesById() {
        return specialitiesById;
    }

    public void setSpecialitiesById(Collection<SpecialityEntity> specialitiesById) {
        this.specialitiesById = specialitiesById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FacultyEntity that = (FacultyEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (practicesById != null ? !practicesById.equals(that.practicesById) : that.practicesById != null)
            return false;
        return specialitiesById != null ? specialitiesById.equals(that.specialitiesById) : that.specialitiesById == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (practicesById != null ? practicesById.hashCode() : 0);
        result = 31 * result + (specialitiesById != null ? specialitiesById.hashCode() : 0);
        return result;
    }
}
