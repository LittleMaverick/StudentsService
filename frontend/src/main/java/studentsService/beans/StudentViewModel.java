package studentsService.beans;

public class StudentViewModel {

    private String id;
    private String groupNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String status;
    private UserViewModel userViewModel;
    private SpecialityViewModel speciality;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserViewModel getUserViewModel() {
        return userViewModel;
    }

    public void setUserViewModel(UserViewModel userViewModel) {
        this.userViewModel = userViewModel;
    }

    public SpecialityViewModel getSpeciality() {
        return speciality;
    }

    public void setSpeciality(SpecialityViewModel speciality) {
        this.speciality = speciality;
    }
}
