package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by amit.bhengra on 09/05/17.
 */
public class ChefDailyRoutine {

    public static void main(String[] args) throws IOException {
        Node rootNode = createStateMachine();
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bi.readLine());

        while (testCases-- > 0){
            String testCase = bi.readLine();
            char[] chArr = testCase.toCharArray();
            int size = chArr.length;
            int i = 0;
            Node currentNode = rootNode;
            boolean isBreak = false;
            while (i < size){

                Node node = currentNode.nextStates.get(chArr[i]);
                if (node ==  null) {
                    System.out.println("no");
                    isBreak = true;
                    break;
                }

                currentNode = node;
                i++;
            }
            if(!isBreak)
                System.out.println("yes");
        }

    }

    private static Node createStateMachine() {
        Node rootNode = new Node('R');
        Node cookingNode = new Node('C');
        Node eatingNode = new Node('E');
        Node sleepingNode = new Node('S');

        Map<Character,Node> rootNodeMap = new HashMap<>();
        rootNodeMap.put('C',cookingNode);
        rootNodeMap.put('E',eatingNode);
        rootNodeMap.put('S',sleepingNode);

        rootNode.nextStates = rootNodeMap;

        Map<Character,Node> cookingNodeMap = new HashMap<>();
        cookingNodeMap.put('C',cookingNode);
        cookingNodeMap.put('E',eatingNode);
        cookingNodeMap.put('S',sleepingNode);
        cookingNode.nextStates = cookingNodeMap;

        Map<Character,Node> eatingNodeMap = new HashMap<>();
        eatingNodeMap.put('C',null);
        eatingNodeMap.put('E',eatingNode);
        eatingNodeMap.put('S',sleepingNode);
        eatingNode.nextStates = eatingNodeMap;

        Map<Character,Node> sleepingNodeMap = new HashMap<>();
        sleepingNodeMap.put('C',null);
        sleepingNodeMap.put('E',null);
        sleepingNodeMap.put('S',sleepingNode);
        sleepingNode.nextStates = sleepingNodeMap;

        return rootNode;

    }

    static class Node{
        Character state;
        boolean isValid;
        Map<Character,Node> nextStates;

        public Node(char state) {
            this.state = state;
        }
    }
}
