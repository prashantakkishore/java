package com.pks.ds.graph.traversal;

import java.util.ArrayList;

public class ConnectedComponents {

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.connectedComponents();
    }


    static class Graph{

        Integer vertices;
        ArrayList<ArrayList<Integer>> adjList;
        Graph(Integer vertices){
            this.vertices = vertices;
            adjList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices ; i ++) {
                adjList.add(new ArrayList<Integer>());
            }
        }
        // method to add an undirected edge
        public void addEdge(Integer v1, Integer v2) {
            ArrayList list = adjList.get(v1);
            list.add(v2);
            ArrayList list2 = adjList.get(v2);
            list2.add(v1);
        }

        public void connectedComponents() {
            boolean[] visited = new boolean[vertices];
            for (int i = 0; i < vertices; i++) {
                if(!visited[i]) {
                    dfs(i, visited);
                    System.out.println("NEW");
                }
            }
        }

        private void dfs(int i, boolean[] visited) {
            visited[i] = true;
            ArrayList<Integer> list = adjList.get(i);
            System.out.print(i +"->");
            for (Integer v : list) {
                if(!visited[v]) {
                    dfs(v, visited);
                }
            }

        }


    }


}
