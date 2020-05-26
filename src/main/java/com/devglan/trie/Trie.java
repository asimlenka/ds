package com.devglan.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /*public List<String> suggestions(String prefix){
        List<String> list = new ArrayList<>();
        TrieNode current = root;
        int length = prefix.length();
        for (int i = 0; i < length; i++){
            TrieNode node = current.getNode().get(prefix.charAt(i));
            if (node == null){
                return list;
            }
            current = node;
        }
        if (current.isWord){
            list.add(prefix);
        }
        Map<Character, TrieNode> node = current.getNode();
        List<Map<Character,TrieNode>> nodes = new ArrayList<>();
        nodes.add(node);
        String[] word = {prefix};
        int i = 0;
        while (i != 15) {
            nodes.forEach(eachNode -> {
                node.entrySet().forEach(entry -> {
                    word[0] = word[0] + entry.getKey();
                    if (entry.getValue().isWord) {
                        list.add(word[0]);
                    } else {
                        Map map = new HashMap<>();
                        map.put(entry.getKey(), entry.getValue());
                        nodes.add(map);
                    }
                });
            });
        i++;
        }
        return list;
    }*/

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("dhiraj");
        trie.insert("niraj");
        System.out.println(trie.isCompleteWord("dhiraj"));
        System.out.println(trie.isValidPrefix("dha"));
        System.out.println(trie.isValidPrefix("ni"));

        //List<String> list = trie.suggestions("dhira");
        //System.out.println(list.size());
    }
}
