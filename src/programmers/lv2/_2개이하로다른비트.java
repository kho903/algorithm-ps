package programmers.lv2;

public class _2개이하로다른비트 {

	public long[] solution(long[] numbers) {
		int N = numbers.length;
		long[] answer = new long[N];
		for (int i = 0; i < N; i++) {
			if (numbers[i] % 2 == 0) answer[i] = numbers[i] + 1;
			else {
				String bin = Long.toBinaryString(numbers[i]);
				StringBuilder sb = new StringBuilder();
				if (!bin.contains("0")) {
					sb.append("10");
					sb.append(bin.substring(1));
				} else {
					int lastZeroI = bin.lastIndexOf("0");
					int firstOneI = bin.indexOf("1", lastZeroI);
					sb.append(bin, 0, lastZeroI).append("1");
					sb.append("0");
					sb.append(bin.substring(firstOneI + 1));
				}
				answer[i] = Long.parseLong(sb.toString());
			}
		}
		return answer;
	}
}
