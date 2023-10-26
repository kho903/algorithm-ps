package boj.math._1614;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int finger = Integer.parseInt(br.readLine());
        long time = Long.parseLong(br.readLine());
        long answer = finger - 1;
        switch (finger) {
            case 1:
            case 5:
                answer += time * 8;
                break;
            case 2:
            case 3:
            case 4:
                answer += (time / 2) * 8 + (time % 2) * (8 - (finger - 1) * 2);
                break;
        }
        System.out.println(answer);
    }
}
