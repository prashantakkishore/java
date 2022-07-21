package com.pks.ds.graph.traversal;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://www.youtube.com/watch?v=Zbbe9FYVnM4
 * Condition:
 * 1 - Graph should be directed aCyclic
 */
public class TopologicalSortDFS {

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 3);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 1);
        g.addEdge(3, 1);
        g.addEdge(1, 4);
        g.addEdge(5, 1);
        g.addEdge(5, 4);
        g.topologicalSort();
    }

    static class Graph {
        ArrayList<ArrayList<Integer>> adjList;
        Integer vertices;

        Graph(Integer vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(Integer v1, Integer v2) {
            // directed so 1 dir
            adjList.get(v1).add(v2);
        }

        public void topologicalSort() {
            boolean[] visited = new boolean[vertices];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < vertices; i++) {
                if (visited[i] == false) {
                    topologicalSortDFS(i, visited, stack);
                }
            }

            while (!stack.isEmpty()) {
                System.out.print(" " + stack.pop());
            }
        }

        private void topologicalSortDFS(Integer v, boolean[] visited, Stack<Integer> stack) {
            visited[v] = true;
            ArrayList<Integer> list = adjList.get(v);
            for (Integer v1 : list) {
                if (visited[v1] == false) {
                    topologicalSortDFS(v1, visited, stack);
                }
            }
            // All vertices of v visited
            stack.push(v);

        }
    }
}
