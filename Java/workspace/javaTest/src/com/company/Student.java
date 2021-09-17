package com.company;


class Student implements Comparable<Student>,Cloneable{
    private int no;
    private String name;
    private int classs;


    public Student(int no, String name, int classs) {
        this.no = no;
        this.name = name;
        this.classs = classs;
    }

    public Student() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClasss() {
        return classs;
    }

    public void setClasss(int classs) {
        this.classs = classs;
    }

    @Override
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

    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }

}
