package com.devglan.lambda;

@FunctionalInterface
public interface OperateInterface {

    int operate(int x, int y);

    default void addMessage(){
        System.out.println("Perform addition");
    }

    default void subtractMessage(){
        System.out.println("Perform subtraction");
    }
}
