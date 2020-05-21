package com.devglan.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    Map<Character, TrieNode> node;
    boolean isWord;

    public TrieNode(){
        this.node = new HashMap<>();
    }

    public Map<Character, TrieNode> getNode() {
        return node;
    }

    public void setNode(Map<Character, TrieNode> node) {
        this.node = node;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }
}
