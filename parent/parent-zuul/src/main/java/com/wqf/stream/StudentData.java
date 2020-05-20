package com.wqf.stream;


import java.util.ArrayList;
import java.util.List;

/**
 * @Desc
 * @Author weiqiufeng
 * @Date 2020-05-11
 **/
public class StudentData {

    public static List<Student> getStudents(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"刘备",18,90.4));
        list.add(new Student(1,"张飞",19,87.4));
        list.add(new Student(1,"关羽",21,67.4));
        list.add(new Student(1,"赵云",15,89.4));
        list.add(new Student(1,"马超",16,91.4));
        list.add(new Student(1,"曹操",19,83.4));
        list.add(new Student(1,"荀彧",24,78.4));
        list.add(new Student(1,"孙权",26,79.4));
        list.add(new Student(1,"鲁肃",21,93.4));
        return  list;
    }
}
