package com.devglan.tree;

import java.util.*;

public class BinarySearchTree {

    public BSTNode insert(BSTNode node, int data) {
        if(node == null) {
            node = new BSTNode(data);
        }else {
            if(data < node.getData()){
                node.setLeft(insert(node.getLeft(), data));
            }else if(data > node.getData()){
                node.setRight(insert(node.getRight(), data));
            }
        }
        return node;
    }

    public BSTNode search(BSTNode root, int data){
        if(root == null){
            return null;
        }
        while (root != null){
            if(data == root.getData()){
                return root;
            }else if(data > root.getData()){
                root = root.getRight();
            }else {
                root = root.getLeft();
            }
        }
        return null;
    }

    public BSTNode findMin(BSTNode root){
        if(root == null){
            return null;
        }
        while (root.getLeft() != null){
            root = root.getLeft();
        }
        return root;
    }

    public BSTNode findMax(BSTNode root){
        if(root == null){
            return null;
        }
        while (root.getRight() != null){
            root = root.getRight();
        }
        return root;
    }

    public void preOrder(BSTNode root){
        if(root != null){
            System.out.print(root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public List<Integer> preOrderNonRecursive(BSTNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<BSTNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()){
            BSTNode node = s.pop();
            result.add(node.getData());
            if(node.getRight() != null){
                s.push(node.getRight());
            }
            if(node.getLeft() != null){
                s.push(node.getLeft());
            }
        }
        return result;
    }

    public void inOrder(BSTNode root){
        if(root != null){
            inOrder(root.getLeft());
            System.out.print(root.getData());
            inOrder(root.getRight());
        }
    }

    public void postOrder(BSTNode root){
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    public List<Integer> leftView(BSTNode root){
        List<Integer> leftView = new ArrayList<>();
        leftView.add(root.getData());
        Stack<BSTNode> stack = new Stack<>();
        stack.push(root.getRight());
        stack.push(root.getLeft());
        while (!stack.isEmpty()){

        }
        BSTNode node = root;
        while (node != null){
            if(node.getLeft() != null){
                leftView.add(node.getLeft().getData());
                node = node.getLeft();
            }else if(node.getRight() != null){
                leftView.add(node.getRight().getData());
                node = node.getRight();
            }
        }
    return null;
    }


}
