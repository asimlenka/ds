package com.devglan.tree;

public class NodeCount {

    public static int countNodes(BinaryTreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + countNodes(root.getLeftNode()) + countNodes(root.getRightNode());
    }
}
