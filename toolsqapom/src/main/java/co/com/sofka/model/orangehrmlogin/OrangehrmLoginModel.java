package co.com.sofka.model.orangehrmlogin;

import co.com.sofka.util.EmployeeName;

public class OrangehrmLoginModel {
    private String user;
    private String password;
    private EmployeeName employeeName;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmployeeName getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(EmployeeName employeeName) {
        this.employeeName = employeeName;
    }
}


