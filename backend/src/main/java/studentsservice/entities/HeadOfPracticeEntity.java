package studentsservice.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "headofpractices", schema = "students_service", catalog = "")
public class HeadOfPracticeEntity {
    private int id;
    private String name;
    private int userId;
    private UserEntity usersByUserId;
    private Collection<PracticeEntity> practicesById;

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
    @Column(name = "user_id", nullable = false, insertable = false, updatable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UserEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @OneToMany(mappedBy = "headofpracticesByHeadOfPracticeId")
    public Collection<PracticeEntity> getPracticesById() {
        return practicesById;
    }

    public void setPracticesById(Collection<PracticeEntity> practicesById) {
        this.practicesById = practicesById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeadOfPracticeEntity that = (HeadOfPracticeEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (usersByUserId != null ? !usersByUserId.equals(that.usersByUserId) : that.usersByUserId != null)
            return false;
        return practicesById != null ? practicesById.equals(that.practicesById) : that.practicesById == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (usersByUserId != null ? usersByUserId.hashCode() : 0);
        result = 31 * result + (practicesById != null ? practicesById.hashCode() : 0);
        return result;
    }
}
