package com.devglan.array;

import java.util.ArrayList;
import java.util.List;

public class PossibleString {

    public static List<String> generateAllPossibleSubString(String input){
        input.toCharArray();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++){
            for (int j = i+1; j <= input.length(); j++){
                result.add(input.substring(i, j));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PossibleString.generateAllPossibleSubString("rama");
    }
}
