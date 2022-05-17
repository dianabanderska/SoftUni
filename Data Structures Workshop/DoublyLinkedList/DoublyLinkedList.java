package DoublyLinkedList;

import java.util.function.Consumer;

public class DoublyLinkedList {
    private class Node {
        int element;
        private Node next;
        private Node previous;

        private Node(int element) {
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.previous = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(int element) {
        Node newNode = new Node(element);
        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.previous = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }

    public int get(int index) {
        if (index < 0 && index >= this.size) {
            String message = String.format("Index: %d, Size: %d", index, this.size);
            throw new IndexOutOfBoundsException(message);
        } else if (index <= this.size / 2) {
            Node firstNode = this.head;

            for (int i = 0; i < index; i++) {
                firstNode = firstNode.next;
            }
            return firstNode.element;
        } else {
            Node lastNode = this.tail;

            for (int i = this.size - 1; i > index; i--) {
                lastNode = lastNode.previous;
            }
            return lastNode.element;
        }
    }

    public int removeFirst() throws Exception {
        if (this.size == 0) {
            throw new Exception("Cannot remove element from collection with size 0");
        } else if (this.size == 1) {
            Node firstElement = this.head;
            this.head = null;
            this.tail = null;
            this.size = 0;
            return firstElement.element;
        } else {
            Node firstElement = this.head;
            this.head = this.head.next;
            this.head.previous = null;
            this.size--;
            return firstElement.element;
        }
    }

    public int removeLast() throws Exception {
        if (this.size == 0) {
            throw new Exception("Cannot remove element from collection with size 0");
        } else if (size == 1) {
            Node removedElement = this.tail;
            this.tail = null;
            this.head = null;
            this.size = 0;
            return removedElement.element;
        } else {
            Node removedElement = this.tail;
            this.tail = this.tail.previous;
            this.tail.next = null;
            this.size--;
            return removedElement.element;
        }
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;
        while (currentNode != null) {
            consumer.accept(currentNode.element);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        int[] array = new int[this.size];
        Node currentNode = this.head;
        int index = 0;
        while (currentNode != null) {
            array[index] = currentNode.element;
            index++;
            currentNode = currentNode.next;
        }
        return array;
    }
}
