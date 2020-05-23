package com.devglan.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode current = root;
        int length = word.length();
        for (int i = 0; i < length; i++){
            char letter = word.charAt(i);
            TrieNode node = current.getNode().get(letter);
            if (node == null){
                node = new TrieNode();
                current.getNode().put(letter, node);
            }
            current = node;
        }
        current.setWord(true);
    }

    public boolean isCompleteWord(String word){
        TrieNode current = root;
        int length = word.length();
        for (int i = 0; i < length; i++){
            char letter = word.charAt(i);
            TrieNode node = current.getNode().get(letter);
            if (node == null){
                return false;
            }
            current = node;
        }
        return current.isWord;
    }

    public boolean isValidPrefix(String prefix){
        TrieNode current = root;
        int length = prefix.length();
        for (int i = 0; i < length; i++){
            char letter = prefix.charAt(i);
            TrieNode node = current.getNode().get(letter);
            if (node == null){
                return false;
            }
            current = node;
        }
        return current != null;
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("dhiraj");
        trie.insert("niraj");
        System.out.println(trie.isCompleteWord("dhiraj"));
        System.out.println(trie.isValidPrefix("dha"));
        System.out.println(trie.isValidPrefix("ni"));
    }
}
