package com.devglan.array;

import java.util.ArrayList;
import java.util.List;

public class PossibleString {

    private final String s = "a";

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

    public static void generateAllPossibleSubStringRec(String input){

        t("", input);

    }

    private static void t(String perm, String input){
        System.out.println(perm);
        if (perm.length() == input.length()){
            return;
        }
        for (int i = 0; i < input.length(); i++){
            t(perm + input.charAt(i), input.substring(0, i) + input.substring(i, input.length() - 1));
        }
    }

    public static void main(String[] args) {
        PossibleString.generateAllPossibleSubString("rama");
        PossibleString.generateAllPossibleSubStringRec("ramu");
    }
}
