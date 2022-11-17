package org.example;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
       Xml xml = new Xml("src\\shops.xml");
       xml.readXml();
       Stream stream = new Stream();
       stream.setShops(xml.getShops());
       //stream.print();
        // stream.sortDepartments();
        //stream.sortShops();
       // stream.filterCountDepartments(2);
        stream.filterNameShops("Магазин1");
    }
}