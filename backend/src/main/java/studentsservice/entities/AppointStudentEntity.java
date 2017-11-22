package studentsservice.entities;

import javax.persistence.*;

/**
 * Created by littleF on 20.11.2017.
 */
@Entity
@Table(name = "appoint_students", schema = "students_service", catalog = "")
public class AppointStudentEntity {
    private int id;
    private StudentEntity studentsByStudentId;
    private PracticeEntity practicesByPracticeId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppointStudentEntity that = (AppointStudentEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    public StudentEntity getStudentsByStudentId() {
        return studentsByStudentId;
    }

    public void setStudentsByStudentId(StudentEntity studentsByStudentId) {
        this.studentsByStudentId = studentsByStudentId;
    }

    @ManyToOne
    @JoinColumn(name = "practice_id", referencedColumnName = "id", nullable = false)
    public PracticeEntity getPracticesByPracticeId() {
        return practicesByPracticeId;
    }

    public void setPracticesByPracticeId(PracticeEntity practicesByPracticeId) {
        this.practicesByPracticeId = practicesByPracticeId;
    }
}
