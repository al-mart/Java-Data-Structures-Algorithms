package DataStructures.Trees;

public class BinarySearchTree<T> {
    private Node<T> root;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public static Node<Integer> insert(Node<Integer> head, Node<Integer> node){
        if (head == null){
            return node;
        }
        if(node.getData() <= node.getData()){
            head.setLeftChild(insert(head.getLeftChild(), node));
        }else{
            head.setRightChild(insert(head.getRightChild(), node));
        }
        return head;
    }
    public static Node<Integer> lookup(Node<Integer> head, Integer data){
        if(head == null){
            return null;
        }
        if(head.getData() == data){
            return head;
        }
        else if (data < head.getData()){
            return lookup(head.getLeftChild(), data);
        }else if(data > head.getData()){
            return lookup(head.getRightChild(), data);
        }
        return null;
    }

    public static Integer minValue(Node<Integer> head){
        if(head == null ){
            return Integer.MIN_VALUE;
        }
        if(head.getLeftChild() == null){
            return head.getData();
        }
        return minValue(head.getLeftChild());
    }

    public static Integer maxValue(Node<Integer> head){
        if(head == null){
            return Integer.MAX_VALUE;
        }if( head.getRightChild() == null){
            return head.getData();
        }
        return maxValue(head.getRightChild());
    }

    public static Integer maxDepth(Node<Integer> head){
        if(head == null || head.getLeftChild() == null && head.getRightChild() == null){
            return 0;
        }
        else{
            return 1 + Math.max( maxDepth(head.getLeftChild()), maxDepth(head.getRightChild()));
        }
    }

    public static void mirror( Node<Integer> head){
        if(head == null){
            return;
        }
        else{
            mirror(head.getLeftChild());
            mirror(head.getRightChild());
            swap(head);
        }
    }
    public static void swap( Node<Integer> head) {
        Node temp = head.getLeftChild();
        head.setLeftChild( head.getRightChild());
        head.setRightChild(temp);
    }

    public static void printRange(Node<Integer> head, Integer minValue, Integer maxValue ){
        if(head == null){
            return;
        }
        else{
            if(head.getData() < minValue){
                printRange(head.getRightChild(), minValue, maxValue);
            }
            else if(head.getData() > maxValue){
                printRange(head.getLeftChild(), minValue, maxValue);
            }else{
                printRange(head.getLeftChild(), minValue, maxValue);
                print(head);
                printRange(head.getRightChild(), minValue, maxValue);
            }
        }
    }
    public static Boolean isBST(Node<Integer> head, Integer min ,Integer max){
        if(head == null){
            return true;
        }
        if(head.getData() <= min || head.getData() > max){
            return  false;
        }
        return isBST(head.getLeftChild(), min, head.getData()) && isBST(head.getRightChild(), head.getData(), max);
    }


    public static void print(Node<Integer> node){
        System.out.print(node.getData());
        System.out.print(",");
    }
}
