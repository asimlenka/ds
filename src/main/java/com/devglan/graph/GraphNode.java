package com.devglan.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    List<List<Integer>> graph = new ArrayList<>();

    public List<List<Integer>> addEdge(Integer u, Integer v){
        graph.get(u).add(v);
        return graph;
    }
}
