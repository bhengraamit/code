package leetcode;

import java.util.*;

/**
 * Created by amit.bhengra on 07/10/18.
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        topKFrequentElements.topKFrequent(nums,4);
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return list;
        Map<Integer,Integer> keyCount = new HashMap<>();
        for (int i=0; i<nums.length;i++){
            if(!keyCount.containsKey(nums[i]))
                keyCount.put(nums[i],0);
            keyCount.put(nums[i],keyCount.get(nums[i])+1);
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(k,new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.count.compareTo(o2.count);
            }
        });
        int counter = 0;
        for (Integer key : keyCount.keySet()){
            Node node = new Node();
            node.key = key;
            node.count = keyCount.get(key);
            if(counter >=k){
                if(priorityQueue.peek().count < node.count){
                    priorityQueue.remove();
                    priorityQueue.add(node);
                }
            }else{
                priorityQueue.add(node);
            }
            counter++;
        }

        priorityQueue.stream().forEach(node -> {
            list.add(node.key);
        });
        return list;
    }

    public class Node{
        Integer key;
        Integer count;
    }

}
