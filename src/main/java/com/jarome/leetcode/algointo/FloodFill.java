package com.jarome.leetcode.algointo;

import java.util.Arrays;

/**
 * 733.图像渲染
 */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int s = image[sr][sc];
        if(s == newColor){
            return image;
        }
        image[sr][sc] = newColor;
        if (sr > 0 && image[sr - 1][sc] == s) {
            image = floodFill(image, sr - 1, sc, newColor);
        }
        if (sr < image.length - 1 && image[sr + 1][sc] == s) {
            image = floodFill(image, sr + 1, sc, newColor);
        }
        if (sc > 0 && image[sr][sc - 1] == s) {
            image = floodFill(image, sr, sc - 1, newColor);
        }
        if (sc < image[0].length - 1 && image[sr][sc + 1] == s) {
            image = floodFill(image, sr, sc + 1, newColor);
        }
        return image;
    }

    public static void main(String[] args) {
        FloodFill f = new FloodFill();
        System.out.println(Arrays.deepToString(f.floodFill(new int[][]{{0, 0, 0}, {0, 1, 1}}, 1, 1, 1)));
    }
}
