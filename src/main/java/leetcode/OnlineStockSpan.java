//package leetcode;
//
///**
// * Created by amit.bhengra on 09/09/18.
// */
//public class OnlineStockSpan {
//    public class Node{
//        Node left;
//        Node right;
//        int value;
//        int count;
//
//        public Node(int value, int count){
//            this.value = value;
//            this.count = count;
//        }
//    }
//
//    Node root = null;
//    int totalCount = 0;
//
//    public StockSpanner() {
//    }
//
//    public int next(int price) {
//        if(root == null){
//            root =  new Node(price,1);
//            return 1;
//        }
//        totalCount = 0;
//        traverseTreeAndCount(root,price);
//        return totalCount;
//    }
//
//    public Node traverseTreeAndCount(Node node, int price){
//        if(node == null){
//            Node newNode = new Node(price,1);
//            totalCount++;
//            return newNode;
//        }
//        if(node.value == price){
//            node.count += 1;
//            totalCount += node.count;
//            return node;
//        }
//        if(price > node.value){
//            totalCount++;
//            Node rightChild = traverseTreeAndCount(node.right,price);
//            node.right = rightChild;
//            return node;
//        }
//        if(price < node.value){
//            Node leftChild = traverseTreeAndCount(node.left,price);
//            node.left = leftChild;
//            return node;
//        }
//        return null;
//    }
//}
