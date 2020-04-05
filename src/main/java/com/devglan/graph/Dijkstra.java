package com.devglan.graph;

public class Dijkstra {

    public static void dijkstra(int[][] graph, int sourceVertex){
        int vertexCount = graph.length;
        boolean[] visitedVertex = new boolean[vertexCount];
        int[] distance = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[sourceVertex] = 0; // distance of source vertex to itself is zero
        for (int i = 0; i < vertexCount; i++){
            //find the neighbouring unvisited vertex having  minimum distance from source vertex
            //for the first time the minDistanceVertexIndex will be the source vertex and the distance array will be updated with the neighbouring vertex distance of source vertex
            int u = findMinDistance(distance, visitedVertex);
            //u is the row and v is the column
            visitedVertex[u] = true;
            //as per the formula minDistanceVertexIndex is u
            //now update all the neighbour vertex distances
            //to update distance of neighbour vertex, traverse all the neighbours of this vertex and in matrix representation the neighbour of this min
            //vertex are present in the same row. Hence, iterate each element of the row(meaning column wise for this row)
            //and find the distance
            for (int v =0 ; v < vertexCount; v++){
            //graph[minDistanceVertexIndex][v] != 0 -> there should be a direct edge
                if(!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])){
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
        for (int i = 0; i < distance.length; i++){
            System.out.println(String.format("Distance from source vertex %s to vertex %s is %s", sourceVertex, i, distance[i]));
        }

    }

    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i =0; i < distance.length; i++){
            //the vertex should not be visited and the distance should be the minimum.
            //for the first time, only the source vertex will match this condition and it will be returned as all other vertex has a distance of infinity
            // from next iteration the minimum distance vertex will be returned. Even if a source vertex has multiple edges,
            // this will return the minimum distance vertex
            //this is similar to finding the min element of an array
            if(!visitedVertex[i] && distance[i] < minDistance){
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

    public static void main(String[] args)
    {
        //https://i.imgur.com/6R8oPO1.png
        int graph[][] = new int[][] { { 0, 4, 8, 0, 0 },
                { 4, 0, 2, 5, 0 },
                { 8, 2, 0, 5, 9},
                { 0, 5, 5, 0, 4 },
                { 0, 0, 9, 4, 0 } };
        Dijkstra t = new Dijkstra();
        t.dijkstra(graph, 0);
    }
}
