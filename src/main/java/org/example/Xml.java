package org.example;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Xml {
    private String nameFile;
    private ArrayList<Shop> shops;
    public Xml(String nameFile) {
        this.nameFile = nameFile;
    }

    public ArrayList<Shop> getShops() {
        return shops;
    }

    public void readXml() throws FileNotFoundException, XMLStreamException {
        shops = new ArrayList<>();
        Shop shop = null;
        ArrayList<Department> departments = null;
        Department department = null;
        ArrayList<Product> products = null;
        Product product = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader reader = factory.createXMLEventReader(new FileInputStream(nameFile));

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            if (event.isStartElement()) {
                StartElement start = event.asStartElement();
                String nameStart = start.getName().getLocalPart();
                if (nameStart.equals("shop")) {
                    shop = new Shop();
                    departments = new ArrayList<>();
                } else if (nameStart.equals("name")) {
                    event = reader.nextEvent();
                    shop.setName(event.asCharacters().getData());
                } else if (nameStart.equals("department")) {
                    department = new Department();
                    products = new ArrayList<>();
                } else if (nameStart.equals("nameDep")) {
                    event = reader.nextEvent();
                    department.setDepartment(event.asCharacters().getData());
                } else if (nameStart.equals("product")) {
                    product = new Product();
                    Attribute prodAttr = start.getAttributeByName(new QName("type"));
                    product.setProduct(prodAttr.getValue());
                    Attribute priceAttr = start.getAttributeByName(new QName("price"));
                    product.setPrice(Integer.parseInt(priceAttr.getValue()));
                    products.add(product);
                    department.setProducts(products);
                }
            } else if (event.isEndElement()) {
                EndElement end = event.asEndElement();
                if (end.getName().getLocalPart().equals("department")) {
                    departments.add(department);
                    shop.setDepartments(departments);
                } else if (end.getName().getLocalPart().equals("shop")) {
                    shops.add(shop);
                }
            }
        }
    }
}

