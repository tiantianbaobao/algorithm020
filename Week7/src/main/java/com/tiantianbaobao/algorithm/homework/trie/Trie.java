package com.tiantianbaobao.algorithm.homework.trie;

/***
 * @description 自定义实现trie
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2021-01-02 0:32
 * @since V1.0.0
 */
public class Trie {

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }
    /***
     * 插入一个单词
     * @param word
     */
    public void insertWord(String word){
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i< chars.length; i++) {
            if (!node.containKeys(chars[i])){
                node.put(chars[i], new TrieNode());
            }else {
                node = node.get(chars[i]);
            }
        }
        node.setEnd();
    }

    /***
     * 查询当前单词是否存在
     * @param word
     * @return
     */
    public boolean findWord(String word) {
        TrieNode node = search(word);
        return node != null && node.isEnd();
    }

    private TrieNode search(String word) {
        TrieNode node = root;
        if (word == null || "".equals(word)){
            return null;
        }
        for (int i = 0; i < word.length(); i++) {
            char cell = word.charAt(i);
            if (!root.containKeys(cell)){
                return null;
            }
            node = root.get(cell);
        }
        return node;
    }

    /***
     * 前缀查询是否存在
     * @param pre
     * @return
     */
    public boolean startWithPre(String pre) {
        TrieNode node = search(pre);
        return node != null;
    }
}
