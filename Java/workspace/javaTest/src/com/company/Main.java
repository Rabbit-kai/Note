package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List<Student> list = new ArrayList<Student>();
        list.add(new Student(1, "zhangsna", 1));
        list.add(new Student(2, "adafasf", 1));
        list.add(new Student(3, "asffaf", 1));
        list.add(new Student(4, "gbsdgasf", 1));
        list.add(new Student(5, "asfafaf", 1));
        list.add(new Student(6, "asdasfaf", 1));
        list.add(new Student(5, "asdasfaf", 1));
        list.add(new Student(7, "asdasfaf", 1));
        list.add(new Student(1, "asdasfaf", 1));
        list.add(new Student(87, "asdasfaf", 1));


        // 排序：先按名称排序，再按学号排序
//        Collections.sort(list);  对自定义类使用时，如果没有对该类实现Comparable接口，否则报错
        list.sort(Comparator.comparing(Student::getName).thenComparing(Student::getNo));
        for (Student stu : list) {
            System.out.println("排序后list：" + stu.getName() + "      " + stu.getNo());
        }
  /*    对基本型的排序
        List<Integer> intList = Arrays.asList(2, 3, 1);
        Collections.sort(intList);

        for(Integer stu:intList){
            System.out.println("排序后list：" + stu + "      " + stu );
        }

    */
    /* compareTo::
        String str1 = "Strings";
        String str2 = "Strings";
        String str3 = "Strings123";

        System.out.println(str1.compareTo(str2));
        System.out.println(str2.compareTo(str3));
        System.out.println(str3.compareTo(str2));
    */


//        int index = Collections.binarySearch(list.sort());
//        System.out.println(index);

    }
}
