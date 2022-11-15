package org.example;

import java.util.ArrayList;
import java.util.Comparator;

public class Stream {
    private ArrayList<Shop> shops;
    public Stream(){}
    public void setShops(ArrayList<Shop> shops) {
        this.shops = shops;
    }
    public ArrayList<Shop> getShops() {
        return shops;
    }

    public void print(){
        shops.stream().map(x->x.getName()).forEach(x -> System.out.println(x));
    }

    public void sortDepartments(){
        shops.stream().forEach(x -> x.getDepartments().stream().sorted(Comparator.comparing(Department::getDepartment)).forEach(y -> System.out.println(y.getDepartment())));
    }

    public void sortShops(){
        shops.stream().sorted(Comparator.comparing(Shop::getName)).forEach(x->System.out.println(x.getName()));
    }

    public void filterCountDepartments(int count){
        shops.stream().filter(x -> x.getDepartments().size()==count).forEach(x->System.out.println(x.getName()));
    }
}
