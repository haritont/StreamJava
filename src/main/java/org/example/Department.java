package org.example;

import java.util.ArrayList;

public class Department {
    public String department;
    public ArrayList<Product> products;
    public void setDepartment(String department){
        this.department = department;
    }
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    public String getDepartment() {
        return department;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
}
