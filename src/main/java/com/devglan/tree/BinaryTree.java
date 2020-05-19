package com.devglan.tree;

import java.util.*;

public class BinaryTree {

    BinaryTreeNode root;

    public BinaryTree(){
        this.root = null;
    }

    public void levelOrderTraversal(BinaryTreeNode root){
        List<Integer> data = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTreeNode node = queue.poll();
            data.add(node.getData());
            if(node.getLeftNode() != null){
                queue.add(node.getLeftNode());
            }
            if(node.getRightNode() != null){
                queue.add(node.getRightNode());
            }
        }
        data.stream().forEach(nodeData -> System.out.print(nodeData + "  "));
        System.out.println();
    }

    public void levelOrderTraversalWithLevel(BinaryTreeNode root){
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        queue.add(null);
        int nullCount = 1;
        while(!queue.isEmpty()){
            BinaryTreeNode node = queue.remove();
            if(node == null){
                ++nullCount;
                ++level;
                if(nullCount == 2){
                    break;
                }
                queue.add(null);
            }else {
                addIntoLevelMap(map, level, node.getData());
                nullCount = 0 ;
                if (node.getLeftNode() != null) {
                    queue.add(node.getLeftNode());
                }
                if (node.getRightNode() != null) {
                    queue.add(node.getRightNode());
                }
            }
        }
        map.entrySet().stream().forEach(entry -> {
            System.out.print(entry.getKey() + " : ");
            entry.getValue().forEach(value -> System.out.print(value + " "));
            System.out.println();
        });
        //data.stream().forEach(System.out :: print);
    }

    private Map<Integer, List<Integer>> addIntoLevelMap(Map<Integer, List<Integer>> map, int level, int data) {

        if(map.get(level) == null){
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(data);
        return map;

    }

    public void levelOrderTraversalWithRecursion(BinaryTreeNode root){
        if(root == null){
            return;
        }
        int height = findHeight(root);
        for (int i = 0; i <= height; i++){
            System.out.print(i  + " :");
            printLevel(root, i);
            System.out.println();
        }
    }

    public int findHeight(BinaryTreeNode root){
        if(root == null){
            return 0;
        }
        //int leftHeight = findHeight(root.getLeftNode()) + 1;
        //int rightHeight = findHeight(root.getRightNode()) + 1;
        return Math.max(findHeight(root.getLeftNode()), findHeight(root.getRightNode())) + 1;
        //return Math.max(leftHeight, rightHeight);
    }

    public int findHeight1(BinaryTreeNode root){
        if(root == null){
            return 0;
        }
        if (root.getRightNode() == null && root.getLeftNode() == null){
            return 1;
        }
        if (root.getLeftNode() == null){
            return findHeight1(root.getRightNode());
        }
        if (root.getRightNode() == null){
            return findHeight1(root.getLeftNode());
        }
        int left = findHeight1(root.getLeftNode());
        int right = findHeight1(root.getRightNode());
        return Math.max(left, right) + 1;

    }
    private void printLevel(BinaryTreeNode root, int level){
        if (root == null){
            return;
        }
        if(level == 0){
            System.out.print(root.getData() + " ");
        }else if(level > 0){
            printLevel(root.getLeftNode(), level - 1);
            printLevel(root.getRightNode(), level - 1);
        }
    }

    Map<Integer, List<BinaryTreeNode>> map = new TreeMap<>();


    private void putToMap(int weight, BinaryTreeNode node){
        List<BinaryTreeNode> node1 = map.get(weight);
        if(node1 == null){
            node1 = new ArrayList<>();
        }
        node1.add(node);
        map.put(weight, node1);
    }

    public int leafNodes(BinaryTreeNode root){
        if (root == null){
            return 0;
        }
        if (root.getLeftNode() == null && root.getRightNode() == null){
            return 1;
        }
        int count = leafNodes(root.getLeftNode());
        int rcount = leafNodes(root.getRightNode());
        //System.out.println(count + rcount + " co");
        return count + rcount;
    }

    public void boundaryTraversal(BinaryTreeNode root){
        System.out.println(root.getData());
        printLeftNodeExcludingLeaf(root.getLeftNode());
        printLeafNodes(root);
        printRightNodeExcludingLeaf(root.getRightNode());
    }

    private void printLeftNodeExcludingLeaf(BinaryTreeNode leftNode) {
        if (leftNode == null){
            return;
        }
        if (leftNode.getLeftNode() == null && leftNode.getRightNode() == null){
            return;
        }
        System.out.println(leftNode.getData());
        printLeftNodeExcludingLeaf(leftNode.getLeftNode());

    }

    private void printLeafNodes(BinaryTreeNode root){
        if (root == null){
            return;
        }
        if(root.getRightNode() == null && root.getLeftNode() == null){
            System.out.println(root.getData());
        }
        printLeafNodes(root.getLeftNode());
        printLeafNodes(root.getRightNode());
    }

    private void printRightNodeExcludingLeaf(BinaryTreeNode rightNode) {
        if (rightNode == null){
            return;
        }
        if (rightNode.getLeftNode() == null && rightNode.getRightNode() == null){
            return;
        }
        System.out.println(rightNode.getData());
        printRightNodeExcludingLeaf(rightNode.getRightNode());
    }

}
