import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerThread {

    // Define a queue with a capacity of 10
    private static final int QUEUE_CAPACITY = 10;
    private static final int TOTAL_ELEMENTS_TO_PRODUCE = 100;
    private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(QUEUE_CAPACITY);

    public static void main(String[] args) {
        // Create producer and consumer threads
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());

        // Start the producer and consumer
        producer.start();
        consumer.start();
    }

    // Producer class that produces 100 elements
    static class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= TOTAL_ELEMENTS_TO_PRODUCE; i++) {
                try {
                    // Produce an element (simulate producing a number)
                    System.out.println("Producing item: " + i);
                    queue.put(i);  // Put the element into the queue
                    synchronized (queue) {
                        // Notify the consumer when an item is produced
                        queue.notify();
                    }
                    Thread.sleep(100); // Simulate time to produce an element
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // Consumer class that consumes items once there are 10 items in the queue
    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    // Wait until the queue has at least 10 elements
                    synchronized (queue) {
                        while (queue.size() < 10) {
                            queue.wait();  // Wait until there are at least 10 items in the queue
                        }
                    }

                    // Consume 10 items
                    for (int i = 0; i < 10; i++) {
                        Integer item = queue.take();  // Take an item from the queue
                        System.out.println("Consuming item: " + item);
                    }

                    Thread.sleep(200); // Simulate time taken to consume 10 items
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
