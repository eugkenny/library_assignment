package demo;

import utils.HeapPriorityQueue;
import utils.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {

        PriorityQueue<Integer> queue =
                new HeapPriorityQueue<>();

        queue.add(8);
        queue.add(3);
        queue.add(6);
        queue.add(1);
        queue.add(5);
        queue.add(9);
        queue.add(2);

        System.out.println(queue);

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}