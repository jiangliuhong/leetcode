package com.jarome.leetcode.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {

    // 存储 已经克隆的，减少内存消耗
    private HashMap<Node, Node> cache = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Node copy = cache.get(node);
        if (copy != null) {
            return copy;
        }
        copy = new Node(node.val);
        cache.put(node, copy);
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));
        }
        return copy;
    }

}