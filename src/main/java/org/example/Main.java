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
        // stream.sortDepartment();
        stream.sortShops();
    }
}