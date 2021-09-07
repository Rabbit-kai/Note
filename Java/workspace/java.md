# **Object... 的用法：**

Object ...objects(称为可变个数的形参)这种参数定义是在不确定方法参数的情况下的一种多态表现形式。即这个方法可以传递多个参数，这个参数的个数是不确定的。这样你在方法体中需要相应的做些处理。因为Object是基类，所以使用Object ...objects这样的参数形式，允许一切继承自Object的对象作为参数。

Object[] obj这样的形式，就是一个Object数组构成的参数形式。说明这个方法的参数是固定的，是一个Object数组，至于这个数组中存储的元素，可以是继承自Object的所有类的对象。

# **多态**

所以对于多态我们可以总结如下：

   指向子类的父类引用由于向上转型了，它只能访问父类中拥有的方法和属性，而对于子类中存在而父类中不存在的方法，该引用是不能使用的，尽管是重载该方法。若子类重写了父类中的某些方法，在调用该些方法的时候，必定是使用子类中定义的这些方法（动态连接、动态调用）。

父类  a = new 子类();

a只能调用子类和父类公有的方法和变量，无法调用子类中单独定义的变量和方法。

# Collections&Collector

## Collection：

​	集合的顶级接口，List和Set等都会实现该接口。

## Collections：

​	是集合的工具类，用于操作集合类。本身没有实现Collection接口，而是内部类实现了Collection接口，它的作用就是封装常用的集合操作。

1） 排序（Sort）
      使用sort方法可以根据元素的自然顺序 对指定列表按升序进行排序。列表中的所有元素都必须实现 Comparable 接口。此列表内的所有元素都必须是使用指定比较器可相互比较的。

**该方法有两个用法：**

​	**1、使用默认排序，只需传入排序的对象即可；**

​	**2、使用自定义排序器，需额外传入一个Comparator对象。**

```java
      List<Integer> list = new LinkedList<Integer>();
		int array[] = { 112, 111, 23, 456, 231 };
		for (int i = 0; i < array.length; i++) {
			list.add(new Integer(array[i]));
		}
		Collections.sort(list); //默认排序
		Collections.sort(list,new Comparator<Integer>(){ //自定义排序规则
            @Override
       		 public int compare(Integer o1, Integer o2) { 
       		 return o2 - o1;
        })
		for (int i = 0; i < array.length; i++) {
			System.out.print(list.get(i)+"");
		}
```

结果：23,111,112,231,456,
2） 混排（Shuffling）
     混排算法所做的正好与 sort 相反： 它打乱在一个 List 中可能有的任何排列的踪迹。也就是说，基于随机源的输入重排该 List，这样的排列具有相同的可能性（假设随机源是公正的）。这个算法在实现一个碰运气的游戏中是非常有用的。例如，它可被用来混排代表一副牌的 Card 对象的一个 List .另外，在生成测试案例时，它也是十分有用的。

```java
Collections.Shuffling(list)
List<Integer> list = new ArrayList<Integer>();
		int array[] = { 112, 111, 23, 456, 231 };
		for (int i = 0; i < array.length; i++) {
			list.add(new Integer(array[i]));
		}
		Collections.shuffle(list);
		for (int i = 0; i < array.length; i++) {
			System.out.print(list.get(i) + ",");
		}
//结果：112,111,23,456,231   112,231,111,456,23,      随机的。
```

3） 反转（Reverse）
     使用Reverse方法可以根据元素的自然顺序 对指定列表按降序进行排序。

```java
Collections.reverse(list)
List<Double> list = new ArrayList<Double>();
		double array[] = {112, 111, 23, 456, 231 };
		for (int i = 0; i < array.length; i++) {
		list.add(new Double(array[i]));
		}
		Collections. reverse (list);
		for (int i = 0; i < array.length; i++) {
		System.out.print(list.get(i)+",");
		}
//结果：231.0,456.0,23.0,111.0,112.0,  结果反转反转。
```

4） 替换所有的元素（Fill）
使用指定元素替换指定列表中的所有元素。

```java
String str[] = { "dd", "aa", "bb", "cc", "ee" };
		List<String> list = new ArrayList<String>();
		for (int j = 0; j < str.length; j++) {
			list.add(str[j]);
		}
		Collections.fill(list, "aaa");
		for (int i = 0; i < list.size(); i++) {
			System.out.print("list[" + i + "]=" + list.get(i)+",");

​	}
```

