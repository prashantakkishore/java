package com.pks.ds.strings;

import java.util.HashMap;
import java.util.Map;

public class BasicTrie {

	public TrieNode root;

	public BasicTrie() {
		root = new TrieNode();
	}

	private class TrieNode {
		
		@SuppressWarnings("unused")
		public Character ch;
		public Map<Character, TrieNode> children;
		public boolean isLeaf;

		public TrieNode() {
			children = new HashMap<Character, BasicTrie.TrieNode>();
		}

		public TrieNode(Character ch) {
			this();
			this.ch = ch;

		}
	}

	public void insert(String word) {

		Map<Character, TrieNode> children = root.children;

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node;
			if (children.containsKey(ch)) {
				node = children.get(ch);
			} else {
				node = new TrieNode(word.charAt(i));
				children.put(ch, node);
			}

			children = node.children;
			// set leaf node
			if (i == word.length() - 1)
				node.isLeaf = true;
		}
	}

	public boolean search(String word) {
		TrieNode t = searchNode(word);

		if (t != null && t.isLeaf)
			return true;
		else
			return false;
	}

	public boolean startsWith(String prefix) {
		if (searchNode(prefix) == null)
			return false;
		else
			return true;
	}

	public TrieNode searchNode(String word) {
		Map<Character, TrieNode> children = root.children;
		TrieNode node = null;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);

			if (children.containsKey(ch)) {
				node = children.get(ch);
				children = node.children;
			} else {
				return null;
			}

		}
		return node;

	}
	
	public static void main(String[] args) {
		BasicTrie bt = new BasicTrie();
		bt.insert("bear");
		bt.insert("bell");
		bt.insert("bid");
		bt.insert("bull");
		bt.insert("buy");
		bt.insert("sell");
		bt.insert("stock");
		bt.insert("stop");
		
		System.out.println(bt.search("buy")); // true
		System.out.println(bt.search("bed")); // true
		System.out.println(bt.startsWith("sto")); // true
		
	}

}
