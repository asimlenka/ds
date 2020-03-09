package com.devglan.stack;

import com.devglan.linkedlist.Node;

public class CustomStack {

    int length = 0;
    Node top = null;


    public CustomStack(){
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.setNextNode(top);
        top = newNode;
        length++;
    }

    public int pop() {
        if(isEmpty()){
            throw new RuntimeException("dfvf");
        }
        Node node = top;
        top = top.getNextNode();
        length--;
        return node.getData();
    }

    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }
}
