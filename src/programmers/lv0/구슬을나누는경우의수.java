package programmers.lv0;

import java.math.BigInteger;

public class 구슬을나누는경우의수 {

	public BigInteger solution(int balls, int share) {
		if (share == 1) return BigInteger.valueOf(balls);
		BigInteger ans = BigInteger.ONE;
		share = Math.min(share, balls - share);
		int cnt = share;
		while (cnt > 0) {
			ans = ans.multiply(BigInteger.valueOf(balls));
			cnt--;
			balls--;
		}
		while (share > 1) {
			ans = ans.divide(BigInteger.valueOf(share));
			share--;
		}
		return ans;
	}
}
