package com.jarome.leetcode.test3;

public class SolutionRevse {
    public int reverse(int x) {
        int res  = 0;
        while(x != 0){
            // 取最后一数字
            int r = x % 10;
            // 判断会不会溢出
            // 大于7 小于-8 是因为最大的数为 2 147 483 648，最后一位为8
            if((Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE / 10 == res && r > 7) )
            || Integer.MIN_VALUE / 10 > res || (Integer.MIN_VALUE / 10 == res && r < -8)){
                return 0;
            }
            res  = res * 10 + r;
            x = x /10;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = -123;
        SolutionRevse sr = new SolutionRevse();
        int reverse = sr.reverse(i);
        System.out.println(reverse);
    }
}
