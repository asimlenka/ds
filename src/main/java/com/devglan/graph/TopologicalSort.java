package com.devglan.graph;

import java.util.*;

public class TopologicalSort {

    public static void topologicalSort(Graph graph, int vertex){
        Stack<Integer> stack = new Stack<>();
        List<Boolean> visited = new ArrayList<>(graph.adj.size());
        for (int j = 0; j< vertex; j++){
            visited.add(false);
        }
        for (int i = 0; i < vertex; i++){
            if (!visited.get(i)) {
                //visited.add(i, true);
                sortUtil(i, stack, visited, graph);
            }
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop() + " ");
        }
    }

    private static void sortUtil(Integer vertex, Stack<Integer> stack, List<Boolean> visited, Graph graph) {
        if (!visited.get(vertex)){
            visited.add(vertex, true);
        }
        Iterator<Integer> neighbours = graph.adj.get(vertex).iterator();
        while (neighbours.hasNext()){
            vertex = neighbours.next();
            if (!visited.get(vertex)) {
                sortUtil(vertex, stack, visited, graph);
            }
        }
        stack.push(vertex);
    }

    public static void main(String[] args){
        Graph graph = new Graph(8);

        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(5, 8);
        graph.addEdge(5, 6);
        graph.addEdge(2, 4);
        graph.addEdge(4, 6);
        graph.addEdge(6, 7);
        TopologicalSort.topologicalSort(graph, 8);
    }


    static class Graph{
        int vertex;

        List<List<Integer>> adj;

        public Graph(int vertex){
            this.vertex = vertex;
            adj = new ArrayList<>(vertex);
            for (int i = 0; i < vertex; i++){
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int source, int weight){
            adj.get(source).add(weight);
        }
    }
}



