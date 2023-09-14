package boj.greedy._2847;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Game> pq = new PriorityQueue<>((o1, o2) -> o2.level - o1.level);

		for (int i = 0; i < N; i++) {
			int s = Integer.parseInt(br.readLine());
			pq.offer(new Game(i, s));
		}

		int answer = 0;
		Game cur = pq.poll();
		while (!pq.isEmpty()) {
			Game poll = pq.poll();

			while (cur.score <= poll.score) {
				answer += 1;
				poll.score--;
			}
			cur = poll;
		}
		System.out.println(answer);
	}
}

class Game {
	int level;
	int score;

	public Game(int level, int score) {
		this.level = level;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Game{" +
			"level=" + level +
			", score=" + score +
			'}';
	}
}