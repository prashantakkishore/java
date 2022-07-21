package com.pks.ds.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 * https://www.geeksforgeeks.org/find-paths-given-source-destination/
 */
public class FindAllPathSourceToTarget {

    public static void main(String[] args) {
        FindAllPathSourceToTarget.Graph g = new FindAllPathSourceToTarget.Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        //g.print();
        g.DFSAllPath(0, 3);
    }

    static class Graph {

        public Integer vertices;
        public ArrayList<ArrayList<Integer>> lists;

        public Graph(Integer vertices) {
            this.vertices = vertices;
            lists = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                lists.add(new ArrayList<>());
            }
        }

        public void DFSAllPath(Integer source, Integer target) {
            boolean[] visited = new boolean[vertices];
            DFSUtil(source, target, visited, new ArrayList<>());
        }

        public void DFSUtil(Integer source, Integer target, boolean[] visited, List<Integer> paths) {
            paths.add(source);
            if (source == target) {
                System.out.println(paths);
                return;
            }
            // visited[source] = true;

            Iterator<Integer> itr = lists.get(source).listIterator();
            while (itr.hasNext()) {
                Integer intVal = itr.next();
                //if (!visited[intVal]){
                    DFSUtil(intVal, target, visited, paths);
                    paths.remove(intVal);
                // }
            }

        }

        public void print() {
            for (int i = 0; i < lists.size(); i++) {
                System.out.print(i + " : ");
                ArrayList<Integer> list = lists.get(i);
                for (Integer val : list) {
                    System.out.print(val + " -> ");
                }
                System.out.println();
            }
        }

        public void addEdge(Integer v1, Integer v2) {
            lists.get(v1).add(v2);
        }
    }
}
