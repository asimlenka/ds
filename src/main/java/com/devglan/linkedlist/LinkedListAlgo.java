package com.devglan.linkedlist;

public class LinkedListAlgo {

    private CustomLinkedList customLinkedList;

    public LinkedListAlgo(CustomLinkedList linkedList){
        this.customLinkedList = linkedList;
    }

    public Node findMiddle(){
        Node head = customLinkedList.get();
        Node slowPointer = head;
        Node fastPointer = head;
        if(head != null){
            while (fastPointer != null && fastPointer.getNextNode() != null){
                slowPointer = slowPointer.getNextNode();
                fastPointer = fastPointer.getNextNode().getNextNode();
            }
        }
        return slowPointer;
    }

    public void deleteMiddleNode(){
        Node middleNode = findMiddle();
        middleNode.setNextNode(middleNode.getNextNode().getNextNode());
    }

    //Floyd’s Cycle-Finding Algorithm
    public Node findLoop(){
        Node head = customLinkedList.get();
        Node slowPointer = head;
        Node fastPointer = head;
        if(head != null){
            while (slowPointer != null && fastPointer != null && fastPointer.getNextNode() != null){
                slowPointer = slowPointer.getNextNode();
                fastPointer = fastPointer.getNextNode().getNextNode();
                if(slowPointer == fastPointer){
                    return slowPointer;
                }
            }
        }
        return null;
    }

    /*Why increase pointer by two while finding loop in linked list, why not 3,4,5?
    So, the condition here is you cannot change the speed of ptr1, it has to move one node at a time.
    but the choice for ptr2 to move can be 2 nodes at a time, 3 nodes at a time or any number of nodes at a time.

    More the gap in which both pointers move forward, more the time they might take in worst case to meet.
    So the lowest possible iteration in which we can find their meeting points is by moving ptr2 two nodes at a time.*/
    public Node removeLoop(){
        Node head = customLinkedList.get();
        Node slowPointer = head;
        Node fastPointer = head;
        if(head != null){
            while (slowPointer != null && fastPointer != null && fastPointer.getNextNode() != null){
                slowPointer = slowPointer.getNextNode();
                fastPointer = fastPointer.getNextNode().getNextNode();
                if(slowPointer == fastPointer){
                    fastPointer.setNextNode(null);
                }
            }
        }
        return null;
    }

}
