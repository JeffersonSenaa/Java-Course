package entities;

public class Employee {
    private String name;
    private String email;
    private float salary;
    public Employee(String name, String email, float salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public float getSalary() {
        return salary;
    }
}
