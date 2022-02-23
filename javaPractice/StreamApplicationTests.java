package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {

    public List<Person> personList = new ArrayList<Person>();
    //personList.add(new Person("짱구",23,"010-1234-1234"));
    //personList.add(new Person("유리",24,"010-2341-2341"));
    //personList.add(new Person("철수",29,"010-3412-3412"));
    //personList.add(new Person("맹구",25,null));

    @DisplayName("streamTest1입니다.")
    @Test
    void streamTest1(){


        //Map<String, Integer> personMap = personList.stream().collect(Collectors.toMap(Person::getName,Person::getAge));
        //1. stream으로 이름과 전화 번호를 출력하라(null check)
        //2. stream으로 이름과 요소 전체를 출력하라
        //3. stream으로 나이가 25이상만 출력하라
        //4. stream으로 이름이 짱구만 출력하라
        //5. stream으로 상위 1개만 출력하라
        //6. stream으로 정렬하라
        //7.
        personList.add(new Person("짱구",23,"010-1234-1234"));
        //personList.add(new Person("유리",24,"010-2341-2341"));
        //personList.add(new Person("철수",29,"010-3412-3412"));
        //personList.add(new Person("맹구",25,null));
        //Map<String, String> personMap = personList.stream().collect(Collectors.toMap(Person::getName,Person::getPhoneNumber));
        Map<String,Object> personMap2 = personList.stream().collect(Collectors.toMap(Person::getName,Function.identity()));
        System.out.println(personMap2);


    }

    @DisplayName("스트림으로 나이가 25이상만 출력.")
    @Test
    void streamTest2(){
        personList.add(new Person("짱구",23,"010-1234-1234"));
        personList.add(new Person("유리",24,"010-2341-2341"));
        personList.add(new Person("철수",29,"010-3412-3412"));
        personList.add(new Person("맹구",25,null));
        Map<String,Person> personMap2 = personList.stream().filter(person->person.getAge()>25).collect(Collectors.toMap(Person::getName, Function.identity()));
        System.out.println(personMap2);
    }

    @DisplayName("스트림으로 이름이 짱구인 사람만 출력.")
    @Test
    void streamTest3(){
        personList.add(new Person("짱구",23,"010-1234-1234"));
        personList.add(new Person("유리",24,"010-2341-2341"));
        personList.add(new Person("철수",29,"010-3412-3412"));
        personList.add(new Person("맹구",25,null));

        Map<String,String> personMap2 = personList.stream().filter(person->"짱구".equals(person.getName())).collect(Collectors.toMap(Person::getName,Person::getPhoneNumber));
        System.out.println(personMap2);
    }

    @DisplayName("상위1개만 출력")
    @Test
    void streamTest4(){
        personList.add(new Person("짱구",23,"010-1234-1234"));
        personList.add(new Person("유리",24,"010-2341-2341"));
        personList.add(new Person("철수",29,"010-3412-3412"));
        personList.add(new Person("맹구",25,null));

        Map<String,String> personMap3 = personList.stream().limit(1).collect(Collectors.toMap(Person::getName,Person::getPhoneNumber));
        System.out.println(personMap3);
    }

    @DisplayName("정렬")
    @Test
    void streamTest5(){
        personList.add(new Person("짱구",23,"010-1234-1234"));
        personList.add(new Person("유리",24,"010-2341-2341"));
        personList.add(new Person("철수",29,"010-3412-3412"));
        personList.add(new Person("맹구",25,null));

        Map<String,String> personMap3 = personList.stream().collect(Collectors.toMap(Person::getName,Person::getPhoneNumber));
        System.out.println(personMap3);
    }

    @DisplayName("리듀스")
    @Test
    void streamTest6(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(6);
        list.add(7);

        Integer personMap3 = list.stream().mapToInt(x -> x).sum();
        System.out.println(personMap3);
    }

    @DisplayName("정렬")
    @Test
    void streamTest7(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("짱구", 25, "010-1234-1234"));
        personList.add(new Person("유리", 24, "010-2341-2341"));
        personList.add(new Person("맹구", 23, "010-3412-3412"));
        personList.add(new Person("훈이", 26, "010-4123-4123"));

        // 맹구, 유리, 짱구, 훈이
        personList.stream()
                .sorted(Comparator.comparing(Person::getAge));

        System.out.println(personList);//
    }

}
