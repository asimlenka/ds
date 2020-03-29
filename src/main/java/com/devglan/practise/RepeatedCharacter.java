package com.devglan.practise;

import java.util.*;

public class RepeatedCharacter {

    public static void main(String [] args){
        String s1 = "dhhhirajkjhrtyiiii";
        char[] array = s1.toCharArray();
        Map<Character, Integer> map = new TreeMap<>();
        for(int i = 0; i < array.length; i++){
            if(map.get(array[i]) == null){
                map.put(array[i], 1);
            }else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        map.entrySet().stream().forEach(entry ->{
            System.out.print(entry.getKey() + "  "+ entry.getValue());
            System.out.println();
        });
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2){
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });
        System.out.println("*********************************************");
        Map<Character, Integer> map1 = new LinkedHashMap<>();
        list.stream().forEach(l ->{
            map1.put(l.getKey(), l.getValue());
        });
        map1.entrySet().stream().forEach(entry ->{
            System.out.print(entry.getKey() + "  "+ entry.getValue());
            System.out.println();
        });
        System.out.println(list.get(0).getKey());
       /* list.stream().forEach(l ->{
            System.out.println(l.getKey() + " "+ l.getValue());
        });*/

       for(Map.Entry<Character, Integer> m: map.entrySet()){
           System.out.println(m.getKey());
       }
    }
}
