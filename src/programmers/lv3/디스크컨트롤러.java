package programmers.lv3;

import java.util.*;

public class 디스크컨트롤러 {
	public int solution(int[][] jobs) {
		int N = jobs.length;
		Job[] jobsArray = new Job[N];
		for (int i = 0; i < N; i++) {
			jobsArray[i] = new Job(jobs[i][0], jobs[i][1]);
		}
		Arrays.sort(jobsArray, (o1, o2) -> o1.start - o2.start);

		Queue<Job> queue = new LinkedList<>(Arrays.asList(jobsArray));
		PriorityQueue<Job> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);

		int sumTime = 0;
		int curTime = 0;
		while (!queue.isEmpty() || !pq.isEmpty()) {
			while (!queue.isEmpty() && queue.peek().start <= curTime) {
				pq.add(queue.poll());
			}
			if (pq.isEmpty()) {
				curTime = queue.peek().start;
				continue;
			}
			Job job = pq.poll();
			sumTime += curTime + job.time - job.start;
			curTime += job.time;
		}

		return sumTime / N;
	}

	static class Job {
		int start;
		int time;

		Job(int start, int time) {
			this.start = start;
			this.time = time;
		}
	}
}