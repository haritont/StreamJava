package org.example;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

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

@RequiredArgsConstructor
@Getter
public class Xml {
    final String nameFile;
    private ArrayList<Shop> shops;

    public void readXml() throws FileNotFoundException, XMLStreamException {
        shops = new ArrayList<>();
        Shop shop = null;
        ArrayList<Department> departments = null;
        Department department = null;
        ArrayList<Product> products = null;
        Product product;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader reader = factory.createXMLEventReader(new FileInputStream(nameFile));

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            if (event.isStartElement()) {
                StartElement start = event.asStartElement();
                String nameStart = start.getName().getLocalPart();
                switch (nameStart) {
                    case "shop" -> {
                        shop = new Shop();
                        departments = new ArrayList<>();
                    }
                    case "name" -> {
                        event = reader.nextEvent();
                        assert shop != null;
                        shop.setName(event.asCharacters().getData());
                    }
                    case "department" -> {
                        department = new Department();
                        products = new ArrayList<>();
                    }
                    case "nameDep" -> {
                        event = reader.nextEvent();
                        assert department != null;
                        department.setName(event.asCharacters().getData());
                    }
                    case "product" -> {
                        product = new Product();
                        Attribute prodAttr = start.getAttributeByName(new QName("type"));
                        product.setName(prodAttr.getValue());
                        Attribute priceAttr = start.getAttributeByName(new QName("price"));
                        product.setPrice(priceAttr.getValue());
                        assert products != null;
                        products.add(product);
                        department.setProducts(products);
                    }
                }
            } else if (event.isEndElement()) {
                EndElement end = event.asEndElement();
                if (end.getName().getLocalPart().equals("department")) {
                    assert departments != null;
                    departments.add(department);
                    shop.setDepartments(departments);
                } else if (end.getName().getLocalPart().equals("shop")) {
                    shops.add(shop);
                }
            }
        }
    }
}
