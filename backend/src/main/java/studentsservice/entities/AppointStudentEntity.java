package studentsservice.entities;

import javax.persistence.*;

@Entity
@Table(name = "appoint_students", schema = "students_service", catalog = "")
public class AppointStudentEntity {
    private int id;
    private int studentId;
    private int practiceId;
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

    @Basic
    @Column(name = "student_id", nullable = false, insertable = false, updatable = false)
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "practice_id", nullable = false, insertable = false, updatable = false)
    public int getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(int practiceId) {
        this.practiceId = practiceId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppointStudentEntity that = (AppointStudentEntity) o;

        if (id != that.id) return false;
        if (studentId != that.studentId) return false;
        if (practiceId != that.practiceId) return false;
        if (studentsByStudentId != null ? !studentsByStudentId.equals(that.studentsByStudentId) : that.studentsByStudentId != null)
            return false;
        return practicesByPracticeId != null ? practicesByPracticeId.equals(that.practicesByPracticeId) : that.practicesByPracticeId == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + studentId;
        result = 31 * result + practiceId;
        result = 31 * result + (studentsByStudentId != null ? studentsByStudentId.hashCode() : 0);
        result = 31 * result + (practicesByPracticeId != null ? practicesByPracticeId.hashCode() : 0);
        return result;
    }
}
