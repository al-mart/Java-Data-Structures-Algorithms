package DataStructures.Trees;

public class Node<T extends java.lang.Comparable<T>> implements java.lang.Comparable<DataStructures.Trees.Node<T>> {
    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }
    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public int compareTo(Node o) {
        if(this.getData() == o.getData()){
            return 0;
        }
        else{
            return -1;
        }
    }
}
