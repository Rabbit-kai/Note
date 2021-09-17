package com.company;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class baseTest {

    public static void base(){
        //String 传值 传址
        String a = "hello";
        String b = "hello";
//        a = "Hello Java";

        System.out.println("a:: "+a);
        System.out.println("b:: "+b);
        System.out.println(a==b);
        System.out.println(a.equals(b));

        //对象 传址
        List<Student> list = new LinkedList<>();
        Student stu = new Student(1, "Aa",'1');
        list.add(stu);
        System.out.println("before:"+list);
        stu.setName("Bb");
        System.out.println("list:" + list.get(0).getName());
        System.out.println("after:"+list);

    }


    public static void stream(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl","abc","abd","bcd","bed");
        System.out.println("before : " + strings);
        System.out.println("after->filter : " + strings.stream().filter(string -> !string.isEmpty()));
        System.out.println("after->filter-> sorted(顺序) ->collect: " + strings.stream().filter(string -> !string.isEmpty()).sorted().collect(Collectors.toList()));
        System.out.println("after->filter-> sorted(Comparator 倒序) ->collect: " + strings.stream().filter(string -> !string.isEmpty()).sorted(
                (o1, o2) -> {
                    if (o1.compareTo(o2) > 1){
                        return -1;
                    }else if (o1.compareTo(o2) < 1){
                        return 1;
                    }else {
                        return 0;
                    }
                }
        ).collect(Collectors.toList()));
        //装成list  转成set： toSet()  转为map：toMap(Student::getName, Student::getAge)
        System.out.println("after->filter-> Collectors.toList(): " + strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList()));
        //字符串分隔符连接
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
        //limit(n)：获取n个元素(限制元素数)
        //skip(n)：跳过n元素，从n+1开始到最后，配合limit(n)可实现分页
        //distinct：通过流中元素的 hashCode() 和 equals() 去除重复元素
        System.out.println("after->filter-> distinct->skip ->limit->joining " + strings.stream().filter(string -> !string.isEmpty()).distinct().skip(2).limit(2).collect(Collectors.joining("||")));
        Stream<Integer> streams = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);
        Stream<Integer> newStream = streams.filter(s -> s > 5) //6 6 7 9 8 10 12 14 14
                .distinct() //6 7 9 8 10 12 14
                .skip(2) //9 8 10 12 14
                .limit(2); //9 8
        newStream.forEach(System.out::println);

        List<String> names= Arrays.asList("a","one","two","three","four");
        names.stream()
                .filter(s -> s.length() > 2)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        /*映射
            map:接收一个函数作为参数，该函数会被应用的每个元素上，并将其映射成一个新的元素
            flatMap： 接收一个函数，将流中的每一个值都变成一个流，然后把所有的流连城一个流
        */
        List<String> list = Arrays.asList("a,b,c", "1,2,2");
        Stream<String> streamss = list.stream().map(s->s.replaceAll(",", ""));
        System.out.println("map--------------");
        streamss.forEach(System.out::println);
        /**
         * 输出 abc 122
         */
        System.out.println("flatMap--------------");
        Stream<String> stream2 = list.stream().flatMap(s->{
            String [] split = s.split(",");
            Stream<String> stream1 = Arrays.stream(split);
            return stream1;
        });
        stream2.forEach(System.out::println);

        /**
         * 输出 a b c 1 2 2
         */

        /*
         * 聚合操作  当返回值为Optional类型时，需要用get()来获取返回值中的数据入 maxBy minBy reduce
         * 1.Collectors.counting() 计数
         * 2.maxBy() minBy()最大最小
         * 3.summingInt()/summingLong()/summingDouble() 求和功能
         * 4.averagingDouble()/averagingInt()/averagingLong() 求平均值
         * 5.groupingBy() 分组group by
         * 6.collect(Collectors.groupingBy(Student::getType, Collectors.groupingBy(Student::getAge)))
         * 7.partitioningBy(v -> v.getAge() > 10) 根据条件分区，分成多个部分
         * 8.reducing(Integer::sum) 规约  collectors下为reducing，stream中为reduce
         *   reduce(accumulator)
         *   reduce(identity,accumulator)
         *   reduce(identity,accumulator,combiner)  //dentity是reduce进行迭代操作的初始值。accumulator是用来迭代的。combiner是并发时用来合并各线程结果的
         *
         * */

        /**
         * reduce三种形态
         * 1、Optional accResult = Stream.of(1, 2, 3, 4).reduce((acc, item) -> acc + item)  //这个方法返回值类型是Optiona
         */
        //拆分解释：
        System.out.println("-----------reduce第一种----------------");

        Optional accResult = Stream.of(1, 2, 3, 4)
                .reduce((acc, item) -> {
                    System.out.println("每次循环的初始值(上次计算后的结果值)：acc : "  + acc);
                    acc += item;
                    System.out.println("本次循环的元素item: " + item);
                    System.out.println("acc+ : "  + acc);
                    System.out.println("--------");
                    return acc;
                });
        System.out.println("accResult: " + accResult.get());
        System.out.println("---------------------------");

        /**
         * 第二种会接受一个identity参数，用来指定Stream循环的初始值。如果Stream为空，就直接返回该值。另一方面，该方法不会返回Optional，因为该方法不会出现null。
         * 2、int accResult = Stream.of(1, 2, 3, 4).reduce(100,(acc, item) -> acc + item)
         */
        System.out.println("accResult: " + accResult.get());

        Stream.of(1, 2, 3, 4)
                .reduce(0, (acc, item) -> {
                    System.out.println("acc : "  + acc);
                    acc += item;
                    System.out.println("item: " + item);
                    System.out.println("acc+ : "  + acc);
                    System.out.println("--------");
                    return acc;
                });

        /**
         * 第三种 第三个参数是在并行执行时使用
         * 3、int d = Stream.of(2, 3, 4, 5, 6, 7, 8, 9).parallel().reduce(1, (acc, x) -> acc + x, (x, y) -> x + y - 1);
         */
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, (sum, item) -> sum + item));
        int b = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).parallel().reduce(0, (acc, x) -> acc + x);
        int c = Stream.of(2, 3, 4, 5, 6, 7, 8, 9).parallel().reduce(1, (acc, x) -> acc + x);
        int d = Stream.of(2, 3, 4, 5, 6, 7, 8, 9).parallel().reduce(1, (acc, x) -> acc + x, (x, y) -> x + y - 1);
        System.out.printf("初始值个数不影响结果：%d\n", b);
        System.out.printf("无修正:%d\n", c);
        System.out.printf("合并修正:%d\n", d);


        /**
         * map
         */
        List<String> list1 = Arrays.asList("a,b,c", "1,2,3");

        //将一个String类型的Stream对象中的每个元素添加相同的后缀.txt，如a变成a.txt
        Stream<String> s = Stream.of("test", "t1", "t2", "teeeee", "aaaa");
        s.map(n -> n.concat(".txt")).forEach(System.out::println);

        Stream<String> s3 = list1.stream().flatMap(ss -> {
            //将每个元素转换成一个stream(stream中有多个元素)
            String[] split = ss.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        });
        s3.forEach(System.out::println);





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

        List<Student> list = students();



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

    public static List<Student> students(){
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

        Collections.sort(list);
        for (Student li:list){
//            System.out.println("no:: " + li.getNo() + "   name:: " + li.getName());
        }

        Comparator<Student> comparing = Comparator.comparing(Student::getName);


        return list;
    }


    public static void compara(){
        // write your code here
        List<Student> list = students();
//        Collections.sort();
//        Collectors
//        Comparator
//        Collection
//        Collector
//        Comparable

        // 排序：先按名称排序，再按学号排序
//        Collections.sort(list);  对自定义类使用时，如果没有对该类实现Comparable接口，否则报错,入参：class::function
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

    public static void clonetest() throws CloneNotSupportedException {
        /**
         *① 实现Cloneable接口，这是一个标记接口，自身没有方法。
         *② 覆盖clone()方法，可见性提升为public。
         */
        Student stu = new Student(1, "Aa",'1');

        Student stu1 = stu.clone();
        System.out.println(stu);
        System.out.println(stu1);
        System.out.println(stu);
        System.out.println(stu.getName());
        System.out.println(stu1);
        System.out.println(stu1.getName());


    }


}
