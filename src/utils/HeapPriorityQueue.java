package utils;

import java.util.NoSuchElementException;

public class HeapPriorityQueue<E extends Comparable<E>> implements PriorityQueue<E> {

    private static final int INITIAL_CAPACITY = 8;

    private E[] heap;
    private int size;

    private final HeapOrder order;

    public HeapPriorityQueue() {
        this(HeapOrder.MIN);
    }

    @SuppressWarnings("unchecked")
    public HeapPriorityQueue(HeapOrder order) {

        heap = (E[]) new Comparable[INITIAL_CAPACITY];
        size = 0;

        this.order = order;
    }

    @Override
    public void add(E item) {
        if (size == heap.length) {
            resize(heap.length * 2);
        }

        heap[size] = item;
        swim(size);
        size++;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        return heap[0];
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        E item = heap[0];
        size--;

        heap[0] = heap[size];
        heap[size] = null;

        if (!isEmpty()) {
            sink(0);
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void swim(int index) {
        while (index > 0) {
            int parent = parent(index);
            if (!higherPriority(heap[index], heap[parent])) {
                break;
            }

            swap(index, parent);
            index = parent;
        }
    }

    private void sink(int index) {
        while (leftChild(index) < size) {
            int child = leftChild(index);
            int right = rightChild(index);

            // Choose the child with higher priority.
            if (right < size && higherPriority(heap[right], heap[child])) {
                child = right;
            }

            if (!higherPriority(heap[child], heap[index])) {
                break;
            }

            swap(index, child);
            index = child;
        }
    }

    private boolean higherPriority(E a, E b) {
        int comparison = a.compareTo(b);

        if (order == HeapOrder.MIN) {
            return comparison < 0;
        }

        return comparison > 0;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int i, int j) {

        E temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newHeap = (E[]) new Comparable[newCapacity];

        for (int i = 0; i < size; i++) {
            newHeap[i] = heap[i];
        }

        heap = newHeap;
    }

    @Override
    public String toString() {
        String result = "[";

        for (int i = 0; i < size; i++) {

            if (i > 0) {
                result += ", ";
            }
            result += heap[i];
        }
        result += "]";

        return result;
    }
}