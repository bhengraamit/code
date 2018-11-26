package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit.bhengra on 25/08/18.
 *
 * https://leetcode.com/problems/regular-expression-matching
 */
public class Regex {
    public static void main(String[] args) {
        Regex regex = new Regex();
        regex.isMatch("aa","a*");
    }
        public boolean isMatch(String s, String p) {
            if(p == null || p.isEmpty())
                return true;                // matching in case of null or empty
            if(s == null)
                return false;               // not matching for null or empty

            //Node startNode = createSM(p);
            List<Node> startNodes = createSM(p);
            boolean matched = false;
            for(Node startNode:startNodes){
                matched |= matchPattern(s.toCharArray(),startNode,0);
            }
            //return matchPattern(s.toCharArray(),startNode,0);
            return matched;
        }

        public boolean matchPattern(char[] s,Node startNode,int startIndex){
            if(startNode == null)
                return false;

            if(s.length == startIndex){
                if(startNode.endValue!=null && startNode.endValue.equals("end")){
                    return true;
                }
                return false;
            }
            // if(startNode.value!=null && startNode.value.equals("end")){
            //     if(startIndex == s.length)
            //         return true;
            //     else
            //         return false;
            // }
            // if(s.length == startIndex)
            //     return false;
            char ch = s[startIndex];
//         Node node1 = null;
//         if(startNode.children.get('.')!=null)
//             node1 = startNode.children.get('.');
//         Node node2 = startNode.children.get(ch);

//         return matchPattern(s,node1,startIndex+1) || matchPattern(s,node2,startIndex+1);
            boolean matched = false;
            for(NodeChildren nodeChild:startNode.children){
                int indexToStart = startIndex+1;
                if( nodeChild.ch == '*')
                    indexToStart = startIndex;
                if(nodeChild.ch == '.' || nodeChild.ch == ch || nodeChild.ch == '*')
                    matched |= matchPattern(s,nodeChild.toNode,indexToStart);
            }
            return matched;
        }

        public List<Node> createSM(String p){
            List<Node> startNodes = new ArrayList<>();
            char[] pattern = p.toCharArray();
            Node startNode= new Node();
            startNode.startValue = "start";
            startNodes.add(startNode);
            Node previousNode = startNode;
            Node lastNode = null;
            char prevChar = '1';               //assuming first char will never be *
            // for(char pat: pattern){
            //     if(pat == '*'){
            //         previousNode.children.put(prevChar,previousNode);
            //         lastNode = previousNode;
            //     }else{
            //         Node node = new Node();
            //         previousNode.children.put(pat,node);
            //         lastNode = node;
            //         previousNode = node;
            //     }
            //     prevChar = pat;
            // }

            int i = 0;
            while(i < p.length()){
                if((i+1) < p.length() && pattern[i+1] == '*'){
                    NodeChildren nodeChild = new NodeChildren();
                    nodeChild.ch = pattern[i];
                    nodeChild.toNode = previousNode;
                    // previousNode.children.put(pattern[i],previousNode);
                    previousNode.children.add(nodeChild);
                    lastNode = previousNode;
                    Node node = new Node();
                    NodeChildren nodeChild1 = new NodeChildren();
                    nodeChild1.ch = '*';
                    nodeChild1.toNode = node;
                    previousNode.children.add(nodeChild1);
                    if(previousNode.startValue!=null && previousNode.startValue.equals("start")){
                        node.startValue = "start";
                        startNodes.add(node);
                    }
                    if((i+1) == p.length()-1)
                        previousNode.endValue = "end";
                    previousNode = node;
                    lastNode = previousNode;
                    i += 2;

                }else{
                    NodeChildren nodeChild = new NodeChildren();
                    nodeChild.ch = pattern[i];
                    Node node = new Node();
                    // previousNode.children.put(pattern[i],node);
                    previousNode.children.add(nodeChild);
                    nodeChild.toNode = node;
                    lastNode = node;
                    previousNode = node;
                    i++;
                }

            }

            lastNode.endValue = "end";
            return startNodes;
        }

        public static class Node{
            String startValue;
            String endValue;
            List<NodeChildren> children = new ArrayList<>();
        }

        public static class NodeChildren{
            Character ch;
            Node toNode;
        }

}
