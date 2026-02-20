package com.capgemini.junit;

public class Student {

    private int id;
    private String name;
    private int age;

    private int mark1;
    private int mark2;
    private int mark3;


    public Student(int id, String name, int age,
                   int mark1, int mark2, int mark3) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    public int getMark1() {
        return mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public int getMark3() {
        return mark3;
    }
}
