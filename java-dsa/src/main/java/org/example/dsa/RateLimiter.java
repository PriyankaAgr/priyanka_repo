package org.example.dsa;

import java.util.Deque;
import java.util.HashMap;
import java.util.*;

public class RateLimiter {
    private final long windowDuration;
    private final int threshold;
    private int customerCredit;
    private final Map<Integer, Queue<Long>> userSlidingWindow = new HashMap<>();
    private final Map<Integer, Customer> customerMap = new HashMap<>();


    public RateLimiter(long windowDuration, int threshold, int customerCredit){
        this.windowDuration = windowDuration;
        this.threshold = threshold;
        this.customerCredit = customerCredit;
    }

    public boolean allowedRequest(int customerId){
        Queue<Long> slidingWindow = userSlidingWindow
                .computeIfAbsent(customerId, k -> new LinkedList<>());
        long currentTime = System.currentTimeMillis();
        Customer customer = customerMap.computeIfAbsent(customerId, k->new Customer(threshold,windowDuration, customerCredit));

        while(!slidingWindow.isEmpty() && currentTime-slidingWindow.peek()>customer.getWindowDuration()){
            slidingWindow.poll();
        }
        if(!slidingWindow.isEmpty()&& slidingWindow.size()<customer.getThreshold()){
            customer.setCustomerCredit(customer.getCustomerCredit()+(customer.getThreshold()-slidingWindow.size()));
        }

        int totalThreshold = customer.getThreshold()+customer.getCustomerCredit();
        if(slidingWindow.size()<totalThreshold){
            slidingWindow.offer(currentTime);
            return true;
        }
        return false;

    }
}

class Customer{

    int customerId;
    String customerName;
    int threshold;
    long windowDuration;
    int customerCredit;

    public Customer(int threshold, long windowDuration, int customerCredit) {
        this.threshold = threshold;
        this.windowDuration = windowDuration;
        this.customerCredit = customerCredit;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public long getWindowDuration() {
        return windowDuration;
    }

    public void setWindowDuration(long windowDuration) {
        this.windowDuration = windowDuration;
    }

    public int getCustomerCredit() {
        return customerCredit;
    }

    public void setCustomerCredit(int customerCredit) {
        this.customerCredit = customerCredit;
    }
}