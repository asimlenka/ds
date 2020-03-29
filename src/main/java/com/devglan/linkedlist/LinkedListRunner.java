package com.devglan.linkedlist;

public class LinkedListRunner {

    public static void main(String [] args){
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.insert(5);
        customLinkedList.insert(10);
        customLinkedList.insert(15);
        customLinkedList.insert(20);
        customLinkedList.display();
        customLinkedList.insertAt(2, 100);
        System.out.println("********");
        customLinkedList.display();
        System.out.println("********");
        customLinkedList.deleteNodeAt(2);
        customLinkedList.display();
        System.out.println("********");
        customLinkedList.insertHead(50);
        customLinkedList.display();
    }
}
