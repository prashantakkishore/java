package com.pks.ds.graph;

import com.pks.ds.graph.traversal.DFS;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Basically we cant finish all courses if there is cycle in the graph.
 * So just check for cycle.
 */

public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule.Graph g = new CourseSchedule.Graph(5);

        g.addEdge(0, 1);
        // g.addEdge(0, 2);
        // g.addEdge(1, 2);
        g.addEdge(2, 0);
        // g.addEdge(2, 3);
        g.addEdge(3, 4);
        System.out.println(g.dfsDetectLoop(2));
    }

    static class Graph {
        ArrayList<ArrayList<Integer>> lists;
        Integer vertex = 0;

        public Graph(Integer V) {
            vertex = V;
            lists = new ArrayList<>(V);
            for (int i = 0; i < vertex; i++) {
                lists.add(new ArrayList<>());
            }
        }

        public void addEdge(Integer V1, Integer V2) {
            if (lists.get(V1) == null) {
                lists.set(V1, new ArrayList());
            }
            lists.get(V1).add(V2);
        }

        public boolean dfsDetectLoop(Integer startVertex) {
            boolean[] visited = new boolean[vertex];
            // for disconnected Graph
            for (int i = 0; i < vertex; i++) {
                if (!visited[i]) {
                    if (dfsRecur(startVertex, visited, -1))
                        return true;
                }
            }
            return false;

        }

        public boolean dfsRecur(Integer startVertex, boolean[] visited, Integer parent) {
            if (visited[startVertex])
                return true;
            else
                visited[startVertex] = true;
            System.out.println(startVertex + "->");
            Iterator<Integer> itr = lists.get(startVertex).listIterator();
            while (itr.hasNext()) {
                Integer V = itr.next();
                if (!visited[V]) {
                    if (dfsRecur(V, visited, startVertex))
                        return true;
                } else if (parent != V) { // not coming from parent
                    return true;
                }
            }
            return false;
        }
    }

}

