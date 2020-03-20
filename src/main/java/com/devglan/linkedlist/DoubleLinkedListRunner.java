package com.devglan.linkedlist;

public class DoubleLinkedListRunner {

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.insertHead(3);
        doubleLinkedList.insertHead(9);
        doubleLinkedList.insertHead(40);
        doubleLinkedList.insertHead(17);
        doubleLinkedList.insertHead(91);
        doubleLinkedList.insertTail(4);
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
