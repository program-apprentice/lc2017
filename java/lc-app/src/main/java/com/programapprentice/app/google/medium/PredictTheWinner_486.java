package com.programapprentice.app.google.medium;

import java.util.LinkedList;
import java.util.Queue;

public class PredictTheWinner_486 {
    /**
     https://leetcode.com/problems/predict-the-winner/description/
     Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the
     array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will
     not be available for the next player. This continues until all the scores have been chosen. The player with the
     maximum score wins.

     Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize
     his score.

     Example 1:
     Input: [1, 5, 2]
     Output: False
     Explanation: Initially, player 1 can choose between 1 and 2.
     If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be
     left with 1 (or 2).
     So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
     Hence, player 1 will never be the winner and you need to return False.
     Example 2:
     Input: [1, 5, 233, 7]
     Output: True
     Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player
     2 choose, player 1 can choose 233.
     Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
     Note:
     1 <= length of the array <= 20.
     Any scores in the given array are non-negative integers and will not exceed 10,000,000.
     If the scores of both players are equal, then player 1 is still the winner.

     Solution:
     http://www.cnblogs.com/grandyang/p/6369688.html
     * */
    class Game {
        int start;
        int end;
        int p1Score;
        int p2Score;
        boolean nextPlayer; // true => p1; false => p2;
        public Game(int start, int end, int p1Score, int p2Score, boolean nextPlayer) {
            this.start = start;
            this.end = end;
            this.p1Score = p1Score;
            this.p2Score = p2Score;
            this.nextPlayer = nextPlayer;
        }
    }

    public boolean PredictTheWinnerWrong(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        Queue<Game> queue = new LinkedList<Game>();
        int n = nums.length;
        queue.add(new Game(0, n-1, 0, 0, true));
        while(!queue.isEmpty()) {
            Game game = queue.remove();
            if (game.start == game.end) {
                if (game.nextPlayer) {
                    game.p1Score += nums[game.start];
                } else {
                    game.p2Score += nums[game.start];
                }
                if (game.p1Score < game.p2Score) {
                    return false;
                }
            } else {
                if (game.nextPlayer) {
                    queue.add(new Game(game.start + 1, game.end, game.p1Score + nums[game.start], game.p2Score, !game.nextPlayer));
                    queue.add(new Game(game.start, game.end-1, game.p1Score + nums[game.end], game.p2Score, !game.nextPlayer));
                } else {
                    queue.add(new Game(game.start + 1, game.end, game.p1Score, game.p2Score + nums[game.start], !game.nextPlayer));
                    queue.add(new Game(game.start, game.end-1, game.p1Score, game.p2Score + nums[game.end], !game.nextPlayer));
                }
            }
        }
        return true;
    }

    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        int n = nums.length;
        return canWin(new Game(0, n-1, 0, 0, true), nums);
    }
    private boolean canWin(Game game, int[] nums) {
        if (game.start == game.end) {
            if (game.nextPlayer) {
                game.p1Score += nums[game.start];
            } else {
                game.p2Score += nums[game.start];
            }
            return game.p1Score > game.p2Score;
        }
        if (game.nextPlayer) {
            return !canWin(new Game(game.start + 1, game.end, game.p1Score + nums[game.start], game.p2Score, !game.nextPlayer), nums)
                    || !canWin(new Game(game.start, game.end-1, game.p1Score + nums[game.end], game.p2Score, !game.nextPlayer), nums);
        } else {
            return !canWin(new Game(game.start + 1, game.end, game.p1Score, game.p2Score + nums[game.start], !game.nextPlayer), nums)
                    || !canWin(new Game(game.start, game.end-1, game.p1Score, game.p2Score + nums[game.end], !game.nextPlayer), nums);
        }

    }

}
/*

    bool canWin(vector<int> nums, int sum1, int sum2, int player) {
        if (nums.empty()) return sum1 >= sum2;
        if (nums.size() == 1) {
            if (player == 1) return sum1 + nums[0] >= sum2;
            else if (player == 2) return sum2 + nums[0] > sum1;
        }
        vector<int> va = vector<int>(nums.begin() + 1, nums.end());
        vector<int> vb = vector<int>(nums.begin(), nums.end() - 1);
        if (player == 1) {
            return !canWin(va, sum1 + nums[0], sum2, 2) || !canWin(vb, sum1 + nums.back(), sum2, 2);
        } else if (player == 2) {
            return !canWin(va, sum1, sum2 + nums[0], 1) || !canWin(vb, sum1, sum2 + nums.back(), 1);
        }
    }
};
 * */
