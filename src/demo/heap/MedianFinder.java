package demo.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @auther
 */

public class MedianFinder {

    PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;
    double median = 0;
    boolean isMax = false;
    long totalNums = 0;
    /** initialize your data structure here. */
    public MedianFinder() {
        this.minHeap = new PriorityQueue<Integer>();
        this.maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            minHeap.add(num);
            return;
        }

        if (!minHeap.isEmpty() && minHeap.peek() > num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        balanceHeaps();
    }

    private void balanceHeaps() {
        int minL = minHeap.size();
        int maxL = maxHeap.size();
        if (Math.abs(minL - maxL) > 1) {
            if (minL < maxL) {
                minHeap.add(maxHeap.poll());
            } else {
                maxHeap.add(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        int minL = minHeap.size();
        int maxL = maxHeap.size();

        if (minL == 0 && maxL == 0) return 0;
        if (minL == 0) return Double.valueOf(maxHeap.peek());
        if (maxL == 0) return Double.valueOf(minHeap.peek());

        double min = Double.valueOf(minHeap.peek());
        double max = Double.valueOf(maxHeap.peek());

        if (minL < maxL) return max;
        if (minL > maxL) return min;
        return (min + max) / 2;

    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
    }
}