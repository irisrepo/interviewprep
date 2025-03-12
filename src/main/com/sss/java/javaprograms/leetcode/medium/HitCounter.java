package src.main.com.sss.java.javaprograms.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;


public class HitCounter {

    private Queue<Integer> hits;

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {
        hits = new LinkedList<>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        hits.offer(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        // Remove hits that are outside the 5-minute window
        while (!hits.isEmpty() && hits.peek() <= timestamp - 300) {
            hits.poll();
        }
        return hits.size();
    }


    public static void main(String[] args) {
        HitCounter counter = new HitCounter();

        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println(counter.getHits(4)); // Output: 3

        counter.hit(300);
        System.out.println(counter.getHits(300)); // Output: 4
        System.out.println(counter.getHits(301)); // Output: 3
    }
}

