package utils.sort;

public class HeapSort<E extends Comparable<E>> implements Sorter<E> {

    @Override
    public void sort(E[] items) {
        int n = items.length;

        /*
         * Build a max-heap.
         * Leaf nodes already satisfy the heap property,
         * so begin with the final non-leaf node.
         */
        for (int i = n / 2 - 1; i >= 0; i--) {
            sink(items, i, n);
        }

        /*
         * Repeatedly move the largest item to the
         * end of the array and reduce the heap.
         */
        for (int end = n - 1; end > 0; end--) {
            swap(items, 0, end);
            sink(items, 0, end);
        }
    }

    private void sink(E[] items, int index, int size) {
        while (leftChild(index) < size) {
            int child = leftChild(index);
            int right = rightChild(index);

            // Choose the larger child.
            if (right < size && items[right].compareTo(items[child]) > 0) {
                child = right;
            }

            // Heap order has been restored.
            if (items[index].compareTo(items[child]) >= 0) {
                break;
            }
            swap(items, index, child);

            index = child;
        }
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(E[] items, int i, int j) {
        E temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
}