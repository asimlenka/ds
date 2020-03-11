package com.devglan.tree;

public class TreeRunner {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        BSTNode root = null;

        root = bst.insert(root, 10);
        root = bst.insert(root, 6);
        root = bst.insert(root, 4);
        root = bst.insert(root, 9);
        root = bst.insert(root, 7);
        root = bst.insert(root, 16);
        root = bst.insert(root, 13);

        BSTNode result = bst.search(root, 13);
        System.out.println(result.getData());
        System.out.println(bst.findMin(root).getData());
    }
}
