package org.example;

import java.util.ArrayList;

public class Shop {
    public String name;
    public ArrayList<Department> departments;
    public void setName(String name){
        this.name = name;
    }
    public void setDepartments(ArrayList<Department> departments){
        this.departments = departments;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Department> getDepartments() {
        return departments;
    }
}
