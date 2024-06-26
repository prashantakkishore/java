package com.pks.ds.graph.traversal;

/**
 *  Adjacency Matrix is a 2D array of size V x V where V is the number of vertices in a graph
 *  https://www.geeksforgeeks.org/graph-and-its-representations/?ref=lbp
 */
public class AdjacencyMatrix {

    private boolean adjMatrix[][];
    private int numVertices;

    // Initialize the matrix
    public AdjacencyMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new boolean[numVertices][numVertices];
    }

    // Add undirected edges
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    // Remove undirected edges
    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
    }

    // Print the matrix
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (boolean j : adjMatrix[i]) {
                s.append((j ? 1 : 0) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String args[]) {
        AdjacencyMatrix g = new AdjacencyMatrix(4);
        // vertices/ nodes : 0, 1, 2, 3
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);

        System.out.print(g.toString());
    }
}
