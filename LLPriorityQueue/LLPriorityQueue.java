
//Sohan Chatterjee
//SSW 315 Lab 12 Linked List Priority Queue
//November 21, 2022
import java.util.*;

public class LLPriorityQueue<E> implements Comparator<E> {
    Node head = null;
    Node tail = null;
    int size;

    private class Node {
        E element;
        int priority;
        Node next;
        Node previous;

        public Node(E o, int p) {
            element = o;
            priority = p;
        }
    }

    public LLPriorityQueue() {
        size = 0;
    }

    @Override
    public int compare(E o1, E o2) {
        return 0;
    }

    public void enque(E element, int priority) {

        if (head == null) {
            head = new Node(element, priority);
            return;
        }

        Node node = new Node(element, priority);
        Node temp = head;
        while (temp != null && temp.priority >= priority) {
            tail = temp;
            temp = temp.next;
        }
        //inserts head at beginning of LL
        if (tail == null) {
            node.next = head;
            head.previous = node;
            head = node;
        }
        //inserts node at tail
        else if (temp == null) {
            tail.next = node;
            node.previous = tail;
        }
        //inserts node according to priority and links all
        else {
            tail.next = node;
            node.previous = tail;
            node.next = temp;
            temp.previous = node;
        }

        size++;
    }

    public void dequeue() {
        if (head != null) {
            head = head.next;
        }
        size--;
    }

    public int getSize() {
        return size;
    }
}