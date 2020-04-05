package com.devglan.graph;

public class MatrixGraph {

    public static int findShortestPath(int[][] graph, int sourceVertex){
        int vertexCount  = graph.length;
        int[] distance = new int[vertexCount];
        boolean[] visitedVertex = new boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[sourceVertex] = 0;
        for (int i = 0; i < vertexCount - 1; i++){
            //in the first iteration minVertex is the source vertex and now the distance from source vertex
            //to other vertex will be updated
            int minVertex = findMinDistance(visitedVertex, distance);
            //to update distance of neighbour vertex, traverse all the neighbours of this vertex and in matrix representation the neighbour of this min
            //vertex are present in the same row. Hence, iterate each element of the row(meaning column wise for this row)
            //and find the distance
            visitedVertex[minVertex] = true;
            for (int j = 0; j < vertexCount; j++){
                //graph[minVertex][j] in the same row. if graph[minVertex][j] = 0 meaning no direct edge or it's not the neighbour find the minimum distance
                if(!visitedVertex[j] && graph[minVertex][j] != 0 && distance[minVertex] + graph[minVertex][j] < distance[j]){
                    distance[j] = distance[minVertex] + graph[minVertex][j];
                }
            }
        }
        //System.out.println(distance[sourceVertex]);
        printSolution(distance, 1);
        return distance[sourceVertex];
    }

    private static int findMinDistance(boolean[] visitedVertex, int[] distance) {
        int minDistance = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < visitedVertex.length; i++){
            if(!visitedVertex[i] && distance[i] < minDistance){//for the first time, only the source vertex will match this
                //condition and hence the source vertex index will be returned
                minDistance = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public  static void printSolution(int[] dist, int n)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < dist.length; i++)
            System.out.println(i + " \t " + dist[i]);
    }

    public static void main(String[] args){
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        MatrixGraph.findShortestPath(graph, 5);
    }
}
