package com.devglan.linkedlist;

public class CircularLinkedList {

    private Node head;
    private Node tail;

    public void insert(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
        }else {
            tail.setNextNode(newNode);
        }
        tail = newNode;
        tail.setNextNode(head);
    }

    public boolean search(int data){
        if (head == null){
            return false;
        }else {
            Node currentNode = head;
            while (currentNode.getNextNode() != head){
                if (currentNode.getData() == data){
                    return true;
                }
                currentNode = currentNode.getNextNode();
            }
        }
        return false;
    }

    public void delete(int data){
        Node currentNode = head;
        if (head != null){
            if (currentNode.getData() == data){
                head = currentNode.getNextNode();
                tail.setNextNode(head);
            }else {
                while(currentNode.getNextNode() != head){
                    if (currentNode.getNextNode().getData() == data){
                        currentNode.setNextNode(currentNode.getNextNode().getNextNode());
                        break;
                    }
                    currentNode = currentNode.getNextNode();
                }
            }
        }
    }

    public void traverse(){
        if (head != null){
            Node currentNode = head;
            while (currentNode.getNextNode() != head){
                System.out.print(currentNode.getData() + " ");
                currentNode = currentNode.getNextNode();
            }
        }
        System.out.print(tail.getData());
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.insert(5);
        circularLinkedList.insert(10);
        circularLinkedList.insert(15);
        circularLinkedList.insert(20);
        circularLinkedList.insert(25);
        circularLinkedList.insert(30);

        System.out.println("Going to traverse the list");
        circularLinkedList.traverse();
        System.out.println();

        System.out.println("Delete 15 from the list");
        circularLinkedList.delete(15);

        System.out.println("Going to traverse the list after deletion ");
        circularLinkedList.traverse();
        System.out.println();

        System.out.println("Going to search 20 in the list");
        System.out.print(circularLinkedList.search(20));
    }

}
