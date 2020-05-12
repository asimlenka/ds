package com.devglan.graph;

public class PrimAlgo {

    public static void mst(int[][] graph, int sourceVertex){

        int vertexCount = graph.length;
        boolean[] visited = new boolean[vertexCount];
        visited[sourceVertex] = true;
        for (int i = 0; i < vertexCount; i++){
            int v = findMinEdgeVertex(i, visited, graph);
            addEdge(i, v);
        }
    }

    private static void addEdge(int i, int v) {

    }

    private static int findMinEdgeVertex(int source, boolean[] visited, int[][] graph) {
        int distance = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                if (graph[source][i] < distance)
                    if (true) {
                        distance = graph[source][i];
                        index = i;
                    }

            }
            return index;
        }
        return 0;
    }

    public static void main(String[] args){
        int graph[][] = new int[][] { { 0, 4, 8, 0, 0 },
                { 4, 0, 2, 5, 0 },
                { 8, 2, 0, 5, 9},
                { 0, 5, 5, 0, 4 },
                { 0, 0, 9, 4, 0 } };

    }
}
