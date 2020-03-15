package com.devglan.linkedlist;

public class DoubleLinkedList {

    private DLLNode head;
    private DLLNode tail;
    private int length;

    public DoubleLinkedList(){
    }

    public void insert(int data){
        DLLNode nodeToBeInserted = new DLLNode(data);
        if(head == null){
            tail = nodeToBeInserted;
        }else {
            head.setPrev(nodeToBeInserted);
        }
        nodeToBeInserted.setNext(head);
        head = nodeToBeInserted;
        length++;
    }

    public void insertAtTail(int data){
        DLLNode nodeToBeInserted = new DLLNode(data);
        tail.setNext(nodeToBeInserted);
        nodeToBeInserted.setPrev(tail);
        this.tail = nodeToBeInserted;
    }

    public void insertAt(int position, int data){
        DLLNode nodeToBeInserted = new DLLNode(data);
        DLLNode temp = head;
        for(int i = 0; i < position; i++){
            temp = temp.getNext();
        }
        nodeToBeInserted.setPrev(temp);
        nodeToBeInserted.setNext(temp.getNext());
        temp.setNext(nodeToBeInserted);
        nodeToBeInserted.getNext().setPrev(nodeToBeInserted);
    }

    public void deleteHead(){
        DLLNode temp = head;
        this.head = temp.getNext();
        this.head.setPrev(null);
    }

    public void deleteTail(){
        DLLNode previous = tail.getPrev();
        previous.setNext(null);
        this.tail = previous;
    }

    public void deleteAt(int position){
        DLLNode temp = head;
        for(int i = 0; i < position; i++){
            temp = temp.getNext();
        }
        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());
    }

    public void traverse(){
        StringBuilder result = new StringBuilder("[");
        DLLNode temp = head;
        while (temp.getNext() != null){
            result.append(temp.getData() + ", ");
            temp = temp.getNext();
        }
        result.append(temp.getData() + "]");
        System.out.println(result.toString());
    }
}
