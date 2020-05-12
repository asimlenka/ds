package com.devglan.tree;

public class LCA {


    public static BinaryTreeNode findLCA(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2){
        if(root == null){
            return null;
        }
        if (root == node1 || root == node2) {
            return root;
        }
        BinaryTreeNode leftNode = findLCA(root.getLeftNode(), node1, node2);
        BinaryTreeNode rightNode = findLCA(root.getRightNode(), node1, node2);
        if (leftNode != null && rightNode != null){
            return root;
        }if (leftNode == null && rightNode == null){
            return null;
        }
        return leftNode == null? rightNode: leftNode;
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
        BinaryTreeNode commonAncestor = LCA.findLCA(root, root.getRightNode().getLeftNode(), root.getRightNode().getRightNode().getLeftNode());
        System.out.println(commonAncestor.getData());
    }

}
