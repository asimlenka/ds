package com.devglan.tree;

import java.util.LinkedList;
import java.util.Queue;

public class NodeCount {

    public static int countNodes(BinaryTreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + countNodes(root.getLeftNode()) + countNodes(root.getRightNode());
    }

    static int level = 0;
    static int nodeCount = 0;
    static int nullCount = 0;
    static Queue<BinaryTreeNode> queue = new LinkedList<>();
    public static int countNodesFromGivenLevelToLeaf(BinaryTreeNode root, int givenLevel){
        queue.add(root);
        queue.add(null);
        ++level;
        while (!queue.isEmpty()){
            BinaryTreeNode top = queue.peek();
            if (top == null){
                ++nullCount;
                ++level;
                if (nullCount > 2){
                    break;
                }
                queue.add(null);
            }else {
                nullCount = 0;
                if (level > givenLevel){
                    System.out.println(top.getData());
                    ++nodeCount;
                }
                if (top.getLeftNode() != null){
                    queue.add(top.getLeftNode());
                }
                if (top.getRightNode() != null){
                    queue.add(top.getRightNode());
                }

            }
            queue.remove();
        }
        return nodeCount;
    }
}
