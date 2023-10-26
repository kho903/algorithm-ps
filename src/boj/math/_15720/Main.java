package boj.math._15720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer stk;
    static BufferedReader br;
    static int B, C, D, allPrice, min, salePrice;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());
        B = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        D = Integer.parseInt(stk.nextToken());
        allPrice = 0;
        min = Math.min(B, Math.min(C, D));
        List<Integer> burger = new ArrayList<>();
        List<Integer> side = new ArrayList<>();
        List<Integer> drink = new ArrayList<>();
        makeMenu(B, burger);
        makeMenu(C, side);
        makeMenu(D, drink);
        burger.sort(Collections.reverseOrder());
        side.sort(Collections.reverseOrder());
        drink.sort(Collections.reverseOrder());
        salePrice = 0;
        calcSalePrice(B, burger);
        calcSalePrice(C, side);
        calcSalePrice(D, drink);
        System.out.println(allPrice);
        System.out.println(salePrice);
    }

    private static void calcSalePrice(int len, List<Integer> menu) {
        for (int i = 0; i < len; i++) {
            if (i < min) salePrice += menu.get(i) * 0.9;
            else salePrice += menu.get(i);
        }
    }

    private static void makeMenu(int len, List<Integer> menu) throws IOException {
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < len; i++) {
            int x = Integer.parseInt(stk.nextToken());
            menu.add(x);
            allPrice += x;
        }
    }

}
