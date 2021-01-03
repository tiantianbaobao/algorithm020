package com.tiantianbaobao.algorithm.homework.word_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * @description
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2021-01-03 22:35
 * @since V1.0.0
 */
public class Boot {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        Boot boot = new Boot();
        List<String> searchRes = boot.findWords(board, words);
        System.err.println("searchRes -> " + searchRes);
    }
    class TrieNode {
        //指向子节点的连接
        private Map<Character, TrieNode> links;
        private boolean isEnd;

        private TrieNode() {
            links = new HashMap<>();
        }

        public boolean containsKey(char ch) {
            return links.containsKey(ch);
        }

        public TrieNode get(char ch) {
            return links.get(ch);
        }

        public void put(char ch, TrieNode node) {
            links.put(ch, node);
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    private TrieNode root;

    private void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    //在前缀树中查找键前缀或者整个键
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    /**
     * Returns if the word is in the trie.
     */
    private boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    private boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private int m;
    private int n;
    private char[][] board;
    private static final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        List<String> ans = new ArrayList<>();
        if (board.length == 0) {
            return ans;
        }
        m = board.length;
        n = board[0].length;
        root = new TrieNode();
        for (String word : words) {
            addWord(word);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                boolean[][] marked = new boolean[m][n];
                dfs(i, j, marked, sb, ans);
            }
        }
        return ans;
    }

    private void dfs(int x, int y, boolean[][] marked, StringBuilder sb, List<String> ans) {
        sb.append(board[x][y]);
        //terminator
        if (marked[x][y] || !startsWith(sb.toString())) {
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        marked[x][y] = true;
        String str = sb.toString();
        //processing
        if (search(str)) {
            //去重
            if (!ans.contains(str)) {
                ans.add(str);
            }
            //判断当前单词是否还作为前缀出现
            if (!startsWith(str)) {
                sb.deleteCharAt(sb.length() - 1);
                marked[x][y] = false;
                return;
            }
        }
        //drill down
        for (int k = 0; k < 4; k++) {
            int newX = x + directions[k][0];
            int newY = y + directions[k][1];
            if (inArea(newX, newY)) {
                dfs(newX, newY, marked, sb, ans);
            }
        }
        //reverse
        sb.deleteCharAt(sb.length() - 1);
        marked[x][y] = false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
