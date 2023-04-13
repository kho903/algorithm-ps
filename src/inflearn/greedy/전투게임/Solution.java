package inflearn.greedy.전투게임;

import java.util.*;

public class Solution {
	public int[] solution(String[] students) {
		int N = students.length;
		int[] answer = new int[N];
		Student[] arr = new Student[N];
		Map<String, Integer> team = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String[] s = students[i].split(" ");
			arr[i] = new Student(i, s[0], Integer.parseInt(s[1]));
		}
		Arrays.sort(arr);
		int sum = 0;
		int j = 0;
		for (int i = 1; i < N; i++) {
			for (; j < N; j++) {
				if (arr[j].attack < arr[i].attack) {
					sum += arr[j].attack;
					String t = arr[j].team;
					team.put(t, team.getOrDefault(t, 0) + arr[j].attack);
				} else break;
			}
			answer[arr[i].idx] = sum - team.getOrDefault(arr[i].team, 0);
		}
		return answer;
	}

	static class Student implements Comparable<Student> {
		int idx;
		String team;
		int attack;

		public Student(int idx, String team, int attack) {
			this.idx = idx;
			this.team = team;
			this.attack = attack;
		}

		@Override
		public int compareTo(Student o) {
			return this.attack - o.attack;
		}

		@Override
		public String toString() {
			return "Student{" +
				"idx=" + idx +
				", team='" + team + '\'' +
				", attack=" + attack +
				'}';
		}
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(
			Arrays.toString(T.solution(new String[] {"a 20", "b 12", "a 10", "c 11", "e 12"})));
		System.out.println(
			Arrays.toString(T.solution(new String[] {"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
		System.out.println(
			Arrays.toString(T.solution(new String[] {"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
		System.out.println(
			Arrays.toString(T.solution(new String[] {"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
	}
}