package com.devglan.tree;

import java.util.*;

public class VerticalOrderTraversal {

    static Map<Integer, List<BinaryTreeNode>> map = new TreeMap<>();

    public static void verticalOrderTraversalRecursive(BinaryTreeNode root, int weight){
        if(root == null){
            return;
        }
        putToMap(weight, root);
        verticalOrderTraversalRecursive(root.getLeftNode(), weight - 1);
        verticalOrderTraversalRecursive(root.getRightNode(), weight + 1);
    }

    private static void putToMap(int weight, BinaryTreeNode node) {
        List<BinaryTreeNode> nodes = map.get(weight);
        if(nodes == null) {
            nodes = new ArrayList<>();
        }
        nodes.add(node);
        map.put(weight, nodes);
    }

    private static void printTopView() {
        for (Map.Entry<Integer, List<BinaryTreeNode>> entry: map.entrySet()){
            System.out.print(entry.getValue().get(0).getData() + " ");
        }
    }

    private static void printBottomView() {
        for (Map.Entry<Integer, List<BinaryTreeNode>> entry: map.entrySet()){
            System.out.print(entry.getValue().get(entry.getValue().size() - 1).getData() + " ");
        }
    }

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.setLeftNode(new BinaryTreeNode(7));
        root.setRightNode(new BinaryTreeNode(10));
        root.getLeftNode().setLeftNode(new BinaryTreeNode(14));
        root.getLeftNode().setRightNode(new BinaryTreeNode(19));

        root.getRightNode().setLeftNode(new BinaryTreeNode(30));
        root.getRightNode().setRightNode(new BinaryTreeNode(15));

        root.getRightNode().getRightNode().setLeftNode(new BinaryTreeNode(25));
        VerticalOrderTraversal.verticalOrderTraversalRecursive(root, 0);
        for (Map.Entry<Integer, List<BinaryTreeNode>> entry: map.entrySet()){
            System.out.print(entry.getKey() + ": ");
            entry.getValue().forEach(val -> System.out.print(val.getData() + " "));
            System.out.println();
        }
        VerticalOrderTraversal.printTopView();
        VerticalOrderTraversal.printBottomView();

    }


}
