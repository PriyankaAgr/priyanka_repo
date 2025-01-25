import java.util.ArrayDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Producer and consumer program in Java.
 * Produce will produce items until the list has 10 elements and
 * consumer consumes items as long as the list has elements (but won't consume if it's empty)
 * program continues until a total of 100 elements have been produced
 */
public class ProdConsProblem {

    static ArrayDeque<Integer> blockingQueue = new ArrayDeque<>(10);
    static int count=1;
    public static void main(String[] args) {

        Runnable producer = new Producer();
        Runnable consumer = new Consumer();
        producer.run();
        producer.run();
        producer.run();
        consumer.run();


    }


    static class Producer implements Runnable {


        public void run() {
            try {
                if (blockingQueue.isEmpty()) {
                    wait();//wait till consumer has consume;
                }
                System.out.println("Producer Thread : "+ Thread.currentThread().getName() + " Adding element "+ count + " to queue");
                blockingQueue.add(count++);
                if(count>=100) System.exit(0);


            } catch (Exception e) {
                System.out.println("Exception occured in producer thread" + Thread.currentThread().getName() + "while producing elements in queue");

            }


        }
    }

    static class Consumer extends Thread {

        Consumer(){

        }

        public void run() {
            try {
                if (blockingQueue.isEmpty()) {
                    wait(5);//wait till producer has added to queue;
                }
                int val = blockingQueue.poll();
                System.out.println("Consumer thread has consumed item " + val);


            } catch (Exception e) {
                System.out.println("Exception occured in consumer thread" + this.getName() + "while consuming elements in queue");

            }

        }

    }
}


/**
 *
 */