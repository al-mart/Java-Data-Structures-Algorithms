package Algorithms.Trees;

import Algorithms.Helpers;
import DataStructures.Queue.Queue;
import DataStructures.Queue.QueueOverflowException;
import DataStructures.Queue.QueueUnderflowException;
import DataStructures.Stack.Stack;
import DataStructures.Stack.StackOverflowException;
import DataStructures.Stack.StackUnderflowException;
import DataStructures.Trees.Node;
import com.sun.source.tree.BreakTree;

public class TraversalAlgorithm {

    public static void depthFirstRecursive(Node root, String order) {
        if (root == null) {
            return;
        }
        if(order == "pre-order"){
            Helpers.printValue(root.getData());
            depthFirstRecursive(root.getLeftChild(), order);
            depthFirstRecursive(root.getRightChild(), order);
        }else if(order == "in-order"){
            depthFirstRecursive(root.getLeftChild(), order);
            Helpers.printValue(root.getData());
            depthFirstRecursive(root.getRightChild(), order);
        }else if(order == "post-order"){
            depthFirstRecursive(root.getLeftChild(), order);
            depthFirstRecursive(root.getRightChild(), order);
            Helpers.printValue(root.getData());

        }
    }

    public static void breadthFirst(Node root) throws QueueOverflowException, QueueUnderflowException {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new Queue<>(Node.class);
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            Helpers.printValue(node.getData());
            if (node.getLeftChild() != null) {
                queue.enqueue(node.getLeftChild());
            } else if (node.getRightChild() != null) {
                queue.enqueue(node.getRightChild());
            }
        }
    }

    public static void depthFirst(Node root) throws StackOverflowException, StackUnderflowException {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            Helpers.printValue(node.getData());
            if (node.getRightChild() != null) {
                stack.push(node.getRightChild());
            } else if (node.getLeftChild() != null) {
                stack.push(node.getLeftChild());
            }
        }
    }
}
