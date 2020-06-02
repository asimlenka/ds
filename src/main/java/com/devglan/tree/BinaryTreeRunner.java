package com.devglan.tree;

import java.util.Stack;

public class BinaryTreeRunner {

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        BinaryTreeNode root = new BinaryTreeNode(5);
        tree.root = root;
        root.setLeftNode(new BinaryTreeNode(7));
        root.setRightNode(new BinaryTreeNode(10));
        root.getLeftNode().setLeftNode(new BinaryTreeNode(14));
        root.getLeftNode().setRightNode(new BinaryTreeNode(19));

        root.getRightNode().setLeftNode(new BinaryTreeNode(30));
        root.getRightNode().setRightNode(new BinaryTreeNode(15));

        root.getRightNode().getRightNode().setLeftNode(new BinaryTreeNode(25));

        /*tree.levelOrderTraversal(root);
        System.out.println();

        tree.levelOrderTraversalWithLevel(root);
        System.out.println();*/

        //tree.levelOrderTraversalWithRecursion(root);

        //tree.verticalOrderTraversal(root);
        //tree.leafNodes(root);
        //System.out.println(tree.leafNodes(root));
        //MaxContineousPath m = new MaxContineousPath();
        //m.findContineousPath(root);
        //System.out.println(m.maxSum);
        //LCA lca = new LCA();
        //System.out.println(lca.findLCA(root, root.getLeftNode().getLeftNode(), root.getLeftNode().getRightNode()).getData());
        //lca.findLCAUsingStack(root, root.getLeftNode().getLeftNode(), root.getLeftNode().getRightNode());
        //BinaryTree bt = new BinaryTree();
        //bt.boundaryTraversal(root);
        //BinaryTree binaryTree = new BinaryTree();
        //System.out.println(binaryTree.findHeight(root));
        //System.out.println(binaryTree.findHeight1(root));
        /*binaryTree.findPath(root, root.getLeftNode().getLeftNode(), root.getLeftNode().getRightNode() );
        while (binaryTree.stack != null && !binaryTree.stack.isEmpty()){
            System.out.println(binaryTree.stack.pop().getData());
        }*/

        BinaryTreeNode node = BinaryTreeMirror.mirrorBinaryTree(root);
        System.out.println(node.getData());

        System.out.println(NodeCount.countNodes(root));
    }

}
