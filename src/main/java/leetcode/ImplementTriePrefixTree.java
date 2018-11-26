package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit.bhengra on 06/10/18.
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 */
public class ImplementTriePrefixTree {

    Node rootNode = new Node();

    /** Initialize your data structure here. */
    public ImplementTriePrefixTree() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chArr = word.toCharArray();
        Node currNode = rootNode;
        for(char ch: chArr){
            if(currNode.children.get(ch)!=null)
                currNode = currNode.children.get(ch);
            else{
                Node newNode = new Node();
                currNode.children.put(ch,newNode);
                currNode = newNode;
            }
        }
        currNode.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chArr = word.toCharArray();
        Node currNode = rootNode;
        for(char ch: chArr){
            if(currNode.children.get(ch)!=null)
                currNode = currNode.children.get(ch);
            else{
                return false;
            }
        }
        return currNode.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chArr = prefix.toCharArray();
        Node currNode = rootNode;
        for(char ch: chArr){
            if(currNode.children.get(ch)!=null)
                currNode = currNode.children.get(ch);
            else{
                return false;
            }
        }
        return true;
    }

    public class Node{
        Map<Character,Node> children = new HashMap<>();
        boolean end;
    }
}
