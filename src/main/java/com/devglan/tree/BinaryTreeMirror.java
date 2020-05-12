package com.devglan.tree;

public class BinaryTreeMirror {

    public static BinaryTreeNode mirrorBinaryTree(BinaryTreeNode root){

        if (root == null){
            return null;
        }
        BinaryTreeNode left = mirrorBinaryTree(root.getLeftNode());
        BinaryTreeNode right = mirrorBinaryTree(root.getRightNode());
        root.setRightNode(left);
        root.setLeftNode(right);
        return root;
    }

    public static void inOrder(BinaryTreeNode root){
        if (root != null){
            inOrder(root.getLeftNode());
            System.out.print(root.getData() + " ");
            inOrder(root.getRightNode());
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(15);
        root.setLeftNode(new BinaryTreeNode(7));
        root.getLeftNode().setLeftNode(new BinaryTreeNode(5));
        root.getLeftNode().setRightNode(new BinaryTreeNode(10));
        root.getLeftNode().getRightNode().setLeftNode(new BinaryTreeNode(8));

        root.setRightNode(new BinaryTreeNode(30));
        root.getRightNode().setLeftNode(new BinaryTreeNode(25));
        root.getRightNode().setRightNode(new BinaryTreeNode(35));
        inOrder(root);
        System.out.println();
        BinaryTreeMirror.mirrorBinaryTree(root);
        inOrder(root);

    }
}
