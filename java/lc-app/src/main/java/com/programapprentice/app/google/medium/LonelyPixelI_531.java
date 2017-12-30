package com.programapprentice.app.google.medium;

public class LonelyPixelI_531 {
    /**
     https://leetcode.com/problems/lonely-pixel-i/description/
     Given a picture consisting of black and white pixels, find the number of black lonely pixels.

     The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels
     respectively.

     A black lonely pixel is character 'B' that located at a specific position where the same row and same column
     don't have any other black pixels.

     Example:
     Input:
     [['W', 'W', 'B'],
     ['W', 'B', 'W'],
     ['B', 'W', 'W']]

     Output: 3
     Explanation: All the three 'B's are black lonely pixels.

     Note:
     The range of width and height of the input 2D array is [1,500].
     * */
    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0] == null || picture[0].length == 0) {
            return 0;
        }
        int height = picture.length;
        int width = picture[0].length;
        int counter = 0;

        int[] rowsBlack = new int[height];
        int[] rowsBlackCounter = new int[height];
        int[] colsBlack = new int[width];
        int[] colsBlackCounter = new int[width];

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if (picture[i][j] == 'B') {
                    rowsBlack[i] = j;
                    rowsBlackCounter[i] += 1;
                    colsBlack[j] = i;
                    colsBlackCounter[j] += 1;
                }
            }
        }

        for(int i = 0; i < height; i++) {
            if (rowsBlackCounter[i] == 1 && colsBlackCounter[rowsBlack[i]] == 1) {
                counter ++;
            }
        }

        return counter;
    }
}
