package StackIterator;

public class Node<Integer> {
    public int element;
    public Node<Integer> previous;

    public Node(int element) {
        this.element = element;
        this.previous = null;
    }
}