package programmers.lv0;

public class 이진수더하기 {

	public String solution(String bin1, String bin2) {
		int answer = Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2);
		return Integer.toBinaryString(answer);
	}
}
