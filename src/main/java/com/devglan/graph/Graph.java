package com.devglan.graph;

import java.util.*;

public class Graph {

    private Map<Node, LinkedList<Node>> adjacencyMap;

    public Graph(){
        adjacencyMap = new HashMap<>();
    }

    public void insert(Node source, Node target){
        //check if key or source exists or not
        if(!adjacencyMap.keySet().contains(source)){
            //put the source
            adjacencyMap.put(source, null);
        }
        if(!adjacencyMap.keySet().contains(target)){
            //this will make sure even vertex with no edges are included
            adjacencyMap.put(target, null);
        }
        LinkedList<Node> temp = adjacencyMap.get(source);
        if(temp == null){
            temp = new LinkedList<>();
        }
        temp.add(target);
        adjacencyMap.put(source, temp);
    }

    public boolean hasEdge(Node source, Node target){
        return adjacencyMap.containsKey(source) && adjacencyMap.get(source) != null && adjacencyMap.get(source).contains(target);
    }

    public void traverse(){
        for(Node root: adjacencyMap.keySet()){
            System.out.print("Traversing from node " + root.name + " - ");
            LinkedList<Node> vertices = adjacencyMap.get(root);
            if(vertices != null) {
                for (Node adjacent : adjacencyMap.get(root)){
                    System.out.print(adjacent.name);
                }
            }
            System.out.println();
        }

    }

    public void bfsTraverse(Node node){
        List<Node> visitedNodes = new ArrayList<>();
        //visitedNodes.add(node);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node visitedNode = queue.remove();
            visitedNodes.add(visitedNode);
            System.out.print(visitedNode.name);
            List<Node> neighbours = adjacencyMap.get(visitedNode);
            if(neighbours != null) {
                for (int i = 0; i < neighbours.size(); i++) {
                    Node n = neighbours.get(i);
                    if (n != null && !visitedNodes.contains(n)) {
                        queue.add(n);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Graph graph = new Graph();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        graph.insert(a,b);
        graph.insert(b,c);
        graph.insert(b,d);
        graph.insert(c,e);
        graph.insert(b,a);

        graph.traverse();

        System.out.println(graph.hasEdge(a,b));
        System.out.println(graph.hasEdge(d,a));
        graph.bfsTraverse(a);
    }
}
