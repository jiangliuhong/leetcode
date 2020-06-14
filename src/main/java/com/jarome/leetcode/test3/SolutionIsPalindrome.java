package com.jarome.leetcode.test3;

public class SolutionIsPalindrome {

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        if(end <= 0){
            return true;
        }
        // ASCII码，数字：48~57 a~z:97~122  A~Z: 65~90
        while (start < end) {
            int c1 = s.charAt(start);
            if(!isvalid(c1)){
                start++;
                continue;
            }
            int c2 = s.charAt(end);
            if(!isvalid(c2)){
                end--;
                continue;
            }
            if(c1 != c2){
                if(c1 >= 65 && c2>= 65){
                    if(Math.abs(c1-c2) != 32){
                        return false;
                    }
                }else {
                    return false;
                }
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isvalid(int acsii) {
        return (acsii >= 48 && acsii <= 57) || (acsii >= 97 && acsii <= 122) || (acsii >= 65 && acsii <= 90);
    }

    public static void main(String[] args) {
        SolutionIsPalindrome sp = new SolutionIsPalindrome();
//        String s = "A man, a plan, a canal: Panama";
        String s = "8V8K;G;K;V;";
        System.out.println( sp.isPalindrome(s));
    }

}
