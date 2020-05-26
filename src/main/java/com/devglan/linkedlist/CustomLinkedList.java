package com.devglan.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CustomLinkedList {

    Node head;

    public CustomLinkedList(){
    }

    public Node insert(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            head = newNode;
        }else {
            Node currentNode = head;
            while(currentNode.getNextNode() != null){
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
        return head;
    }

    public void insertAt(int index, int data){
        Node nodeToBeInserted = new Node(data);
        Node node = head;
        for(int i = 0; i< index -1; i++){
            node = node.getNextNode();
        }
        nodeToBeInserted.setNextNode(node.getNextNode());
        node.setNextNode(nodeToBeInserted);
    }

    public void deleteNodeAt(int index){
        Node node = head;
        for(int i = 0; i< index -1; i++){
            node = node.getNextNode();
        }
        node.setNextNode(node.getNextNode().getNextNode());
    }

    public void insertHead(int data){
        Node newNode = new Node(data);
        newNode.setNextNode(head);
        head = newNode;
    }

    public void display(){
        if(head != null){
            Node currentNode = head;
            while(currentNode.getNextNode() != null){
                System.out.println(currentNode.getData());
                currentNode = currentNode.getNextNode();
            }
            System.out.println(currentNode.getData());
        }
    }

    public Node reverse(){
        Node previous = null;
        Node current = head;
        Node next;
        while (current != null){
            next = current.getNextNode();
            current.setNextNode(previous);
            previous = current;
            current = next;
        }
        this.head = previous;
        return previous;
    }

    public void reverseRecursively(){
        reverseRecursively(head);
    }

    public Node reverseRecursively(Node current){
        if (current == null){
            return null;
        }
        if (current.getNextNode() == null){
            this.head= current;
            return current;
        }
        Node node = reverseRecursively(current.getNextNode());
        current.getNextNode().setNextNode(current);
        current.setNextNode(null);
        return node;
    }

    public Node checkLoop(){
        boolean loopExists = false;
        Node slowPointer = head;
        Node fastPointer = head;
        while (slowPointer != null && fastPointer != null && fastPointer.getNextNode() != null){
            slowPointer = slowPointer.getNextNode();
            fastPointer = fastPointer.getNextNode().getNextNode();
            if (slowPointer == fastPointer){
                loopExists = true;
                break;
            }
        }
        if (loopExists) {
            return slowPointer;
        }else {
            return null;
        }
    }

    public void removeLoop(){
        Node loopNode = checkLoop();
        Node currentNode = head;
        while (currentNode.getNextNode() != loopNode){
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(null);
    }

    public Node get(){
        return this.head;
    }
}
