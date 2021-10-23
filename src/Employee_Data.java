public class Employee_Data {
    private int employee_id;
    private String Name;
    private String Username;
    private String Password;
    private String Role;

    public Employee_Data(int employee_id, String name, String username, String password, String role) {
        this.employee_id = employee_id;
        Name = name;
        Username = username;
        Password = password;
        Role = role;
    }

    public Employee_Data() {
        this.employee_id = 0;
        this.Name = "";
        this.Username = "";
        this.Password = "";
        this.Role= "admin";
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}
