package com.devglan.tree;

public class DistanceBetweenNodes {

    public static int findDistanceBetweenNodes(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2){
        BinaryTreeNode lca = findLCA(root, n1, n2);
        int distance1 = findDistanceBetween(lca, n1, 0);
        int distance2 = findDistanceBetween(lca, n2, 0);
        System.out.println(distance1 + distance2);
        return distance1 + distance2;
    }

    private static int findDistanceBetween(BinaryTreeNode root, BinaryTreeNode n1, int distance) {
        if (root == null){
            return -1;
        }
        if (root == n1){
            return distance;
        }
        int d = findDistanceBetween(root.getLeftNode(), n1, distance + 1);
        if (d != -1){
            return d;
        }
        d = findDistanceBetween(root.getRightNode(), n1, distance + 1);
        return d;
    }

    private static BinaryTreeNode findLCA(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2) {

        if (root == null){
            return null;
        }
        if (root == n1 || root == n2){
            return root;
        }
        BinaryTreeNode leftNode = findLCA(root.getLeftNode(), n1, n2);
        BinaryTreeNode rightNode = findLCA(root.getRightNode(), n1, n2);
        if (leftNode != null && rightNode != null){
            return root;
        }
        if (leftNode == null && rightNode == null){
            return null;
        }
        return leftNode == null ? rightNode: leftNode;
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

        DistanceBetweenNodes.findDistanceBetweenNodes(root, root.getRightNode().getLeftNode(), root.getRightNode().getRightNode().getLeftNode());
    }
}
