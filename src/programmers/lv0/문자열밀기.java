package programmers.lv0;

public class 문자열밀기 {

	public int solution(String A, String B) {
		if (A.equals(B)) return 0;
		int N = A.length();
		for (int i = 1; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(A.substring(i));
			sb.append(A.substring(0, i));
			if (B.equals(sb.toString())) return N - i;
		}
		return -1;
	}
}
