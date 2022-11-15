package org.example;

import java.util.ArrayList;

public class Stream {
    private ArrayList<Shop> shops;
    public Stream(){}
    public void setShops(ArrayList<Shop> shops) {
        this.shops = shops;
    }
    public ArrayList<Shop> getShops() {
        return shops;
    }

    public void printNamesShops(){
        shops.stream().map(x->x.getName()).forEach(x -> System.out.println(x));
    }
}
