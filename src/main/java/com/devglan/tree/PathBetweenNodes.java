package com.devglan.tree;

import java.util.Stack;

public class PathBetweenNodes {

    public static void printPathFromRootToNode(BinaryTreeNode root, BinaryTreeNode n1){

        //to print path between any given 2 nodes, first find LCA then find path from LCA to n1 and then LCA to n2
       Stack<BinaryTreeNode> stack1 = printPath(root, n1);
       while (!stack1.isEmpty()){
           System.out.println(stack1.pop().getData());
       }
    }

    private static Stack<BinaryTreeNode> printPath(BinaryTreeNode root, BinaryTreeNode n1) {
        if (root == null){
            return null;
        }
        if (root == n1){
            Stack<BinaryTreeNode> stack = new Stack<>();
            stack.push(n1);
            return stack;
        }
        Stack<BinaryTreeNode> leftStack = printPath(root.getLeftNode(), n1);
        Stack<BinaryTreeNode> rightStack =  printPath(root.getRightNode(), n1);
        if (leftStack != null){
            leftStack.push(root);
            return leftStack;
        }
        if (rightStack != null){
            rightStack.push(root);
            return rightStack;
        }
        return null;
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

        //PathBetweenNodes.printPathBetween(root, root.getLeftNode().getLeftNode(), root.getRightNode().getRightNode().getLeftNode());
        PathBetweenNodes.printPathFromRootToNode(root, root.getRightNode().getRightNode().getLeftNode());

    }
}
