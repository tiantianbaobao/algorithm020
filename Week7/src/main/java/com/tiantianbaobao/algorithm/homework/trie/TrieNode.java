package com.tiantianbaobao.algorithm.homework.trie;

/***
 * @description 自定义实现一个字典树Trie
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2021-01-02 0:11
 * @since V1.0.0
 */
public class TrieNode {
    /***
     * 每一个字母所扩展出去的下一层的节点列表
     */
    private TrieNode[] partList;
    /***
     * 定义树的分叉数，即从a -> z,共26
     */
    private final Integer range = 26;
    /***
     * 是否到达最末级，即是否已经结束
     */
    private Boolean end;

    public Boolean isEnd() {
        return end;
    }

    public void setEnd() {
        this.end = true;
    }

    public TrieNode(){
        partList = new TrieNode[range];
    }

    public boolean containKeys(char cell) {
        return partList[cell - 'a'] != null;
    }

    public void put(char cell, TrieNode node) {
        partList[cell - 'a'] = node;
    }

    public TrieNode get(char cell) {
        return partList[cell - 'a'];
    }

}
