package com.pks.ds.graph;

public class WordSearch {


    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) { // row
            for (int j = 0; j < board[0].length; j++) { // column
                if(board[i][j] == word.charAt(0) && dfs(board, i , j , 0, word)) {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int matchedLetterCount, String word) {
        if (matchedLetterCount == word.length())
            return true;
        if(i < 0 || i > board.length || j < 0 || j > board[0].length || board[i][j] != word.charAt(matchedLetterCount))
            return false;

        // So we dont repeat same cell, mark as blank and restore later after dfs
        char tmp = board[i][j];
        board[i][j] = ' ';

        // check left, right, top, bottom
        boolean found = dfs(board, i + 1 , j , matchedLetterCount + 1 , word)
                        || dfs(board, i - 1 , j , matchedLetterCount + 1 , word)
                        || dfs(board, i  , j + 1  , matchedLetterCount + 1 , word)
                        || dfs(board, i , j - 1 , matchedLetterCount + 1 , word);

        board[i][j] = tmp;

        return found;
    }


}
