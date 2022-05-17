package LinkedList;

import java.util.function.Consumer;

public class SmartArray {
    private final static int INITIAL_CAPACITY = 8;

    private int[] elements;
    private int index;

    public SmartArray() {
        this.elements = new int[INITIAL_CAPACITY];
        this.index = 0;
    }

    public void add(int element) {
        if (this.index == elements.length) {
            this.elements = grow();
        }
        this.elements[this.index] = element;
        this.index++;
    }

    private int[] grow() {
        int[] newElements = new int[this.index * 2];

        System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);
        return newElements;
    }

    public int get(int index) {
        ensureIndex(index);
        return this.elements[index];
    }

    public int size() {
        return this.index;
    }

    public int remove(int index) {
        ensureIndex(index);

        int removed = this.elements[index];

        for (int i = index; i < this.index - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[this.index - 1] = 0;
        this.index--;

        if (this.index <= this.elements.length / 4) {
            this.elements = shrink();
        }

        return removed;
    }

    private int[] shrink() {
        int reduceFactor = 2;

        if (this.elements.length / reduceFactor >= INITIAL_CAPACITY) {

            int[] newElements = new int[this.elements.length / reduceFactor];

            for (int i = 0; i < this.index; i++) {
                newElements[i] = this.elements[i];
            }
            return newElements;
        }
        return this.elements;
    }

    private void ensureIndex(int index) {
        if (index >= this.index || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + this.index);
        }
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.index; i++) {
            if (element == elements[i]) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, int element) {
        ensureIndex(index);

        int lastElement = this.elements[this.index - 1];
        for (int i = this.index - 1; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[index] = element;

        add(lastElement);
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.index; i++) {
            consumer.accept(this.elements[i]);
        }
    }
}
