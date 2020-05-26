package com.devglan.linkedlist;

public class LinkedListRunner {

    public static void main(String [] args){
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.insert(5);
        customLinkedList.insert(10);
        customLinkedList.insert(15);
        customLinkedList.insert(20);

        customLinkedList.display();

        System.out.println("Going to reverse the list");
        customLinkedList.reverseRecursively();
        customLinkedList.display();
    }
}
