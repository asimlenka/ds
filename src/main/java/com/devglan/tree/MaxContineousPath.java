package com.devglan.tree;

public class MaxContineousPath {

    int maxSum = 0;

    public int findContineousPath(BinaryTreeNode root){
        if (root == null){
            return 0;
        }
        int l = findContineousPath(root.getLeftNode());
        int r = findContineousPath(root.getRightNode());
        int maxlr = Math.max(l, r);
        int maxSingle = Math.max(root.getData(), root.getData() + maxlr);
        int maxAll = Math.max(maxSingle, l + r + root.getData());
        maxSum = Math.max(maxSum, maxAll);
        //return max of root + maxchild or root
        System.out.println(maxSingle);
        return maxSingle;
    }

}
