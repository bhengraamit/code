import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by amit.bhengra on 10/11/16.
 * https://www.hackerrank.com/challenges/insertion-sort
 */

public class InsertionSortAdvancedModified {

    private  static BigInteger valueOne = new BigInteger("1");
    private  static BigInteger valueZero = new BigInteger("0");

    public static void main(String[] args) throws Exception {


        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int testCases1 = Integer.parseInt(bi.readLine());


        while (testCases1-- > 0){
            int arrSize = Integer.parseInt(bi.readLine());
            String array = bi.readLine();
            String arr[] = array.split(" ");
            Node root = null;
            BigInteger sum = valueZero;
            int i = 0;
            while (i < arrSize){
                int num = Integer.parseInt(arr[i]);
                i++;
                if (root==null)
                    root = new Node(num);
                else {
                    sum = insertNode(root,num,sum);
                }
            }

            System.out.println(sum);
        }
    }

    private static BigInteger insertNode(Node root, int num, BigInteger sum) {
        if (root.value!=num){
            if (num < root.value){
                sum = sum.add(root.smallCount.add(valueOne).add(root.equalCount));
                if (root.left==null){
                    root.left = new Node(num);
                    return sum;
                }else {
                    return insertNode(root.left, num, sum);
                }
            }
            else {
                root.smallCount = root.smallCount.add(valueOne);
                if (root.right==null) {
                    root.right = new Node(num);
                    return sum;
                }else {
                    return insertNode(root.right,num,sum);
                }
            }
        }else {
            // when num is equal to root value just return sum
            sum = sum.add(root.smallCount);
            root.equalCount = root.equalCount.add(valueOne);
            return sum;

        }
    }

    private static class Node{

        Node left;
        Node right;
        Integer value;
        BigInteger smallCount = valueZero;
        BigInteger equalCount = valueZero;

        public Node(int num) {
            this.value = num;
        }
    }
}
