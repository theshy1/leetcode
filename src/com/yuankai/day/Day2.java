package com.yuankai.day;

import java.util.*;

public class Day2 {
    // 820. 单词的压缩编码   自己使用的暴力破解，太丑陋了。。官方题解中使用的字典树确实优秀
    public int minimumLengthEncoding(String[] words) {
        int count = 0;
        List<String> list = new ArrayList<>();
        Arrays.sort(words, Comparator.comparing(String::length));
        for(int i = words.length - 1; i >= 0; i++) {
            String word = words[i];
            if (list.stream().noneMatch(s -> s.endsWith(word))) {
                list.add(word);
                count += word.length()+1;
            }
        }
        return count;
    }
/*
    public int minimumLengthEncoding(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j)
                cur = cur.get(word.charAt(j));
            nodes.put(cur, i);
        }

        int ans = 0;
        for (TrieNode node: nodes.keySet()) {
            if (node.count == 0)
                ans += words[nodes.get(node)].length() + 1;
        }
        return ans;

    }

    class TrieNode {
        TrieNode[] children;
        int count;
        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
        public TrieNode get(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
                count++;
            }
            return children[c - 'a'];
        }
    }*/
}
