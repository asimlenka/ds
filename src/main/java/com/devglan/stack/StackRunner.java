package com.devglan.stack;

public class StackRunner {

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack();
        //customStack.pop();
        customStack.push(5);
        customStack.push(10);
        System.out.println(customStack.pop());
        System.out.println(customStack.size());
    }
}
