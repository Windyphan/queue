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

    @Test
    public void testThreadSafety() throws InterruptedException {
        final ThreadSafeQueue queue = new ThreadSafeQueue(3);

        Thread t1 = new Thread(() -> {
            try {
                queue.enqueue("A");
                queue.enqueue("B");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                queue.enqueue("C");
                queue.enqueue("D");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.dequeue());
        assertEquals("D", queue.dequeue());
    }
}

