package com.company;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class baseTest {

    public static void stream(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl","abc","abd","bcd","bed");
        System.out.println("before : " + strings);
        System.out.println("after->filter : " + strings.stream().filter(string -> !string.isEmpty()));
        System.out.println("after->filter-> sorted() ->collect: " + strings.stream().filter(string -> !string.isEmpty()).sorted().collect(Collectors.toList()));
        System.out.println("after->filter-> Collectors.toList(): " + strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList()));
        System.out.println("after->filter-> Collectors.joining : " + strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining("||")));
        System.out.println("after->filter-> Collectors.toList()-> forEach: ");
        strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList()).forEach(string->System.out.print("  "+string));
        System.out.println();
        System.out.println("after->filter-> distinct ->Collectors.toList: " + strings.stream().filter(string -> !string.isEmpty()).distinct().collect(Collectors.toList()));

        //Stream of():返回元素的顺序流、iterate():第一个参数是初始值，第二个参数是一个方法，对每个元素进行操作得到新值、generate():返回无限无序流
        Stream<Integer> stream = Stream.iterate(0,(x)->x+2).limit(5);
//        stream.forEach(System.out::println);

        //分割字符流
        Pattern pattern = Pattern.compile(",");
        Stream<String> stringStream = pattern.splitAsStream("a,b,c,d");
//        stringStream.forEach(System.out::println);

        //filter：过滤流中的某些元素
        //limit(n)：获取n个元素
        //skip(n)：跳过n元素，配合limit(n)可实现分页
        //distinct：通过流中元素的 hashCode() 和 equals() 去除重复元素
        Stream<Integer> streams = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);
        Stream<Integer> newStream = streams.filter(s -> s > 5) //6 6 7 9 8 10 12 14 14
                .distinct() //6 7 9 8 10 12 14
                .skip(2) //9 8 10 12 14
                .limit(2); //9 8
        newStream.forEach(System.out::println);


    }


    public static void listtest(){
        List<Student> li = new ArrayList();
        for (Student l:li){
            l.getName();
            System.out.println("null list");
        }
        //isEmpty是判断的list的大小，不是有无
        if (li.isEmpty()){
            System.out.println("空list111");
        }
        //当非基本类型赋值为null时，会报空指针，new了空对象时不会。
        List<Student> a = null;
//        System.out.println(a.get(0).getName());
    }

    public static void OptionalTest(Student stu) {
        System.err.println("正常写法");
        if (stu.getName() != null) {
            System.err.println(stu.getName());
            System.err.println(stu.getNo());
        } else {
            System.err.println("Student 对象为null");
        }

        System.err.println("Optional写法");
        Optional.ofNullable(stu).ifPresentOrElse(u -> {
            System.err.println(stu.getName());
            System.err.println(stu.getNo());
        }, () -> {
            System.err.println("Student 对象为null");
        });
    }



    public static void commpara(){
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