结果：list[0]=aaa,list[1]=aaa,list[2]=aaa,list[3]=aaa,list[4]=aaa,
5） 拷贝（Copy）
用两个参数，一个目标 List 和一个源 List， 将源的元素拷贝到目标，并覆盖它的内容。目标 List 至少与源一样长。如果它更长，则在目标 List 中的剩余元素不受影响。
Collections.copy（list，li）： 后面一个参数是目标列表 ，前一个是源列表

```java
	double array[] = { 112, 111, 23, 456, 231 };
​		List<Double> list = new ArrayList<Double>();
​		List<Double> li = new ArrayList<Double>();
​		for (int i = 0; i < array.length; i++) {
​			list.add(new Double(array[i]));
​		}
​		double arr[] = { 1131, 333 };
​		for (int j = 0; j < arr.length; j++) {
​			li.add(new Double(arr[j]));
​		}
​		Collections.copy(list, li);
​		list.forEach(x->System.out.print(x)+",   ")

//结果：1131.0,  333.0,  23.0,  456.0,  231.0,  
```

6） 返回Collections中最小元素（min） 最小元素（max）
根据指定比较器产生的顺序，返回给定 collection 的最小(大)元素。collection 中的所有元素都必须是通过指定比较器可相互比较的。

```java
Collections.min(list)  Collections.max(list)
	Integer[] array = { 112, 222, 23, 456, 231 };
		List<Integer> list =new ArrayList<Integer>();
	    for (Integer integer : array) {
	    	list.add(integer);
		}
		System.out.println(Collections.min(list));
		System.out.println(Collections.max(list));
//结果：23  456
```

8） lastIndexOfSubList
返回指定源列表中最后一次出现指定目标列表的起始位置，即按从后到前的顺序返回子List在父List中的索引位置。

9） IndexOfSubList
返回指定源列表中第一次出现指定目标列表的起始位置

10） Rotate
根据指定的距离循环移动指定列表中的元素
Collections.rotate（list，-1）；
如果是负数，则正向移动，正数则方向移动

11)static int binarySearch(List list,Object key)
   使用二分搜索查找key对象的索引值，因为使用的二分查找，所以前提是必须有序。
12)static Object max(Collection coll)
   根据元素自然顺序，返回集合中的最大元素
13)static Object max(Collection coll,Compare comp)
   根据Comparator指定的顺序，返回给定集合中的最大元素
14)static Object min(Collection coll)
   根据元素自然顺序，返回集合中的最小元素
15)static Object min(Collection coll,Compare comp)
   根据Comparator指定的顺序，返回给定集合中的最小元素
16）static void fill(List list,Object obj)
   使用指定元素替换指定集合中的所有元素
17）static int frequency(Collection c,Object o)
   返回指定元素在集合中出现在次数
18）static int indexOfSubList(List source, List target)
   返回子List对象在父List对象中第一次出现的位置索引； 如果父List中没有出现这样的子List，则返回-1
19）static int lastIndexOfSubList(List source,List target)
   返回子List对象在父List对象中最后一次出现的位置索引，如果父List中没有出现这样的子List，刚返回-1
20）static boolean replaceAll(List list,Object oldVal,Object newVal)
  使用一个新值newVal替换List对象所有旧值oldVal
21）synchronizedXXX(new XXX)
      Collections类为集合类们提供的同步控制方法

```java
public class SynchronizedTest
{
      public static void main(String[] args){
            Collection collection = Collections.synchronizedCollections(new ArrayList());
            List list = Collections.synchronizedList(new ArrayList());
            Set s = Collections.synchronizedSet(new HashSet());
            Map s = Collections.synchronizedMap(new HashMap()):
      }
}
```

22)emptyXXX()
   返回一个空的、不可变的集合对象，此处的集合既可以是List，也可以是Set,还可以是Map。
23）singletonXXX()
   返回一个只包含指定对象（只有一个或一项元素）的、不可变的集合对象，此处集合既可以是List,也可以是Set,还可以是Map。
24）unmodificableXXX()
   指定返回集合对象的不可变视图，此处的集合既可以是Lsit,也可以是Set,Map。

## Collectors：

Collectors是一个收集器工具类，常用于流操作中。常用方法如下：

![image-20210906214403056](E:\Note\Java\workspace\java.pic\image-20210906214403056.png)

## Collector：

