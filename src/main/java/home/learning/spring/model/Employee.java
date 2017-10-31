package home.learning.spring.model;

import home.learning.spring.Loggable;

/**
 * home.learning.spring
 * Created by vorsicht on 31/10/17.
 */
public class Employee {
    private String name;

    public String getName() {
        return name;
    }

    @Loggable
    public void setName(String name) {
        this.name = name;
    }

    public void throwException() {
        throw new RuntimeException();
    }

}
