package com.streams_api;

public class Person {
    private final String name;
    private final int age;
    private final Gender gender;
    private final String dept;

    public Person(String name, int age, Gender gender, String dept) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return "Person{"
                + "name='" + name + "\""
                + ", age=" + age
                + ", gender=" + gender
                + "}";
    }
}
