package com.jarome.leetcode.hw;

/**
 * 整数反转
 */
public class ReverseInt {

    public int reverse(int x) {
        if (x == -2147483648) {
            return 0;
        }
        int res = 0;
        int temp = Math.abs(x);
        while (temp != 0) {
            if (Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE / 10 <= res && Integer.MAX_VALUE % 10 < temp % 10)) {
                return 0;
            }
            res = res * 10 + temp % 10;
            temp = temp / 10;
        }
        if(x < 0 ){
            res = -res;
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseInt r = new ReverseInt();
        System.out.println(r.reverse(-2147483648));
    }
}

//2147483648
//1534236469