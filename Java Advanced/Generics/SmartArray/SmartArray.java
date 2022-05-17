package SmartArray;

import java.util.function.Consumer;

public class SmartArray<T> {
    private final static int INITIAL_CAPACITY = 8;

    private Object[] elements;
    private int index;

    public SmartArray() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.index = 0;
    }

    public void add(T element) {
        if (this.index == elements.length) {
            this.elements = grow();
        }
        this.elements[this.index] = element;
        this.index++;
    }

    private Object[] grow() {
        Object[] newElements = new Object[elements.length * 2];

        System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);
        return newElements;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        ensureIndex(index);
        return (T) this.elements[index];
    }

    public int size() {
        return this.index;
    }

    public T remove(int index) {
        ensureIndex(index);
        T element = get(index);

        if (this.index - 1 - index >= 0)
            System.arraycopy(this.elements, index + 1, this.elements, index, this.index - 1 - index);

        this.elements[this.index - 1] = 0;
        this.index--;

        if (this.size() == 0) {
            this.elements = new Object[INITIAL_CAPACITY];
        }

        if (this.index <= this.elements.length / 4) {
            this.elements = shrink();
        }

        return element;
    }

    private Object[] shrink() {
        int reduceFactor = 2;

        if (this.elements.length / reduceFactor >= INITIAL_CAPACITY) {

            Object[] newElements = new Object[this.elements.length / reduceFactor];

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
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, T element) {
        ensureIndex(index);

        T lastElement = get(index);
        for (int i = this.index - 1; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[index] = element;

        add(lastElement);
    }

    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < this.index; i++) {
            consumer.accept(get(i));
        }
    }
}

