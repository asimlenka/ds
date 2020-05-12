package com.devglan.graph;

public class ArrivalDeparture {

    public void dijkstra(int graph[][], int sourceVertex){

    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 8, 0, 0 },
                { 4, 0, 2, 5, 0 },
                { 8, 2, 0, 5, 9},
                { 0, 5, 5, 0, 4 },
                { 0, 0, 9, 4, 0 } };
        ArrivalDeparture t = new ArrivalDeparture();
        t.dijkstra(graph, 0);
    }
}
