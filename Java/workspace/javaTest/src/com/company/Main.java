package com.company;


import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        List<Student> list = baseTest.students();
        // collection list练习
//        baseTest.compara();

        //Optional练习
//        baseTest.OptionalTest(list.get(0));
//        baseTest.OptionalTest(new Student());

        //list练习
//        baseTest.listtest();

//        baseTest.stream();
        baseTest.clonetest();

    }

}
