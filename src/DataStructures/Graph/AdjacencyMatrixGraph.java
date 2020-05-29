package DataStructures.Graph;

import java.util.*;

public class AdjacencyMatrixGraph implements Graph {
    private int[][] adjacencyMatrix;
    private GraphType graphType = GraphType.DIRECTED;
    private int numberOfVertices = 0;

    public AdjacencyMatrixGraph(int numberOfVertices, GraphType graphType) {
        this.numberOfVertices = numberOfVertices;
        this.graphType = graphType;
        adjacencyMatrix = new int[numberOfVertices][numberOfVertices];

        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v1 >= numberOfVertices || v2 < 0 || v2 >= numberOfVertices){
            throw new IllegalArgumentException("Vertex number is not valid");
        }
        adjacencyMatrix[v1][v2] = 1;
        if (graphType == GraphType.UNDIRECTED){
            adjacencyMatrix[v2][v1] = 1;
        }
    }

    @Override
    public List<Integer> getAdjacencyVertices(int v) {
        if ( v < 0 || v >= numberOfVertices){
            throw new IllegalArgumentException("Vertex number is not valid");
        }

        List<Integer> vertices = new ArrayList<>();
        for(int i = 0; i < numberOfVertices ; i++){
            if (adjacencyMatrix[v][i] == 1){
                vertices.add(i);
            }
        }

        Collections.sort(vertices);
        return  vertices;
    }
}
