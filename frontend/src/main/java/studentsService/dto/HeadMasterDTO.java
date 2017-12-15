package studentsService.dto;


public class HeadMasterDTO {
    private String role;
    private String username;
    private String password;
    private String name;

    public HeadMasterDTO() {
    }

    public HeadMasterDTO(String role, String username, String password, String name) {
        this.role = role;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
