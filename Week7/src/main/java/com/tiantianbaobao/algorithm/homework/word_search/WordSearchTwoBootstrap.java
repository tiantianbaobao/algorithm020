package com.tiantianbaobao.algorithm.homework.word_search;

import com.tiantianbaobao.algorithm.homework.trie.Trie;

import java.util.ArrayList;
import java.util.List;

/***
 * @description word search-ii
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2021-01-03 21:10
 * @since V1.0.0
 */
public class WordSearchTwoBootstrap {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        List<String> searchRes = wordSearch(board, words);
        System.err.println("searchRes -> " + searchRes);
    }

    private static List<String> wordSearch(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return res;
        }
        Trie trie = new Trie();
        for (String word : words) {
            trie.insertWord(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, res, trie, "");
            }
        }
        return res;
    }

    private static void dfs(char[][] board, int i, int j, List<String> res, Trie trie, String str) {
        int[] xRange = {-1, 1, 0, 0};
        int[] yRange = {0, 0, -1, 1};
        char [][] visited = new char[][]{};
        String current = str + board[i][j];
        if (trie.findWord(current)) {
            res.add(current);
            return;
        }
        if (trie.startWithPre(current)) {
            char c = '#';
            visited[i][j] = c;
            c = board[i][j];
            board[i][j] = visited[i][j];
            for (int k = 0; k < 4; k++) {
                if (0 <= i + xRange[k] && i + xRange[k] < board.length && 0 <= j + yRange[k] && j + yRange[k] < board[0].length) {
                    dfs(board, i + xRange[k], j + yRange[k], res, trie, current);
                }
            }
            board[i][j] = c;
        }
    }


}
