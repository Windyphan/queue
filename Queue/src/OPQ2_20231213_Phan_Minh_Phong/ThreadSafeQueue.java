package OPQ2_20231213_Phan_Minh_Phong;
public class ThreadSafeQueue {

    private final Object[] queue;
    private int size;
    private int front;
    private int rear;

    public ThreadSafeQueue(int capacity) {
        queue = new Object[capacity];
        size = 0;
        front = 0;
        rear = -1;
    }

    public synchronized void enqueue(Object item) throws InterruptedException {
        while (size == queue.length) {
            wait(); // Wait while the queue is full
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = item;
        size++;
        notifyAll();  // Notify any waiting dequeue operation
    }

    public synchronized Object dequeue() throws InterruptedException {
        while (size == 0) {
            wait(); // Wait while the queue is empty
        }
        Object item = queue[front];
        front = (front + 1) % queue.length;
        size--;
        notifyAll();  // Notify any waiting enqueue operation
        return item;
    }
}
