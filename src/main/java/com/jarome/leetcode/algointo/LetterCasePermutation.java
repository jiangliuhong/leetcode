package com.jarome.leetcode.algointo;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        rec(result, s, 0, stringBuilder);
        return result;
    }

    private void rec(List<String> result, String s, int index, StringBuilder stringBuilder) {
        if (s.length() == index) {
            result.add(stringBuilder.toString());
            return ;
        }
        char c = s.charAt(index);
        List<Integer> way = new ArrayList<>();
        way.add(0);
        if (c >= 65 && c <= 90) {
            way.add(1);
        } else if (c >= 97 && c <= 122) {
            way.add(-1);
        }
        for (Integer w : way) {
            stringBuilder.append((char)(c + w * 32));
            rec(result, s, index + 1, stringBuilder);
            stringBuilder.deleteCharAt(index);
        }
    }

    public List<String> letterCasePermutation2(String s) {
        char[] chars = s.toCharArray();
        List<int[]> status = new ArrayList<>();
        for (int index = 0; index < chars.length; index++) {
            char c = chars[index];
            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                if (status.isEmpty()) {
                    int[] st1 = new int[12];
                    int[] st2 = new int[12];
                    st1[index] = c >= 97 ? -1 : 1;
                    st2[index] = 0;
                    status.add(st1);
                    status.add(st2);
                } else {
                    int size = status.size();
                    for (int i1 = 0; i1 < size; i1++) {
                        int[] st1 = status.get(i1);
                        int[] st2 = st1.clone();
                        st1[index] = c >= 97 ? -1 : 1;
                        st2[index] = 0;
                        status.add(st2);
                    }
                }
            }
        }
        List<String> list = new ArrayList<>();
        if (status.isEmpty()) {
            list.add(s);
            return list;
        }
        for (int i = 0; i < status.size(); i++) {
            int[] ints = status.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chars.length; j++) {
                sb.append(chars[j] + 32 * ints[j]);
            }
            list.add(sb.toString());
        }
        return list;
    }

}
