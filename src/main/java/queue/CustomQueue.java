package queue;

// Custom queue implementation using Fixed Circular array
public class CustomQueue {
    private final int[] queue;
    private int size;
    private int front;
    private int rear;
    private static final int CAPACITY = 16;

    public CustomQueue() {
        this.queue = new int[CAPACITY];
        this.size = 0;
        this.front = -1;
        this.rear = -1;
    }

    public CustomQueue(int capacity) {
        this.queue = new int[capacity];
        this.size = 0;
        this.front = -1;
        this.rear = -1;
    }

    public void enqueue(int data) throws IllegalStateException, NullPointerException {
        if (this.size == this.queue.length - 1) {
            throw new IllegalStateException("The element can't be added because the queue is full: Overflow");
        }

        if(this.rear < 0) {
            this.rear = 0;
        }

        queue[this.rear] = data;
        this.size++;
        this.rear = ++this.rear % this.queue.length;
    }

    public int dequeue() throws IllegalStateException {
        if (size == 0) {
            throw new IllegalStateException("The queue is empty: Underflow");
        }

        if(this.front < 0) {
            this.front = 0;
        }

        int result = queue[front];
        queue[front] = Integer.MIN_VALUE;
        this.size--;
        this.front = ++this.front % this.queue.length;

        return result;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public boolean isFull() {
        return (this.size == this.queue.length - 1);
    }

    public int queueSize() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ ");
        for (int i = 0; i < this.queueSize() + this.front; i++) {
            sb.append(this.queue[i]);
            if (i < this.queueSize() + this.front - 1) {
                sb.append(", ");
            }
        }
        sb.append(" ]");

        return sb.toString();
    }

    public static void main(String[] args) {
        CustomQueue customQueue = new CustomQueue();
        customQueue.enqueue(3);
        customQueue.enqueue(1);
        customQueue.enqueue(4);
        customQueue.enqueue(5);

        System.out.println(customQueue);

        customQueue.enqueue(6);
        customQueue.enqueue(7);
        customQueue.enqueue(8);

        System.out.println(customQueue);
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.dequeue());

        System.out.println(customQueue);

        System.out.println(customQueue.isEmpty());
        System.out.println(customQueue.isFull());
        System.out.println(customQueue.queueSize());
    }
}
