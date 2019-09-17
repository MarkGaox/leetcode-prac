package com.company;
import java.util.*;
import java.io.*;


class Solution {

    public static void main(String[] args) {
       // char[][] test = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
       // System.out.println(exist(test, "ABCCED"));
//        char[][] test = {{'a','a'}};
//        System.out.println(exist(test, "aa"));
        myPow(2, 13);
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        if (board.length == board[0].length && board[0].length == 1) {
            return board[0][0] == word.charAt(0);
        }

        if (word.equals("")) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            int index = searchRow(i, board, word.charAt(0));
            if (index == -1) {
                continue;
            } else {
                while (index < board[i].length & board[i][index] == word.charAt(0)) {
                    // search for the word
                    boolean a = searchWord(board, word, i, index, 0, new boolean[board.length][board[0].length]);
                    if (a) {
                        return a;
                    }
                    index++;
                }
            }
        }
        return false;
    }

    // use binary search in row finding
    private static int searchRow(int row, char[][] board, char target) {
        if (board[row].length == 1) {
            return board[row][0] == target ? 0 : -1;
        }

        int left = 0;
        int right = board[row].length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (board[row][mid] > target) {
                right = mid;
            } else if (board[row][mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if(board[row][left] == target) {
            return left;
        }
        if (board[row][right] == target) {
            return right;
        }
        return -1;
    }

    // explore given index
    private static boolean searchWord(char[][] board, String target, int row, int coloum, int strIndex, boolean[][] visited) {
        // out of bound
        if (coloum < 0 || row < 0 || coloum >= board[0].length || row >= board.length || visited[row][coloum]) {
            return false;
        }

        // when we're at last char
        if (strIndex == target.length() - 1 && target.charAt(strIndex) == board[row][coloum]) {
            return true;
        } else if (target.charAt(strIndex) != board[row][coloum]) {
            return false;
        } else {
            // current char is correct we need to use other
            visited[row][coloum] = true;
            boolean up = searchWord(board, target, row + 1, coloum, strIndex + 1, visited);
            boolean down = searchWord(board, target, row - 1, coloum, strIndex + 1, visited);
            boolean right = searchWord(board, target, row, coloum + 1, strIndex + 1, visited);
            boolean left = searchWord(board, target, row, coloum - 1, strIndex + 1, visited);

            visited[row][coloum] = false;
            return up || down || right || left;
        }
    }

        public static double myPow(double x, int n) {
            long N = n;
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }
            double ans = 1;
            double current_product = x;
            for (long i = N; i > 0; i /= 2) {
                if ((i % 2) == 1) {
                    ans = ans * current_product;
                }
                current_product = current_product * current_product;
            }
            return ans;
        }

}