类比上面Collections与Collection的作用，定义收集流元素的规范，流中的collect()方法传入的都是一个Collector接口，然后Collectors工具类中的方法返回值也是这个接口，这样就可以很方便的利用java8的新特性方法引用，如下的使用方式

```java
public static void main(String[] args) {
    List<Integer> lists = Stream.of(1, 2, 3).collect(Collectors.toList());
}
```

## Comparable: compareTo

1：所有可以 “排序” 的类都实现了java.lang.Comparable接口，Comparable接口中只有一个方法。
		2：public int compareTo(Object obj) ; // 当 this > obj时返回>0,this < obj时返回<0,this == obj时返回=0。
		**3:实现了 Comparable 接口的类通过重写 comparaTo 方法从而确定该类对象的排序方式。在使用时可以直接通过Collections.sort(list)或者arraylist.sort(list)进行排序**

```java
if (this - o > 0){
    return 1; //正序,同样如果 this - o < 0 return -1; 也是正序| o-this <0 return -1;也是正序...
}else if (this - o < 0){
    return -1; //正序
}else{
    return 0; //相等
}
```

Demo：

```java
//先按no进行升序排列，no相同时按name再进行升序排列
public int compareTo(Student o) { 
    if (this.getNo() - o.getNo() > 0 ){
        return 1;
    }else if(this.getNo() - o.getNo() == 0){
        if(this.getName().compareTo(o.getName())>0){  // 当大于时返回>0,小于时返回<0,相等时返回=0。
            return 1;
        }else if(this.getName().compareTo(o.getName())<0){  // 当大于时返回>0,小于时返回<0,相等时返回=0。
            return -1;
        }else {
            return 0;
        }
    }else {
        return -1;
    }
}

```

```java
//定义列表并调用排序方法
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
    System.out.println("no:: " + li.getNo() + "   name:: " + li.getName());
}

//结果展示
no:: 1   name:: asdasfaf
no:: 1   name:: zhangsna
no:: 2   name:: adafasf
no:: 3   name:: asffaf
no:: 4   name:: gbsdgasf
```



## Comparator：

该接口也是具有比较的功能，但该接口注重的却是比较容器，只有两个Collator, RuleBasedCollator。

作为接口Comparator提供抽象方法，如下：

