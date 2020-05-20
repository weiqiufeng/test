package com.wqf.parentproject1;

import com.wqf.stream.Student;
import com.wqf.stream.StudentData;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class ParentProject1ApplicationTests {

    @Test
    void contextLoads() {
//        List<Student> list = StudentData.getStudents();
//        System.out.println(list.stream().map(e->e.getAge()).collect(Collectors.toList()));
//       String s = new String();
//       s.equals("1");
//
//        HashMap<String,String> hashMap = new HashMap<>();
//        hashMap.put("1","1");
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("123","124");

        Set set = new TreeSet();
        set.add(2);

        ArrayList list = new ArrayList();
        list.add(2);
    }

}
