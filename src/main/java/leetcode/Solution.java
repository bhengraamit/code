package leetcode;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 */

class SerializDeserializeBinaryTree {


    public static void main(String[] args){
        SerializDeserializeBinaryTree solution = new SerializDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        TreeNode left3 = new TreeNode(4);
        TreeNode right3 = new TreeNode(5);
        left.left = left3;
        left.right = right3;
        String serialize = solution.serialize(root);
        TreeNode deserialize = solution.deserialize(serialize);
        System.out.println(deserialize);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        List<String> serialized = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        serialize(queue,serialized);
        String commaSeparated = serialized.stream().collect(Collectors.joining(","));
        return "["+commaSeparated+"]";
    }

    public void serialize(Queue<TreeNode> queue, List<String> serialized){
        if(queue.isEmpty())
            return;
        TreeNode node = queue.poll();
        if(node == null){
            serialized.add("null");
        }else{
            serialized.add(String.valueOf(node.val));
            queue.add(node.left);
            queue.add(node.right);
        }
        serialize(queue,serialized);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty())
            return null;
        String temp = data.replaceAll("\\[","");
        String temp1 = temp.replaceAll("]","");
        List<String> nodeData = Arrays.asList(temp1.split(","));
        int treeSize = nodeData.size();
        TreeNode[] nodeList = new TreeNode[treeSize];
        TreeNode rootNode = null;

        for(int i =0;i<treeSize;i++){
            if("null".equals(nodeData.get(i)))
                continue;
            if(nodeList[i] == null){
                TreeNode currNode = new TreeNode(Integer.valueOf(nodeData.get(i)));
                nodeList[i]= currNode;
            }
            TreeNode currNode = nodeList[i];
            int leftChildIndex = (i*2)+1;
            int rightChildIndex = (i*2)+2;

            if(leftChildIndex < treeSize){
                TreeNode leftChild = null;
                if(!nodeData.get(leftChildIndex).equals("null"))
                    leftChild = new TreeNode(Integer.valueOf(nodeData.get(leftChildIndex)));
                nodeList[leftChildIndex]=leftChild;
                currNode.left = leftChild;
            }

            if(rightChildIndex < treeSize){
                TreeNode rightChild = null;
                if(!nodeData.get(rightChildIndex).equals("null"))
                    rightChild = new TreeNode(Integer.valueOf(nodeData.get(rightChildIndex)));
                nodeList[rightChildIndex]=rightChild;
                currNode.right = rightChild;
            }
        }

        return nodeList[0];
    }
}
