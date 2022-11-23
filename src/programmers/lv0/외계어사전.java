package programmers.lv0;

public class 외계어사전 {
	public static void main(String[] args) {
		외계어사전 s = new 외계어사전();
		System.out.println(s.solution(new String[] {"p", "o", "s"}, new String[] {"sod", "eocd", "qixm", "adio", "soo"}));
	}

	public int solution(String[] spell, String[] dic) {
		boolean flag;
		for (String word : dic) {
			flag = true;
			for (String s : spell) {
				if (!word.contains(s)) flag = false;
			}
			if (flag) return 1;
		}
		return 2;
	}
}
