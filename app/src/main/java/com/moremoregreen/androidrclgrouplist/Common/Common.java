package com.moremoregreen.androidrclgrouplist.Common;

import com.moremoregreen.androidrclgrouplist.Model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Common {
    public static final int VIEWTYPE_GROUP = 0;
    public static final int VIEWTYPE_PERSON = 1;
    public static final int RESULT_CODE = 1000;
    public static List<String> alphabet_available = new ArrayList<>();


    //依靠alphabet排列人名
    public static ArrayList<Person> sortList(ArrayList<Person> people) {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return person.getName().compareTo(t1.getName());
            }
        });
        return people;
    }

    //排列之後，把字母加到list
    public static ArrayList<Person> addAlphabets(ArrayList<Person> list) {
        int i =0;
        ArrayList<Person> customList = new ArrayList<>();
        Person firstPosition = new Person();
        firstPosition.setName(String.valueOf(list.get(0).getName().charAt(0)));
        firstPosition.setViewType(VIEWTYPE_GROUP);
        alphabet_available.add(String.valueOf(list.get(0).getName().charAt(0)));  //把第一個字母加到Group header list
        customList.add(firstPosition);

        for ( i = 0; i < list.size()-1; i++) {
            Person person = new Person();
            char name1 = list.get(i).getName().charAt(0);//取得名字中第一個字
            char name2 = list.get(i + 1).getName().charAt(0);
            if (name1 == name2) {
                list.get(i).setViewType(VIEWTYPE_PERSON);
                customList.add(list.get(i));
            } else {
                list.get(i).setViewType(VIEWTYPE_PERSON);
                customList.add(list.get(i));
                person.setName(String.valueOf(name2));
                person.setViewType(VIEWTYPE_GROUP);
                alphabet_available.add(String.valueOf(name2));
                customList.add(person);
            }

        }
        list.get(i).setViewType(VIEWTYPE_PERSON);
        customList.add(list.get(i));
        return customList;

    }


    //Return position of string in list
    public static int findPositionWithName(String name, ArrayList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name))
                return i;
        }
        return -1; //-1 if not found
    }

    //產生字母表
    public static ArrayList<String> genAlphabet() {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 65; i <= 90; i++) {
            char character = (char)i;
            result.add(String.valueOf(character));
        }
        return result;
    }

    //Create an person group with random name
    public static ArrayList<Person> genPeopleGroup() {
        ArrayList<Person> personList = new ArrayList<>();

        Person person = new Person("Andy","Doctor",-1);
        personList.add(person);
        person = new Person("Andy","Staff",-1);
        personList.add(person);
        person = new Person("Betty","Staff",-1);
        personList.add(person);
        person = new Person("Christina","Staff",-1);
        personList.add(person);
        person = new Person("David","Staff",-1);
        personList.add(person);
        person = new Person("Eason","Staff",-1);
        personList.add(person);
        person = new Person("Fred","Staff",-1);
        personList.add(person);
        person = new Person("Good","Staff",-1);
        personList.add(person);
        person = new Person("Hitech","Staff",-1);
        personList.add(person);
        person = new Person("Int","Staff",-1);
        personList.add(person);
        person = new Person("Jocky","Staff",-1);
        personList.add(person);
        person = new Person("Layout","Staff",-1);
        personList.add(person);
        person = new Person("Manager","Staff",-1);
        personList.add(person);
        person = new Person("Nicole","Staff",-1);
        personList.add(person);
        person = new Person("Orange","Staff",-1);
        personList.add(person);
        person = new Person("Pen","Staff",-1);
        personList.add(person);
        person = new Person("Quiz","Staff",-1);
        personList.add(person);
        person = new Person("Return","Staff",-1);
        personList.add(person);
        person = new Person("Snap","Staff",-1);
        personList.add(person);
        person = new Person("Turtle","Staff",-1);
        personList.add(person);
        person = new Person("Unit","Staff",-1);
        personList.add(person);
        person = new Person("Victory","Staff",-1);
        personList.add(person);
        person = new Person("Water","Staff",-1);
        personList.add(person);
        person = new Person("Xerath","Staff",-1);
        personList.add(person);
        person = new Person("Yesterday","Staff",-1);
        personList.add(person);
        person = new Person("Zebra","Staff",-1);
        personList.add(person);
        person = new Person("Zoo","Staff",-1);
        personList.add(person);

        return personList;
    }
}
