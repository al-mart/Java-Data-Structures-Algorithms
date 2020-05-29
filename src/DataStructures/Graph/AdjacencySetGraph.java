package DataStructures.Graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencySetGraph implements Graph {
    private List<SetGraphNode> vertexList = new ArrayList<>();
    private GraphType graphType = GraphType.DIRECTED;
    private int numberOfVertices = 0;

    public AdjacencySetGraph(int numberOfVertices, GraphType graphType) {
        this.numberOfVertices = numberOfVertices;

        for (int i = 0; i < numberOfVertices; i++) {
            vertexList.add(new SetGraphNode(i));
        }

        this.graphType = graphType;
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v1 >= numberOfVertices || v2 < 0 || v2 >= numberOfVertices) {
            throw new IllegalArgumentException("Vertex number is not valid");
        }
        vertexList.get(v1).addEdge(v2);
        if (graphType == GraphType.UNDIRECTED) {
            vertexList.get(v2).addEdge(v1);
        }
    }

    @Override
    public List<Integer> getAdjacencyVertices(int v) {
        if (v < 0 || v >= numberOfVertices) {
            throw new IllegalArgumentException("Vertex number is not valid");
        }

        return vertexList.get(v).getAdjacencyVertices();
    }
}
