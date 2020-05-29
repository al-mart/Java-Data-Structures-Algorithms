package DataStructures.Graph;

import java.util.*;

public class SetGraphNode {
    private int vertexNumber;
    private Set<Integer> adjacencySet = new HashSet<>();

    public SetGraphNode(int vertexNumber){
        this.vertexNumber = vertexNumber;
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    public void addEdge(int vertexNumber){
        adjacencySet.add(vertexNumber);
    }

    public List<Integer> getAdjacencyVertices(){
        List<Integer> sortedList = new ArrayList<>(adjacencySet);
        Collections.sort(sortedList);
        return sortedList;
    }
}
