package com.tiantianbaobao.algorithm.homework.trie;

/***
 * @description main
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2021-01-02 0:49
 * @since V1.0.0
 */
public class TrieBootstrap {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("hello");
//        trie.insertWord("world");
//        trie.insertWord("i");
//        trie.insertWord("am");
//        trie.insertWord("jack");
//
        System.err.println("has rose ? " + trie.findWord("rose"));
        System.err.println("has jack ? " + trie.findWord("jack"));
        System.err.println("start with hel ? " + trie.startWithPre("hel"));
        System.err.println("start with llo ? " + trie.startWithPre("llo"));
    }
}
