package studentsservice.entities;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "users", schema = "students_service", catalog = "")
public class UserEntity {
    private int id;
    private String role;
    private String username;
    private String password;
    private Collection<HeadOfPracticeEntity> headofpracticesById;
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
    @Column(name = "role", nullable = false, length = 50)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @OneToMany(mappedBy = "usersByUserId")
    public Collection<HeadOfPracticeEntity> getHeadofpracticesById() {
        return headofpracticesById;
    }

    public void setHeadofpracticesById(Collection<HeadOfPracticeEntity> headofpracticesById) {
        this.headofpracticesById = headofpracticesById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<StudentEntity> getStudentsById() {
        return studentsById;
    }

    public void setStudentsById(Collection<StudentEntity> studentsById) {
        this.studentsById = studentsById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (headofpracticesById != null ? !headofpracticesById.equals(that.headofpracticesById) : that.headofpracticesById != null)
            return false;
        return studentsById != null ? studentsById.equals(that.studentsById) : that.studentsById == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (headofpracticesById != null ? headofpracticesById.hashCode() : 0);
        result = 31 * result + (studentsById != null ? studentsById.hashCode() : 0);
        return result;
    }
}
