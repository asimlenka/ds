package com.devglan.tree;

public class BSTCheck {

    public static void checkBST(BinaryTreeNode root){
        boolean isBst = checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("is BST : " + isBst);
    }

    private static boolean checkBST(BinaryTreeNode root, int minValue, int maxValue) {
        if (root == null){
            return true;
        }
        if (root.getData() > maxValue || root.getData() < minValue){
            return false;
        }
        return checkBST(root.getLeftNode(), minValue, root.getData())
                && checkBST(root.getRightNode(), root.getData(), maxValue);
    }

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();

        BinaryTreeNode root = new BinaryTreeNode(15);
        tree.root = root;
        root.setLeftNode(new BinaryTreeNode(7));
        root.getLeftNode().setLeftNode(new BinaryTreeNode(5));
        root.getLeftNode().setRightNode(new BinaryTreeNode(10));
        root.getLeftNode().getRightNode().setLeftNode(new BinaryTreeNode(8));

        root.setRightNode(new BinaryTreeNode(30));
        root.getRightNode().setLeftNode(new BinaryTreeNode(25));
        root.getRightNode().setRightNode(new BinaryTreeNode(35));
        BSTCheck.checkBST(root);
    }
}
