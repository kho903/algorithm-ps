package programmers.lv0;

public class 숫자찾기 {

	public int solution(int num, int k) {
		String str = String.valueOf(num);
		String kk = String.valueOf(k);
		if (str.contains(kk)) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == kk.charAt(0)) return i + 1;
			}
		}
		return -1;
	}
}
