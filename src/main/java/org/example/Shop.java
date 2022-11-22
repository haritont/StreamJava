package org.example;

import java.util.ArrayList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Shop {
    private String name;
    private ArrayList<Department> departments;
}
