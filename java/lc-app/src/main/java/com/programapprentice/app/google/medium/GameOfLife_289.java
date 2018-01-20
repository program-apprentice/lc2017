package com.programapprentice.app.google.medium;

public class GameOfLife_289 {
    /**
     https://leetcode.com/problems/game-of-life/description/
     According to the Wikipedia's article: "The Game of Life, also known simply as Life,
     is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

     Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
     Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four
     rules (taken from the above Wikipedia article):

     Any live cell with fewer than two live neighbors dies, as if caused by under-population.
     Any live cell with two or three live neighbors lives on to the next generation.
     Any live cell with more than three live neighbors dies, as if by over-population..
     Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     Write a function to compute the next state (after one update) of the board given its current state.

     Follow up:
     Could you solve it in-place? Remember that the board needs to be updated at the same time:
     You cannot update some cells first and then use their updated values to update other cells.
     In this question, we represent the board using a 2D array. In principle, the board is infinite,
     which would cause problems when the active area encroaches the border of the array. How would you address these problems?

     Solution:
     https://www.jianshu.com/p/27024d85b5da
     * */
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        int height = board.length;
        int width = board[0].length;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                int count = 0;
                for(int x = Math.max(i-1, 0); x < Math.min(i+2, height); x++) {
                    for(int y = Math.max(j-1, 0); y < Math.min(j+2, width); y++) {
                        count += board[x][y] & 1;
                    }
                }
                count -= board[i][j] & 1;
                if (count == 3) {
                    if ((board[i][j] & 1) == 1) {
                        board[i][j] = 3; // 10 in binary, means turn to dead
                    } else {
                        board[i][j] = 2; // 10 in binary, means turn to dead
                    }

                } else if (count == 2 && (board[i][j] & 1) == 1) {
                    board[i][j] = 3;
                }
            }
        }
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
}
