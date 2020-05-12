package com.devglan.tree;

import java.util.*;

public class TreeLeftView {

    static Map<Integer, List<BinaryTreeNode>> map = new TreeMap<>();

    public static void levelOrderTraversal(BinaryTreeNode root){
        int level = 0; int removalCount = 0;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            BinaryTreeNode node = queue.poll();
            if (node == null){
                //when we encounter null meaning one level of trabersal is completed. Hence increase the level
                removalCount = removalCount + 1;
                if (removalCount > 1){
                    break;
                }
                queue.add(null);
                level = level + 1;
            }else {
                removalCount = 0;
                if (node.getLeftNode() != null) {
                    queue.add(node.getLeftNode());
                }
                if (node.getRightNode() != null) {
                    queue.add(node.getRightNode());
                }
                populateMap(level, node);
            }
        }
        printLeftView();
        printRightView();
    }

    private static void populateMap(int level, BinaryTreeNode node) {
        List<BinaryTreeNode> nodes = map.get(level);
        if (nodes == null){
            nodes = new ArrayList<>();
        }
        nodes.add(node);
        map.put(level, nodes);
    }

    private static void printLeftView() {
        for (Map.Entry<Integer, List<BinaryTreeNode>> entry: map.entrySet()){
            System.out.println(entry.getValue().get(0).getData());
        }
    }

    private static void printRightView() {
        for (Map.Entry<Integer, List<BinaryTreeNode>> entry: map.entrySet()){
            System.out.println(entry.getValue().get(entry.getValue().size() - 1).getData());
        }
    }


    public static void main(String[] args){
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.setLeftNode(new BinaryTreeNode(7));
        root.setRightNode(new BinaryTreeNode(10));
        root.getLeftNode().setLeftNode(new BinaryTreeNode(14));
        root.getLeftNode().setRightNode(new BinaryTreeNode(19));

        root.getRightNode().setLeftNode(new BinaryTreeNode(30));
        root.getRightNode().setRightNode(new BinaryTreeNode(15));

        root.getRightNode().getRightNode().setLeftNode(new BinaryTreeNode(25));
        TreeLeftView.levelOrderTraversal(root);
    }
}
