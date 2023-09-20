package programmers.lv2;
import java.util.*;

public class 과제진행하기 {
	public String[] solution(String[][] plans) {

		int N = plans.length;

		String[] answer = new String[N];

		PriorityQueue<Subject> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {

			pq.offer(new Subject(plans[i][0], timeCalc(plans[i][1]), Integer.parseInt(plans[i][2])));
		}

		Stack<Subject> waiting = new Stack<>();
		int ansIdx = 0;
		Subject curSubject = pq.poll();
		int curTime = curSubject.time;
		while (!pq.isEmpty()) {
			Subject peek = pq.peek();
			if (curTime + curSubject.v <= peek.time) {
				answer[ansIdx++] = curSubject.name;
				curTime += curSubject.v;
				if (!waiting.isEmpty() && curTime < peek.time) {
					curSubject = waiting.pop();
					curSubject.time = curTime;
				}
				else
					curSubject = pq.poll();
			} else {
				curSubject.v -= (peek.time - curTime);
				waiting.push(curSubject);
				curSubject = pq.poll();
			}
			curTime = curSubject.time;
		}
		answer[ansIdx++] = curSubject.name;
		while (!waiting.isEmpty()) {
			Subject s = waiting.pop();
			answer[ansIdx++] = s.name;
		}

		return answer;
	}

	int timeCalc(String time) {
		String[] s = time.split(":");

		return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
	}
}

class Subject implements Comparable<Subject> {

	String name;
	int time;
	int v;

	Subject(String name, int time, int v) {
		this.name = name;
		this.time = time;
		this.v = v;
	}

	Subject(Subject subject) {
		this.name = subject.name;
		this.time = subject.time;
		this.v = subject.v;
	}

	public int compareTo(Subject o) {
		return this.time - o.time;
	}

	public String toString() {
		return this.name + " " + this.time + " " +this.v;
	}
}