package home.learning.spring.bean;

public class Employee {
    private String name;

    public Employee() {
        System.out.println("Employee constructor called");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
