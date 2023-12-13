package OPQ2_20231213_Phan_Minh_Phong;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ThreadSafeQueueTest {

    @Test
    public void testEnqueueDequeue() throws InterruptedException {
        ThreadSafeQueue queue = new ThreadSafeQueue(5);

        // Enqueue items
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        // Dequeue items
        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.dequeue());
    }
}

