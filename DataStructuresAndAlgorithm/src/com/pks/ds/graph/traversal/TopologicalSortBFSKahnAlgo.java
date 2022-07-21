package com.pks.ds.graph.traversal;

import java.util.*;

public class TopologicalSortBFSKahnAlgo {

    public static void main(String[] args) {
        TopologicalSortBFSKahnAlgo.Graph g = new TopologicalSortBFSKahnAlgo.Graph(6);
        g.addEdge(0,3);
        g.addEdge(0,2);
        g.addEdge(2,3);
        g.addEdge(2,1);
        g.addEdge(3,1);
        g.addEdge(1,4);
        g.addEdge(5,1);
        g.addEdge(5,4);
        g.topologicalSort();
    }

    static class Graph{
        ArrayList<ArrayList<Integer>> adjList;
        Integer vertices;

        Graph(Integer vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(Integer v1, Integer v2){
            // directed so 1 dir
            adjList.get(v1).add(v2);
        }

        public void topologicalSort() {
            boolean[] visited = new boolean[vertices]; // Not needed just to align with BFS
            int [] inDegree = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                List<Integer> list = adjList.get(i);
                for (Integer v : list) {
                    inDegree[v]++;
                }
            }
            for (int i = 0; i < vertices; i++) {
                if (visited[i] == false ) {
                    topologicalSortBFS(visited, inDegree);
                }
            }
        }

        private void topologicalSortBFS(boolean[] visited, int [] inDegree) {

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0 && !visited[i])
                    queue.add(i);
            }
            while(!queue.isEmpty()) {

                Integer v1 = queue.remove();
                visited[v1] = true;
                System.out.print(" " + v1);
                List<Integer> list = adjList.get(v1);
                for (Integer v2 : list) {
                    inDegree[v2]--;
                    // If 0 indegree then add to queue
                    if (inDegree[v2] == 0 && !visited[v2])
                        queue.add(v2);
                }
            }
        }
    }
}
