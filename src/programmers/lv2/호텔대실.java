package programmers.lv2;

import java.util.*;

public class 호텔대실 {
	public int solution(String[][] book_time) {
		int N = book_time.length;

		Arrays.sort(book_time, (o1, o2) -> {
			if (o1[0].equals(o2[0]))
				return o1[1].compareTo(o2[1]);
			else return o1[0].compareTo(o2[0]);
		});

		int[][] book = new int[N][2];
		for (int i = 0; i < N; i++) {
			int start = Integer.parseInt(book_time[i][0].replace(":", ""));
			int end = Integer.parseInt(book_time[i][1].replace(":", ""));

			end += 10;
			if (end % 100 >= 60) {
				// end += 100;
				// end -= 60;
				end += 40;
			}
			book[i][0] = start;
			book[i][1] = end;
		}

		List<Integer> room = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			Collections.sort(room);
			boolean flag = false;

			if (room.size() > 0 && book[i][0] >= room.get(0)) {
				flag = true;
				room.set(0, book[i][1]);
			}
			if (!flag) room.add(book[i][1]);
		}

		return room.size();
	}
}
