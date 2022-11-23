package programmers.lv0;

public class 다음에올숫자 {

	public int solution(int[] common) {
		int answer = 0;
		boolean isSub = false;
		int sub = -1;
		if (common[1] - common[0] == common[2] - common[1]) {
			isSub = true;
			sub = common[1] - common[0];
		}
		int N = common.length;
		if (isSub)
			return common[N - 1] + sub;
		return common[N - 1] * common[1] / common[0];
	}
}
