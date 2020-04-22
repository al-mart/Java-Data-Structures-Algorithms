/**
 * @author Aleksandr Martirosyan
 */
package DataStructures.LinkedList;

import DataStructures.Node.Node;

public class LinkedList<T extends Comparable<T>> implements Cloneable {
    private Node<T> head;

    public LinkedList() {}

    /**
     * Add's a node of data at the end of the list.
     * @param data to insert
     */
    public void add(T data) {
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node<T>(data));
        }
    }

    /**
     *  Return's count of elements in the list.
     * @return count od elem's
     */
    public int count() {
        if (head != null) {
            Node current = head.getNext();
            int count = 1;
            while (current != null) {
                current = current.getNext();
                count++;
            }
            return count;
        } else {
            return 0;
        }
    }

    /**
     * Delete first element from the list and return the value.
     * @return data of element
     */
    public T pop() {
        if (head != null) {
            /*
            Node<T> element = head;
            head = head.getNext();
            element.setNext(null);
            return element.getData();
            */
            T data = head.getData();
            head = head.getNext();
            return data;
        }
        return null;
    }

    /**
     * Return N-th node (for internal use).
     * @param index of node in the list
     * @return node
     */
    private Node<T> getNth(int index){
        if(head == null){
            return null;
        }
        else{
            Node<T> el = head;
            for(int i = 0; i < index ; i++){
                if(el.getNext() == null){
                    return null;
                }
                el = el.getNext();
            }
            return el;
        }
    }

    /**
     * Returns data of N-th node
     * @param index of node
     * @return data of element
     */
    public T getNthData(int index){
        return getNth(index).getData();
    }

    /**
     * Insert after N-th element.
     * @param index of element top insert after
     * @param data to insert
     */
    public void insertNth(int index, T data){
        Node elemToInsAfter = getNth(index);
        Node<T> elemToIns = new Node<T>(data);
        elemToIns.setNext(elemToInsAfter.getNext());
        elemToInsAfter.setNext(elemToIns);
    }

    /**
     * Given an ascending sorted List insert the element in its place
     * @param data to insert
     */
/*
    public void sortedInsert(T data){
        Node<T> current = head;
        Node<T> newNode = new Node<T>(data);
        current.compareTo(newNode)
    }
*/
    /**
     * Deletes the List (as head is main reference, if we lose it the Garb. collector will delete our List from memory)
     */
    public void deleteList(){
       head = null;
    }

    /**
     * Get Two list's append second from the start of first, deletes reference ,returns concatenated List
     * @param otherList
     * @return
     */
    public LinkedList<T> append(LinkedList<T> otherList){
        Node<T> lastElem = this.getLastElement();
        lastElem.setNext(otherList.head);
        otherList = null;
        return this;
    }

    private Node<T> getLastElement(){
        if(head != null){
            return iterateTillLast();
        }
        return null;
    }

    private Node<T> iterateTillLast(){
        Node<T> current = head;
        while(current.getNext() != null){
            current.getNext();
        }
        return current;
    }
}
