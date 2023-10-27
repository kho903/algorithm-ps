package boj.pq._1655;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (minHeap.size() == maxHeap.size()) maxHeap.offer(num);
            else minHeap.offer(num);

            if (!minHeap.isEmpty() && !maxHeap.isEmpty() && (minHeap.peek() < maxHeap.peek())) {
                int poll = minHeap.poll();
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(poll);
            }
            sb.append(maxHeap.peek()).append('\n');
        }
        System.out.print(sb);
    }

}
