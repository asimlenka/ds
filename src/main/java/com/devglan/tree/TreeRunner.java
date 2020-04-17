package com.devglan.tree;

public class TreeRunner {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        BSTNode root = null;

        root = bst.insert(root, 10);
        root = bst.insert(root, 8);
        root = bst.insert(root, 9);
        root = bst.insert(root, 12);
        root = bst.insert(root, 11);
        root = bst.insert(root, 13);
        root = bst.insert(root, 3);

        //BSTNode result = bst.search(root, 9);
        //System.out.println(result.getData());
        //System.out.println(bst.findMin(root).getData());
        //bst.preOrder(root);
        //System.out.println();
        //bst.levelOrderTraversal(root);
        bst.levelOrderTraversalWithLevel(root);
    }
}
