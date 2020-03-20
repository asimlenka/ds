package com.devglan.practise;

import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SentenceReverse {

    public String sentenceReverse(String s1){
        String[] array = s1.split(" ");
        System.out.println(s1);
        int arrayLength = array.length;
        String[] output = new String[arrayLength];
        for(int i = 0; i<=array.length/2; i++){
            output[i] = array[arrayLength - 1 - i];
            output[arrayLength -1 -i] = array[i];
        }
        String reversedString = Stream.of(output).collect(Collectors.joining(" "));
        System.out.println(reversedString);
        return reversedString;
    }

    public String reverse(String reverse){
        System.out.println(reverse);
        String result = "";
        String[] array = reverse.split(" ");
        Stack<String> stack = new Stack<>();
        for(int i= 0; i< array.length; i++){
            stack.push(array[i]);
        }
        while (!stack.empty()) {
            String s = stack.pop();
            System.out.print(s + " ");
            result.concat(s + " ");
        }
        System.out.println("");
        return result;
    }

    public static void main(String[] args){
        SentenceReverse reverse = new SentenceReverse();
        reverse.reverse("Hello World gsdgsd and shyam");
        reverse.sentenceReverse("Hello World gsdgsd and shyam");
    }
}
