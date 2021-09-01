package com.company;


class Student {
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
}
