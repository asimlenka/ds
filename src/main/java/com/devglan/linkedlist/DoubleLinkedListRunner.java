package com.devglan.linkedlist;

public class DoubleLinkedListRunner {

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.insert(3);
        doubleLinkedList.insert(9);
        doubleLinkedList.insert(40);
        doubleLinkedList.insert(17);
        doubleLinkedList.insert(91);
        doubleLinkedList.insertAtTail(4);
        doubleLinkedList.insertAt(1, 33);
        System.out.println("Print the list");
        doubleLinkedList.traverse();
        System.out.println("Deleting head");
        doubleLinkedList.deleteHead();
        System.out.println("Print the list after deleting head.");
        doubleLinkedList.traverse();

        System.out.println("Deleting tail");
        doubleLinkedList.deleteTail();
        System.out.println("Print the list after deleting tail.");
        doubleLinkedList.traverse();

        System.out.println("Deleting from position 3");
        doubleLinkedList.deleteAt(2);
        System.out.println("Print the list after deleting at position 3.");
        doubleLinkedList.traverse();
    }
}
