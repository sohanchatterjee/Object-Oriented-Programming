
//Sohan Chatterjee
////SSW 315 Lab 12 Linked List Priority Queue Test
//November 21, 2022
import static org.junit.Assert.*;

import org.junit.Test;

public class LLPriorityQueueTest {
    LLPriorityQueue<Integer> queue = new LLPriorityQueue<>();

    @Test
    public void testEnqueue() {
        queue.enque(1, 1);
        assertEquals(queue.head, queue.head);
    }

    @Test
    public void testEnqueueNegative() {
        LLPriorityQueue<Integer> testQueue = new LLPriorityQueue<>();
        queue.enque(1, 1);
        testQueue.enque(2, 1);
        assertNotEquals(testQueue.head, queue.head);
    }

    @Test
    public void testDequeue() {
        queue.enque(1, 1);
        queue.enque(2, 2);
        queue.dequeue();
        assertEquals(queue.head, queue.head);
    }

    @Test
    public void testDequeueNegative() {
        LLPriorityQueue<Integer> testQueue = new LLPriorityQueue<>();
        queue.enque(1, 1);
        queue.enque(2, 2);
        testQueue.enque(2, 1);
        queue.dequeue();
        assertNotEquals(testQueue.head, queue.head);
    }

    @Test
    public void testgetSize() {
        queue.enque(1, 1);
        queue.enque(2, 2);
        assertNotEquals(queue.size, 2);
    }
}
