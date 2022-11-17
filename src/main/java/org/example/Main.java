package org.example;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        Xml xml = new Xml("src\\shops.xml");
        xml.readXml();
        Stream stream = new Stream();
        stream.setShops(xml.getShops());
        // stream.printShops();
        //List<Shop> shops = stream.sortShops();

        // stream.sortDepartments();
        //stream.filterCountDepartments(2);
        //stream.filterNameShops("Магазин1");
    }
}