| int     | [compare](https://www.cnblogs.com/lin-jing/p/8279205.html#compare(T, T))(T o1, T o2) 比较用来排序的两个参数。根据第一个参数小于、等于或大于第二个参数分别返回负整数、零或正整数。                                ·  返回值小于零，则不交换o1和o2的位置；返回值大于零，则交换o1和o2的位置 |
| ------- | ------------------------------------------------------------ |
| boolean | [equals](https://www.cnblogs.com/lin-jing/p/8279205.html#equals(java.lang.Object))(Object obj) 指示某个其他对象是否“等于”此 Comparator。 |

compare
comparing
comparing
comparingDouble
comparingInt
comparingLong
equals
naturalOrder
nullsFirst
nullsLast
reversed
reverseOrder
thenComparing
thenComparing
thenComparing
thenComparingDouble
thenComparingInt
thenComparingLong



重写Comparator中的compara方法即可：

```java
Collections.sort(list,new Comparator<Integer>(){ //自定义排序规则
            @Override
       		 public int compare(Integer o1, Integer o2) { 
       		 return o2 - o1;
        })
```



# **排序**

## 一、工具类Collections

1、Collections.sort(List)   //只针对java已经实现Comparable接口的类基本型生效入String、Intager...，如果对自定义的类对象进行排序需要实现Comparable接口

1. 类需要集成Comparable接口并在类中重写comparaTo方法。

```java
public class Emp implements Comparable<Emp>{

    /*属性、getter/setter方法、toString方法及构造方法略*/
    @Override
    public int compareTo(Emp emp) {
        /*按员工编号正序排序*/
        //return this.getEmpno()-emp.getEmpno();
        /*按员工编号逆序排序*/
        //return emp.getEmpno()-this.getEmpno();
        /*按员工姓名正序排序*/
        //return this.getEname().compareTo(emp.getEname());
        /*按员工姓名逆序排序*/
        return emp.getEname().compareTo(this.getEname());
    }
}    

 private static void sortEmpByDefaultMode()
    {
        System.out.println("before sort:");
        PrintUtil.showList(empList);
        System.out.println("=========================");
        Collections.sort(empList);
        System.out.println("after sort:");
        PrintUtil.showList(empList);
    }
```

2、Collections.sort(List,Comparator)

```java
Collections.sort(list,new Comparator<ListType>(){
    @override
    public int compara(ListType o1,ListType o2){
                以下方式都是只根据一个字段进行排序
                /*按员工编号正序排序*/
                return o1.getEmpno()-o2.getEmpno();
                /*按员工编号逆序排序*/
                //return o2.getEmpno()-o1.getEmpno();
                /*按员工姓名正序排序*/ 对字符串进行排序时，使用comparaTo,当大于时返回>0,小于时返回<0,相等时返回=0。
                //return o1.getEname().compareTo(o2.getEname());
                /*按员工姓名逆序排序*/
                //return o2.getEname().compareTo(o1.getEname());
                
                
                根据多个字段进行排序,正序排列：第一个变量减第二个变量>0时，return 1；当<0时，return -1；当相等时，return 0。
                if(o1.getEmpno()>o2.getEmpno()){
                    return 1; 
                }else if(o1.getEmpno() < o2.getEmpno()){
                    return -1;
                }else  if(o1.getEmpno() = o2.getEmpno()){
                    if(o1.getEname().compareTo(o2.getEname() > 1){
                        return -1;
                    }else if(o1.getEname().compareTo(o2.getEname() < 0){
                        return -1;
                    }else{
                        return 0;
                    }
                }
    }


}})))
```

## 二、Comparator

StringUtils.*join* 将数组或集合以某拼接符拼接到一起形成新的字符串。





# Stream

- **数据源** 流的来源。 可以是集合，数组，I/O channel， 产生器generator 等。
- **聚合操作** 类似SQL语句一样的操作， 比如filter, map, reduce, find, match, sorted等。
- **输入**：->前面的部分，即被()包围的部分。此处只有一个输入参数，实际上输入是可以有多个的，如两个参数时写法：(a, b);当然也可以没有输入，此时直接就可以是()。
  **函数体**：->后面的部分，即被{}包围的部分；可以是一段代码。
  **输出**：函数式编程可以没有返回值，也可以有返回值。**如果有返回值时，需要代码段的最后一句通过return的方式返回对应的值。**
- Stream对象提供多个非常有用的方法，这些方法可以分成两类：
  **中间操作**：将原始的Stream转换成另外一个Stream；如filter返回的是过滤后的Stream。
  **终端操作**：产生的是一个结果或者其它的复合操作；如count或者forEach操作。

![img](E:\Note\Java\workspace\java.pic\watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3lfa195,size_16,color_FFFFFF,t_70.png)   

- 无状态：指元素的处理不受之前元素的影响；
- 有状态：指该操作只有拿到所有元素之后才能继续下去。

- 非短路操作：指必须处理所有元素才能得到最终结果；

- 短路操作：指遇到某些符合条件的元素就可以得到最终结果，如 A || B，只要A为true，则无需判断B的结果。

| 中间操作 |
| :------: |

| 方法       | 说明                                                         |
| ---------- | ------------------------------------------------------------ |
| sequential | 返回一个相等的串行的Stream对象，如果原Stream对象已经是串行就可能会返回原对象 |
| parallel   | 返回一个相等的并行的Stream对象，如果原Stream对象已经是并行的就会返回原对象 |
| unordered  | 返回一个不关心顺序的Stream对象，如果原对象已经是这类型的对象就会返回原对象 |
| onClose    | 返回一个相等的Steam对象，同时新的Stream对象在执行Close方法时会调用传入的Runnable对象 |
| close      | 关闭Stream对象                                               |
| filter     | 元素过滤：对Stream对象按指定的Predicate进行过滤，返回的Stream对象中仅包含未被过滤的元素 |
| map        | 元素一对一转换：使用传入的Function对象对Stream中的所有元素进行处理，返回的Stream对象中的元素为原元素处理后的结果 |
| mapToInt   | 元素一对一转换：将原Stream中的使用传入的IntFunction加工后返回一个IntStream对象 |
| flatMap    | 元素一对多转换：对原Stream中的所有元素进行操作，每个元素会有一个或者多个结果，然后将返回的所有元素组合成一个统一的Stream并返回； |
| distinct   | 去重：返回一个去重后的Stream对象                             |
| sorted     | 排序：返回排序后的Stream对象                                 |
| peek       | 使用传入的Consumer对象对所有元素进行消费后，返回一个新的包含所有原来元素的Stream对象 |
| limit      | 获取有限个元素组成新的Stream对象返回                         |
| skip       | 抛弃前指定个元素后使用剩下的元素组成新的Stream返回           |
| takeWhile  | 如果Stream是有序的（Ordered），那么返回最长命中序列（符合传入的Predicate的最长命中序列）组成的Stream；如果是无序的，那么返回的是所有符合传入的Predicate的元素序列组成的Stream。 |
| dropWhile  | 与takeWhile相反，如果是有序的，返回除最长命中序列外的所有元素组成的Stream；如果是无序的，返回所有未命中的元素组成的Stream。 |

| 终端操作 |
| :------: |

| 方法           | 说明                                                         |
| -------------- | ------------------------------------------------------------ |
| iterator       | 返回Stream中所有对象的迭代器;                                |
| spliterator    | 返回对所有对象进行的spliterator对象                          |
| forEach        | 对所有元素进行迭代处理，无返回值                             |
| forEachOrdered | 按Stream的Encounter所决定的序列进行迭代处理，无返回值        |
| toArray        | 返回所有元素的数组                                           |
| reduce         | 使用一个初始化的值，与Stream中的元素一一做传入的二合运算后返回最终的值。每与一个元素做运算后的结果，再与下一个元素做运算。它不保证会按序列执行整个过程。 |
| collect        | 根据传入参数做相关汇聚计算                                   |
| min            | 返回所有元素中最小值的Optional对象；如果Stream中无任何元素，那么返回的Optional对象为Empty |
| max            | 与Min相反                                                    |
| count          | 所有元素个数                                                 |
| anyMatch       | 只要其中有一个元素满足传入的Predicate时返回True，否则返回False |
| allMatch       | 所有元素均满足传入的Predicate时返回True，否则False           |
| noneMatch      | 所有元素均不满足传入的Predicate时返回True，否则False         |
| findFirst      | 返回第一个元素的Optioanl对象；如果无元素返回的是空的Optional； 如果Stream是无序的，那么任何元素都可能被返回。 |
| findAny        | 返回任意一个元素的Optional对象，如果无元素返回的是空的Optioanl。 |
| isParallel     | 判断是否当前Stream对象是并行的                               |





## 1、流的常用创建方法

### 1.1 使用Collection下的 stream() 和 parallelStream() 方法

```java
List<String> list = new ArrayList<>();
Stream<String> stream = list.stream(); //获取一个顺序流
Stream<String> parallelStream = list.parallelStream(); //获取一个并行流
```

### 1.2 使用Arrays 中的 stream() 方法，将数组转成流

```java
Integer[] nums = new Integer[10];
Stream<Integer> stream = Arrays.stream(nums);
```

### 1.3 使用Stream中的静态方法：of()、iterate()、generate()

```java
/**
         * of()  返回元素的顺序流
         */
      Stream<Integer> stream3 = Stream.of(num);
      stream3.forEach(System.out::println);
        /**
         * iterate()方法，第一个参数是初始值，第二个参数是一个方法，对每个元素进行操作得到新值
         * 这个方法获取的是无限流，需要借助limit() 方法来截取
         */
        Stream<Integer> stream = Stream.iterate(0,(x)->x+2).limit(3);
        stream.forEach(System.out::println);
         /**
         * 输出  0  2  4
         */

        /**
         * generate() 方法  返回无限无序流
         */
        Stream<Double> stream3 = Stream.generate(Math::random).limit(2);
        stream3.forEach(System.out::println);
/**
* 输出  0.33461878068832596   0.4114666080839796
*/
```

### 1.4 使用 BufferedReader.lines() 方法，将每行内容转成流

```java
BufferedReader reader = new BufferedReader(new FileReader("F:\\test_stream.txt"));
Stream<String> lineStream = reader.lines();
lineStream.forEach(System.out::println);
```

### 1.5 使用 Pattern.splitAsStream() 方法，将字符串分隔成流

```java
Pattern pattern = Pattern.compile(",");
Stream<String> stringStream = pattern.splitAsStream("a,b,c,d");
stringStream.forEach(System.out::println);
```



## 2.流的中间操作

### 2.1 筛选与切片

​        filter：过滤流中的某些元素
​        limit(n)：获取n个元素
​        skip(n)：跳过n元素，配合limit(n)可实现分页
​        distinct：通过流中元素的 hashCode() 和 equals() 去除重复元素

```java
Stream<Integer> stream = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);

Stream<Integer> newStream = stream.filter(s -> s > 5) //6 6 7 9 8 10 12 14 14
        .distinct() //6 7 9 8 10 12 14
        .skip(2) //9 8 10 12 14
        .limit(2); //9 8
newStream.forEach(System.out::println);
```

### 2.2 map 映射        

map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。 mapToInt，mapToLong和mapToDouble
        flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。

浅显的理解：map是传入一个元素、返回一个元素；flatMap是传入一个元素，返回流中有多个元素。

```java
List<String> list = Arrays.asList("a,b,c", "1,2,3");

//将一个String类型的Stream对象中的每个元素添加相同的后缀.txt，如a变成a.txt
Stream<String> s = Stream.of("test", "t1", "t2", "teeeee", "aaaa");
s.map(n -> n.concat(".txt")).forEach(System.out::println);

Stream<String> s3 = list.stream().flatMap(s -> {
    //将每个元素转换成一个stream(stream中有多个元素)
    String[] split = s.split(",");
    Stream<String> s2 = Arrays.stream(split);
    return s2;
});
s3.forEach(System.out::println); // a b c 1 2 3
```

### 2.3 排序

​        sorted()：自然排序，流中元素需实现Comparable接口
​        sorted(Comparator com)：定制排序，自定义Comparator排序器  

```java
List<String> list = Arrays.asList("aa", "ff", "dd");
//String 类自身已实现Compareable接口
list.stream().sorted().forEach(System.out::println);// aa dd ff

Student s1 = new Student("aa", 10);
Student s2 = new Student("bb", 20);
Student s3 = new Student("aa", 30);
Student s4 = new Student("dd", 40);
List<Student> studentList = Arrays.asList(s1, s2, s3, s4);

//自定义排序：先按姓名升序，姓名相同则按年龄升序
studentList.stream().sorted(
        (o1, o2) -> {
            if (o1.getName().equals(o2.getName())) {
                return o1.getAge() - o2.getAge();
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        }
).forEach(System.out::println);
```

### 2.4 消费

​        peek：如同于map，能得到流中的每一个元素。但map接收的是一个Function表达式，有返回值；而peek接收的是Consumer表达式，没有返回值。

```java
Student s1 = new Student("aa", 10);
Student s2 = new Student("bb", 20);
List<Student> studentList = Arrays.asList(s1, s2);

studentList.stream()
        .peek(o -> o.setAge(100))
        .forEach(System.out::println);   

//结果：
Student{name='aa', age=100}
Student{name='bb', age=100}      
```

​      

## 3.流的终止操作

### 3.1 匹配、聚合操作

allMatch：接收一个 Predicate 函数，当流中每个元素都符合该断言时才返回true，否则返回false
​        noneMatch：接收一个 Predicate 函数，当流中每个元素都不符合该断言时才返回true，否则返回false
​        anyMatch：接收一个 Predicate 函数，只要流中有一个元素满足该断言则返回true，否则返回false
​        findFirst：返回流中第一个元素
​        findAny：返回流中的任意元素
​        count：返回流中元素的总个数
​        max：返回流中元素最大值
​        min：返回流中元素最小值

```java
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

boolean allMatch = list.stream().allMatch(e -> e > 10); //false
boolean noneMatch = list.stream().noneMatch(e -> e > 10); //true
boolean anyMatch = list.stream().anyMatch(e -> e > 4);  //true

Integer findFirst = list.stream().findFirst().get(); //1
Integer findAny = list.stream().findAny().get(); //1

long count = list.stream().count(); //5
Integer max = list.stream().max(Integer::compareTo).get(); //5
Integer min = list.stream().min(Integer::compareTo).get(); //1
```

### 3.2 规约操作 reduce

​        Optional<T> reduce(BinaryOperator<T> accumulator)：第一次执行时，accumulator函数的第一个参数为流中的第一个元素，第二个参数为流中元素的第二个元素；第二次执行时，第一个参数为第一次函数执行的结果，第二个参数为流中的第三个元素；依次类推。
​        T reduce(T identity, BinaryOperator<T> accumulator)：流程跟上面一样，只是第一次执行时，accumulator函数的第一个参数为identity，而第二个参数为流中的第一个元素。
​        <U> U reduce(U identity,BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner)：在串行流(stream)中，该方法跟第二个方法一样，即第三个参数combiner不会起作用。在并行流(parallelStream)中,我们知道流被fork join出多个线程进行执行，此时每个线程的执行流程就跟第二个方法reduce(identity,accumulator)一样，而第三个参数combiner函数，则是将每个线程的执行结果当成一个新的流，然后使用第一个方法reduce(accumulator)流程进行规约。

```java
//经过测试，当元素个数小于24时，并行时线程数等于元素个数，当大于等于24时，并行时线程数为16
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);

Integer v = list.stream().reduce((x1, x2) -> x1 + x2).get();
System.out.println(v);   // 300

Integer v1 = list.stream().reduce(10, (x1, x2) -> x1 + x2);
System.out.println(v1);  //310

Integer v2 = list.stream().reduce(0,
        (x1, x2) -> {
            System.out.println("stream accumulator: x1:" + x1 + "  x2:" + x2);
            return x1 - x2;
        },
        (x1, x2) -> {
            System.out.println("stream combiner: x1:" + x1 + "  x2:" + x2);
            return x1 * x2;
        });
System.out.println(v2); // -300

Integer v3 = list.parallelStream().reduce(0,
        (x1, x2) -> {
            System.out.println("parallelStream accumulator: x1:" + x1 + "  x2:" + x2);
            return x1 - x2;
        },
        (x1, x2) -> {
            System.out.println("parallelStream combiner: x1:" + x1 + "  x2:" + x2);
            return x1 * x2;
        });
System.out.println(v3); //197474048
```

### 3.3 收集操作

​        collect：接收一个Collector实例，将流中元素收集成另外一个数据结构。
​        Collector<T, A, R> 是一个接口，有以下5个抽象方法：
​            Supplier<A> supplier()：创建一个结果容器A
​            BiConsumer<A, T> accumulator()：消费型接口，第一个参数为容器A，第二个参数为流中元素T。
​            BinaryOperator<A> combiner()：函数接口，该参数的作用跟上一个方法(reduce)中的combiner参数一样，将并行流中各                                                                 个子进程的运行结果(accumulator函数操作后的容器A)进行合并。
​            Function<A, R> finisher()：函数式接口，参数为：容器A，返回类型为：collect方法最终想要的结果R。
​            Set<Characteristics> characteristics()：返回一个不可变的Set集合，用来表明该Collector的特征。有以下三个特征：
​                CONCURRENT：表示此收集器支持并发。（官方文档还有其他描述，暂时没去探索，故不作过多翻译）
​                UNORDERED：表示该收集操作不会保留流中元素原有的顺序。
​                IDENTITY_FINISH：表示finisher参数只是标识而已，可忽略。
​        注：如果对以上函数接口不太理解的话，可参考我另外一篇文章：Java 8 函数式接口

#### 3.3.1 Collector 工具库：Collectors

```java
Student s1 = new Student("aa", 10,1);
Student s2 = new Student("bb", 20,2);
Student s3 = new Student("cc", 10,3);
List<Student> list = Arrays.asList(s1, s2, s3);

//装成list
List<Integer> ageList = list.stream().map(Student::getAge).collect(Collectors.toList()); // [10, 20, 10]

//转成set
Set<Integer> ageSet = list.stream().map(Student::getAge).collect(Collectors.toSet()); // [20, 10]

//转成map,注:key不能相同，否则报错
Map<String, Integer> studentMap = list.stream().collect(Collectors.toMap(Student::getName, Student::getAge)); // {cc=10, bb=20, aa=10}

//字符串分隔符连接
String joinName = list.stream().map(Student::getName).collect(Collectors.joining(",", "(", ")")); // (aa,bb,cc)

//聚合操作
//1.学生总数
Long count = list.stream().collect(Collectors.counting()); // 3
//2.最大年龄 (最小的minBy同理)
Integer maxAge = list.stream().map(Student::getAge).collect(Collectors.maxBy(Integer::compare)).get(); // 20
//3.所有人的年龄
Integer sumAge = list.stream().collect(Collectors.summingInt(Student::getAge)); // 40
//4.平均年龄
Double averageAge = list.stream().collect(Collectors.averagingDouble(Student::getAge)); // 13.333333333333334
// 带上以上所有方法
DoubleSummaryStatistics statistics = list.stream().collect(Collectors.summarizingDouble(Student::getAge));
System.out.println("count:" + statistics.getCount() + ",max:" + statistics.getMax() + ",sum:" + statistics.getSum() + ",average:" + statistics.getAverage());

//分组
Map<Integer, List<Student>> ageMap = list.stream().collect(Collectors.groupingBy(Student::getAge));
//多重分组,先根据类型分再根据年龄分
Map<Integer, Map<Integer, List<Student>>> typeAgeMap = list.stream().collect(Collectors.groupingBy(Student::getType, Collectors.groupingBy(Student::getAge)));

//分区
//分成两部分，一部分大于10岁，一部分小于等于10岁
Map<Boolean, List<Student>> partMap = list.stream().collect(Collectors.partitioningBy(v -> v.getAge() > 10));

//规约
Integer allAge = list.stream().map(Student::getAge).collect(Collectors.reducing(Integer::sum)).get(); //40
```

#### 3.3.2 Collectors.toList() 解析

```java
//toList 源码
public static <T> Collector<T, ?, List<T>> toList() {
    return new CollectorImpl<>((Supplier<List<T>>) ArrayList::new, List::add,
            (left, right) -> {
                left.addAll(right);
                return left;
            }, CH_ID);
}

//为了更好地理解，我们转化一下源码中的lambda表达式
public <T> Collector<T, ?, List<T>> toList() {
    Supplier<List<T>> supplier = () -> new ArrayList();
    BiConsumer<List<T>, T> accumulator = (list, t) -> list.add(t);
    BinaryOperator<List<T>> combiner = (list1, list2) -> {
        list1.addAll(list2);
        return list1;
    };
    Function<List<T>, List<T>> finisher = (list) -> list;
    Set<Collector.Characteristics> characteristics = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));

return new Collector<T, List<T>, List<T>>() {
    @Override
    public Supplier supplier() {
        return supplier;
    }

​    @Override
​    public BiConsumer accumulator() {
​        return accumulator;
​    }

​    @Override
​    public BinaryOperator combiner() {
​        return combiner;
​    }

​    @Override
​    public Function finisher() {
​        return finisher;
​    }

​    @Override
​    public Set<Characteristics> characteristics() {
​        return characteristics;
​    }
};

}
```



# optional

## 1.Optional对象创建

#### 1.1 empty

用于创建一个空的Optional对象；其value属性为Null。
如：

```java
Optional o = Optional.empty();
```

#### 1.2 of

根据传入的值构建一个Optional对象;
传入的值必须是非空值，否则如果传入的值为空值，则会抛出空指针异常。
使用：

```java
o = Optional.of("test"); 
```

#### 1.3 ofNullable

根据传入值构建一个Optional对象
		传入的值可以是空值，**如果传入的值是空值，则与empty返回的结果是一样的。**

## 2 .Optional方法

| 方法名          | 说明                                                         |
| --------------- | ------------------------------------------------------------ |
| get             | 获取Value的值，如果Value值是空值，则会抛出NoSuchElementException异常；因此返回的Value值无需再做空值判断，只要没有抛出异常，都会是非空值。 |
| isPresent       | Value是否为空值的判断；                                      |
| ifPresent       | 当Value不为空时，执行传入的Consumer；                        |
| ifPresentOrElse | Value不为空时，执行传入的Consumer；否则执行传入的Runnable对象； |
| filter          | 当Value为空或者传入的Predicate对象调用test(value)返回False时，返回Empty对象；否则返回当前的Optional对象 |
| map             | 一对一转换：当Value为空时返回Empty对象，否则返回传入的Function执行apply(value)后的结果组装的Optional对象； |
| flatMap         | 一对多转换：当Value为空时返回Empty对象，否则传入的Function执行apply(value)后返回的结果（其返回结果直接是Optional对象） |
| or              | 如果Value不为空，则返回当前的Optional对象；否则，返回传入的Supplier生成的Optional对象； |
| stream          | 如果Value为空，返回Stream对象的Empty值；否则返回Stream.of(value)的Stream对象； |
| orElse          | Value不为空则返回Value，否则返回传入的值；                   |
| orElseGet       | Value不为空则返回Value，否则返回传入的Supplier生成的值；     |
| orElseThrow     | Value不为空则返回Value，否则抛出Supplier中生成的异常对象；   |

















