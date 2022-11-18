package org.example;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        Xml xml = new Xml("src\\shops.xml");
        xml.readXml();
        Stream stream = new Stream();
        stream.setShops(xml.getShops());
        String input ="";
        while(!input.equals("exit")) {
            Scanner in = new Scanner(System.in);
            input = in.nextLine();
            switch (input) {
                case "print": {
                    stream.print();
                    break;
                }
                case "sortShops": {
                    List<Shop> shops = stream.sortShops();
                    break;
                }
                case "sortDepartments": {
                    stream.sortDepartments();
                    break;
                }
                case "filterCountDepartments": {
                    stream.filterCountDepartments(in.nextInt());
                    break;
                }
                case "filterNameShops": {
                    stream.filterNameShops(in.nextLine());
                    break;
                }
                case "help": {
                    System.out.println("print вывести магазины с отделами и продуктами\nsortShops отсортировать магазины по наименованию\n" +
                            "sortDepartments отсортировать отделы магазинов по наименованию\n" +
                            "filterCountDepartments вывести наименования магазинов с заданным количеством отделов\n" +
                            "filterNameShops вывести заданое наименование магазина\n");

                }
                default: break;
            }
        }
    }
}