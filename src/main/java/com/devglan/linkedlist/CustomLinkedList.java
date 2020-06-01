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
                System.out.print(currentNode.getData() + " ");
                currentNode = currentNode.getNextNode();
            }
            System.out.print(currentNode.getData());
        }
        System.out.println();
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

    Node node = null;

    public Node findSum(Node first, Node second){
        int length1 = findLength(first);
        int length2 = findLength(second);
        //assume both length > 0
        int diff = length1 - length2;
        int carry;
        if (diff < 0){
            carry = findSum(second, first, -diff);
            carry = findRestSum(second, carry, -diff);
        }else if (diff > 0){
            carry = findSum(first, second, diff);
            carry = findRestSum(first, carry, diff);
        }else {
            carry = findSum(first, second, diff);
        }
        if (carry > 0){
            Node currentNode = new Node(carry);
            currentNode.setNextNode(node);
            node = currentNode;
        }
        return node;
    }

    private int findSum(Node first, Node second, int diff){
        //assume diff = 0
        if (diff != 0){
            while (diff != 0){
                first = first.getNextNode();
                diff = diff - 1;
            }
        }
        if (first == null || second == null){
            return 0;
        }
        int c = findSum(first.getNextNode(), second.getNextNode(), diff);
        int sum = first.getData() + second.getData() + c;
        int carry = sum / 10;
        int value = sum % 10;
        Node currentNode = new Node(value);
        currentNode.setNextNode(node);
        node = currentNode;
        return carry;
    }

    private int findRestSum(Node first, int carry, int diff) {
        if (diff == 0){
            return carry;
        }
        int c = findRestSum(first.getNextNode(), carry, diff - 1);
        int sum = first.getData() + c;
        carry = sum / 10;
        int value = sum % 10;
        Node currentNode = new Node(value);
        currentNode.setNextNode(node);
        node = currentNode;
        return carry;
    }

    private int findLength(Node head) {
        Node node = head;
        int length = 0;
        while (node != null){
             length = length + 1;
             node = node.getNextNode();

        }
        return length;
    }

    public Node findIntersection(Node head1, Node head2){
        if (head1 == null || head2 == null){
            return null;
        }
        Node intersectionNode;
        int firstListLength = findLength(head1);
        int secondListLength = findLength(head2);
        if (firstListLength == secondListLength){
            intersectionNode = findIntersectionOfEqualSizeList(head1, head2);
        }else {
            if (firstListLength > secondListLength){
                Node temp = head1;
                int diff = firstListLength - secondListLength;
                while (diff != 0){
                    temp = temp.getNextNode();
                    diff = diff - 1;
                }
                intersectionNode = findIntersectionOfEqualSizeList(temp, head2);
            }else {
                Node temp = head2;
                int diff = secondListLength - firstListLength;
                while (diff != 0){
                    temp = head2.getNextNode();
                    diff = diff - 1;
                }
                intersectionNode = findIntersectionOfEqualSizeList(head1, temp);
            }
        }
        return intersectionNode;
    }
    
    private Node findIntersectionOfEqualSizeList(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null && temp2 != null){
            if (temp1.getData() == temp2.getData()){
                return temp1;
            }
            temp1 = temp1.getNextNode();
            temp2 = temp2.getNextNode();
        }
        return null;
    }

    public Node get(){
        return this.head;
    }
}
