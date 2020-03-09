package com.devglan.hashmap;

public class HashMapRunner {

    public static void main(String[] args){
        CustomHashMap<Integer, String> map = new CustomHashMap<Integer, String>();
        map.put(1, "ETC");
        map.put(2, "John");
        map.put(null, "Nothing");
        map.display();
        map.remove(2);
        map.display();
        map.put(1, "CSE");
        map.put(17, "CS");
        map.display();
        map.put(2, "John again");
    }
}
