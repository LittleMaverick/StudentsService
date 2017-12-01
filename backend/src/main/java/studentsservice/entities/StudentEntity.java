package studentsservice.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "students", schema = "students_service", catalog = "")
public class StudentEntity {
    private int id;
    private int groupNumber;
    private String firstname;
    private String lastname;
    private String email;
    private String status;
    private SpecialityEntity specialitiesBySpecialityId;
    private int specialityId;
    private Collection<AppointStudentEntity> appointStudentsById;
    private Collection<UserEntity> usersById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "groupNumber", nullable = false)
    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Basic
    @Column(name = "firstname", nullable = false, length = 50)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = false, length = 50)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 50)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @ManyToOne
    @JoinColumn(name = "speciality_id", referencedColumnName = "id", nullable = false)
    public SpecialityEntity getSpecialitiesBySpecialityId() {
        return specialitiesBySpecialityId;
    }

    public void setSpecialitiesBySpecialityId(SpecialityEntity specialitiesBySpecialityId) {
        this.specialitiesBySpecialityId = specialitiesBySpecialityId;
    }

    @Basic
    @Column(name = "speciality_id", nullable = false, insertable = false, updatable = false)
    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    @OneToMany(mappedBy = "studentsByStudentId", fetch = FetchType.EAGER)
    public Collection<AppointStudentEntity> getAppointStudentsById() {
        return appointStudentsById;
    }

    public void setAppointStudentsById(Collection<AppointStudentEntity> appointStudentsById) {
        this.appointStudentsById = appointStudentsById;
    }

    @OneToMany(mappedBy = "studentsByStudentId")
    public Collection<UserEntity> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<UserEntity> usersById) {
        this.usersById = usersById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (id != that.id) return false;
        if (groupNumber != that.groupNumber) return false;
        if (specialityId != that.specialityId) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (specialitiesBySpecialityId != null ? !specialitiesBySpecialityId.equals(that.specialitiesBySpecialityId) : that.specialitiesBySpecialityId != null)
            return false;
        if (appointStudentsById != null ? !appointStudentsById.equals(that.appointStudentsById) : that.appointStudentsById != null)
            return false;
        return usersById != null ? usersById.equals(that.usersById) : that.usersById == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + groupNumber;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (specialitiesBySpecialityId != null ? specialitiesBySpecialityId.hashCode() : 0);
        result = 31 * result + specialityId;
        result = 31 * result + (appointStudentsById != null ? appointStudentsById.hashCode() : 0);
        result = 31 * result + (usersById != null ? usersById.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", groupNumber=" + groupNumber +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", specialitiesBySpecialityId=" + specialitiesBySpecialityId +
                ", specialityId=" + specialityId +
                ", appointStudentsById=" + appointStudentsById +
                ", usersById=" + usersById +
                '}';
    }
}
