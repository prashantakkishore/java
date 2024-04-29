package com.pks.ds.graph;

public class WordSearch_Practice {


    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i , j, 0))
                    return true;
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board, String word, int i , int j, int wordIndex){
        if (word.length() == wordIndex)
            return true;
        if (!valid(board, word, i, j , wordIndex))
            return false;
        dfs(board, word, i-1, j , wordIndex);
        dfs(board, word, i+1, j , wordIndex);
        dfs(board, word, i, j-1 , wordIndex);
        dfs(board, word, i, j +1, wordIndex);
        return false;
    }

    private static boolean valid(char[][] board, String word, int i , int j, int wordIndex){
        if (i > 0 && j> 0 && i < board.length && j < board[0].length && board[i][j] == word.charAt(wordIndex))
            return true;
        else return false;
    }

}
