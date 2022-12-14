package org.example;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
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
                    stream.sortShops();
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
                    System.out.println("""
                            print вывести магазины с отделами и продуктами
                            sortShops отсортировать магазины по наименованию
                            sortDepartments отсортировать отделы магазинов по наименованию
                            filterCountDepartments вывести наименования магазинов с заданным количеством отделов
                            filterNameShops вывести заданое наименование магазина
                            """);

                }
                default: break;
            }
        }
    }
}