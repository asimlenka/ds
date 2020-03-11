package com.devglan.tree;

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

}
