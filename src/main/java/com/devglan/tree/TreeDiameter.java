package com.devglan.tree;

public class TreeDiameter {

    static int diameter = 0;

    public static int findDiameter(BinaryTreeNode root){
        //find height of each node as the longest path may not pass from the root node
        if (root == null){
            return 0;
        }
        if (root.getLeftNode() == null && root.getRightNode() == null){
            return 1;
        }
        int lh = findDiameter(root.getLeftNode());
        int rh = findDiameter(root.getRightNode());
        //either keep in a map for each node or just replace the global variable diameter with the max value.
        diameter = Math.max(diameter, lh + rh + 1);
        return Math.max(lh, rh) + 1;
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

        System.out.println(TreeDiameter.findDiameter(main));
    }
}
