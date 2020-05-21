package com.devglan.tree;

import java.util.Stack;

public class ZigZagTraversal {

    public static void zigzagTraversal(BinaryTreeNode root){
        Stack<BinaryTreeNode> leftToRightStack = new Stack<>();
        Stack<BinaryTreeNode> rightToLeftStack = new Stack<>();
        leftToRightStack.push(root);
        while(!leftToRightStack.isEmpty()){
            BinaryTreeNode node1 = leftToRightStack.pop();
            System.out.println(node1.getData());
            if (node1.getRightNode() != null)
                rightToLeftStack.push(node1.getRightNode());
            if (node1.getLeftNode() != null)
                rightToLeftStack.push(node1.getLeftNode());
            while (!rightToLeftStack.isEmpty()){
                BinaryTreeNode node2 = rightToLeftStack.pop();
                System.out.println(node2.getData());
                if (node2.getLeftNode() != null)
                    leftToRightStack.push(node2.getLeftNode());
                if (node2.getRightNode() != null)
                    leftToRightStack.push(node2.getRightNode());
            }
        }
    }

    //https://i1.wp.com/algorithms.tutorialhorizon.com/files/2014/11/Level-Order-Traversal-in-Zig-Zag-pattern-OR-Print-in-Spiral.png
    //Time Complexity: O(n)
    //Space Complexity: O(n)+(n)=O(n)
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.setLeftNode(new BinaryTreeNode(10));
        root.setRightNode(new BinaryTreeNode(15));
        root.getLeftNode().setLeftNode(new BinaryTreeNode(20));
        root.getLeftNode().setRightNode(new BinaryTreeNode(25));

        root.getLeftNode().getLeftNode().setLeftNode(new BinaryTreeNode(40));
        root.getLeftNode().getLeftNode().setRightNode(new BinaryTreeNode(45));

        root.getRightNode().setLeftNode(new BinaryTreeNode(30));
        root.getRightNode().setRightNode(new BinaryTreeNode(35));

        ZigZagTraversal.zigzagTraversal(root);

    }
}
