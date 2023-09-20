package programmers.lv2;
import java.util.*;

public class 디펜스게임 {
	public int solution(int n, int k, int[] enemy) {
		int enemyLen = enemy.length;
		int answer = enemyLen;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < enemyLen; i++) {
			n -= enemy[i];
			pq.offer(enemy[i]);

			if (n < 0) {
				if (k > 0) {
					n += pq.poll();
					k--;
				} else {
					answer = i;
					break;
				}
			}
		}
		return answer;
	}
}