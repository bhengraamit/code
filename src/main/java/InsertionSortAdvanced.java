import java.util.Scanner;

/**
 * Created by amit.bhengra on 10/11/16.
 * https://www.hackerrank.com/challenges/insertion-sort
 */

public class InsertionSortAdvanced {


    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int testCases = reader.nextInt();
        reader.nextLine();

        while (testCases-- > 0){
            int arrSize = reader.nextInt();
            reader.nextLine();
            String arrStr = reader.nextLine();
            String arr[] = arrStr.split(" ");
            Node root = null;
            int sum = 0;
            while (arrSize-- > 0){
                int num = Integer.valueOf(arr[arrSize]);
                if (root==null)
                    root = new Node(num);
                else {
                    sum = insertNode(root,num,sum);
                }
            }
            System.out.println(sum);
        }
    }

    private static int insertNode(Node root, int num, int sum) {
        if (root.value!=num){
            if (root.value < num){
                sum += root.smallCount + 1 + root.equalCount;
                if (root.right==null){
                    root.right = new Node(num);
                    return sum;
                }else {
                    return insertNode(root.right, num, sum);
                }
            }
            else {
                root.smallCount++;
                if (root.left==null) {
                    root.left = new Node(num);
                    return sum;
                }else {
                    return insertNode(root.left,num,sum);
                }
            }
        }else {
            // when num is equal to root value just return sum
            sum = root.smallCount + sum;
            root.equalCount++;
            return sum;
        }
    }

    private static class Node{

        Node left;
        Node right;
        int value;
        int smallCount = 0;
        int equalCount = 0;

        public Node(int num) {
            this.value = num;
        }
    }
}
