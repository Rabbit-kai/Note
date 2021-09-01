package com.company;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();
        list.add(new Student(1, "zhangsna", 1));
        list.add(new Student(2, "adafasf", 1));
        list.add(new Student(3, "asffaf", 1));
        list.add(new Student(4, "gbsdgasf", 1));
        list.add(new Student(5, "asfafaf", 1));
        list.add(new Student(6, "asdasfaf", 1));
        list.add(new Student(5, "asdasfaf", 2));
        list.add(new Student(7, "asdasfaf", 2));
        list.add(new Student(1, "asdasfaf", 2));
        list.add(new Student(87, "asdasfaf", 2));

        // collection list练习
//        baseTest.commpara();

        //Optional练习
//        baseTest.OptionalTest(list.get(0));
//        baseTest.OptionalTest(new Student());

        //list练习
        baseTest.listtest();

    }
}
