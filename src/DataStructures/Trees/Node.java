package DataStructures.Trees;

public class Node<T> implements Comparable<T> {
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
    public int compareTo(T o) {
        return 0;
    }
}
