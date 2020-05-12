package com.devglan.tree;

import java.util.ArrayList;
import java.util.List;

public class SubtreeCheck {

    public static boolean checkSubtree(BinaryTreeNode root, BinaryTreeNode subtree){
        if (subtree == null){
            return true;
        }
        if (root == null){
            return false;
        }
        List<Integer> rootInOrderList = new ArrayList<>();
        List<Integer> rootPreOrderList = new ArrayList<>();

        List<Integer> subtreeInOrderList = new ArrayList<>();
        List<Integer> subTreePreOrderList = new ArrayList<>();
        
        inOrderTraversal(root, rootInOrderList);
        preOrderTraversal(root, rootPreOrderList);

        inOrderTraversal(subtree, subtreeInOrderList);
        preOrderTraversal(subtree, subTreePreOrderList);

        String mainTreeInOrder = convertToString(rootInOrderList);
        String mainTreePreOrder = convertToString(rootPreOrderList);

        String subTreeInOrder = convertToString(subtreeInOrderList);
        String subTreePreOrder = convertToString(subTreePreOrderList);

        System.out.println(mainTreeInOrder);
        System.out.println(mainTreePreOrder);

        System.out.println(subTreeInOrder);
        System.out.println(subTreePreOrder);

        boolean subTree = mainTreeInOrder.contains(subTreeInOrder) && mainTreePreOrder.contains(subTreePreOrder);
        System.out.println("Is given tree a subtree " + subTree);
        return subTree;
    }

    private static String convertToString(List<Integer> rootPreOrder) {
        StringBuilder result = new StringBuilder();
        rootPreOrder.stream().forEach(data -> result.append(data));
        return result.toString();
    }

    private static void preOrderTraversal(BinaryTreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.getData());
            preOrderTraversal(node.getLeftNode(), list);
            preOrderTraversal(node.getRightNode(), list);
        }
    }

    private static void inOrderTraversal(BinaryTreeNode node, List<Integer> list) {
        if (node != null) {
            inOrderTraversal(node.getLeftNode(), list);
            list.add(node.getData());
            inOrderTraversal(node.getRightNode(), list);
        }
    }

    public static void main(String[] args){

        BinaryTreeNode main = new BinaryTreeNode(15);
        main.setLeftNode(new BinaryTreeNode(7));
        main.getLeftNode().setLeftNode(new BinaryTreeNode(5));
        main.getLeftNode().setRightNode(new BinaryTreeNode(10));
        main.getLeftNode().getRightNode().setLeftNode(new BinaryTreeNode(8));

        main.setRightNode(new BinaryTreeNode(30));
        main.getRightNode().setLeftNode(new BinaryTreeNode(25));
        main.getRightNode().setRightNode(new BinaryTreeNode(35));


        BinaryTreeNode subTree = new BinaryTreeNode(15);
        subTree.setLeftNode(new BinaryTreeNode(7));
        subTree.getLeftNode().setLeftNode(new BinaryTreeNode(5));
        subTree.getLeftNode().setRightNode(new BinaryTreeNode(10));
        subTree.getLeftNode().getRightNode().setLeftNode(new BinaryTreeNode(8));

        SubtreeCheck.checkSubtree(main, subTree);
    }
}
