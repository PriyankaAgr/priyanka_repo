package org.example.dsa;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ProdConsProblem {

    public static void main(String[] args){
        ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(10);
        Thread t1 = new Thread(new Producer(buffer,1));
        Thread t2 = new Thread(new Producer(buffer,2));
        Thread t3 = new Thread(new Producer(buffer,3));
        Thread t4 = new Thread(new Consumer(buffer,1));
        Thread t5 = new Thread(new Consumer(buffer,2));
        Thread t6 = new Thread(new Consumer(buffer,3));


    }

}

    class Producer implements Runnable {

    private final ArrayBlockingQueue<Integer> buffer;
    private final Integer id;

        Producer(ArrayBlockingQueue<Integer> buffer, int id){
            this.buffer = buffer;
            this.id=id;
        }

        @Override
        public void run() {
            try{
                int item = ThreadLocalRandom.current().nextInt(100);
                buffer.put(item);
                System.out.println("ProducerId: "+id+","+"produced: "+item);
                Thread.sleep(500);

            }
            catch (InterruptedException ex){
                Thread.currentThread().interrupt();

            }


        }
    }

    class  Consumer implements Runnable{

        private final ArrayBlockingQueue<Integer> buffer;
        private final Integer id;

        Consumer(ArrayBlockingQueue<Integer> buffer, int id){
            this.buffer = buffer;
            this.id=id;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    int item = buffer.take();
                    System.out.println("ConsumerId: " + id + "," + "consumed: " + item);
                    Thread.sleep(500);

                }
            }
            catch (InterruptedException ex){
                Thread.currentThread().interrupt();

            }


        }
    }