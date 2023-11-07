package programmers.lv3;

import java.util.*;

public class 인사고과 {

    public int solution(int[][] scores) {
        int answer = 1;
        int wanho1 = scores[0][0];
        int wanho2 = scores[0][1];
        int wanho = wanho1 + wanho2;

        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] < o2[0]) return 1;
            else if (o1[0] == o2[0]) {
                if (o1[1] > o2[1]) return 1;
                else return -1;
            }
            return -1;
        });
        int N = scores.length;
        int tmp = 0;
        for (int i =0; i < N; i++) {
            if (wanho1 < scores[i][0] && wanho2 < scores[i][1]) return -1;
            if (tmp <= scores[i][1]) {
                if (wanho < scores[i][0] + scores[i][1]) answer++;
                tmp = scores[i][1];
            }
        }
        return answer;
    }
}
