package com.devglan.practise;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NextBiggestTime {

    public static String find(String time){
        List<Integer> list = Stream.of(time.split(":")).map(t -> Integer.valueOf(t)).collect(Collectors.toList());
        List<Integer> digits = new ArrayList<>();
        list.forEach(t ->{
            digits.add(t/10);
            digits.add(t % 10);
        });
        String result = "";
        Integer hour = createHour(digits);
        Integer minute = createMinute(digits);
        return null;
    }

    private static Integer createMinute(List<Integer> digits) {
        return 0;
    }

    private static Integer createHour(List<Integer> digits) {
        String hour = "";
       for(int i = 2; i >=0; i--){
           if(checkIfDigitExists(i, digits)){
                hour.concat("" + i);
                digits.remove(i);
                break;
           }
       }
       if(hour.equalsIgnoreCase("2")) {
           for (int i = 4; i >= 0; i--) {
               if (checkIfDigitExists(i, digits)) {
                   hour.concat("" + i);
                   digits.remove(i);
                   break;
               }
           }
       }else {
           for (int i = 9; i >= 0; i--) {
               if (checkIfDigitExists(i, digits)) {
                   hour.concat("" + i);
                   digits.remove(i);
                   break;
               }
           }
       }
       return Integer.valueOf(hour);
    }

    private static boolean checkIfDigitExists(int digit, List<Integer> digits){
        return digits.contains(digit);
    }

    public static void main(String[] args){
        NextBiggestTime.find("12:34:55");
    }
}
