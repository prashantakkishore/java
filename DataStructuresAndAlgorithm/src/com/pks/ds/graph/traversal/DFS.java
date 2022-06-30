package com.pks.ds.graph.traversal;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Similer to In-order traversal of a tree
 * https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 */
public class DFS {


    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        //g.print();
        g.DFS(2);
    }

    static class Graph {

        public Integer vertices ;
        public ArrayList<ArrayList<Integer>> lists;

        public Graph(Integer vertices) {
            this.vertices = vertices;
            lists = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                lists.add(new ArrayList<>());
            }
        }

        public void DFS(Integer val){
            boolean [] visited = new boolean[vertices];
            DFSUtil(val, visited);
        }

        public void DFSUtil(Integer val, boolean [] visited){
            visited[val] = true;
            System.out.println(val + " ");
            Iterator<Integer> itr = lists.get(val).listIterator();
            while(itr.hasNext()){
                Integer intVal = itr.next();
                if (!visited[intVal]){
                    DFSUtil(intVal, visited);
                }
            }

        }

        public void print(){
            for (int i = 0 ; i < lists.size(); i++){
                System.out.print(i + " : ");
                ArrayList<Integer> list = lists.get(i);
                for (Integer val: list) {
                    System.out.print(val + " -> ");
                }
                System.out.println();
            }
        }

        public void addEdge(Integer v1, Integer v2) {
            if(lists.size() == 0){
                ArrayList list = new ArrayList();
                list.add(v2);
                lists.add(list);
            } else{
                ArrayList list = lists.get(v1);
                list.add(v2);
            }
        }
    }
}
