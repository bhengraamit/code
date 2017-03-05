import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Created by amit.bhengra on 27/11/16.
 * https://www.hackerrank.com/contests/acm-icpc-practice-contest/challenges/minimum-loss
 */
public class MinimumLoss {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bi.readLine());
        String firstStr = bi.readLine();
        Stream<BigInteger> bigIntegerStream = Arrays.asList(firstStr.split(" ")).stream().map(str -> {
            return new BigInteger(str);
        });

        Iterator<BigInteger> bigIntegerIterator = bigIntegerStream.iterator();

        Node root = new Node(bigIntegerIterator.next());
        BigInteger lowestDiff = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        int i = 1;
        while (bigIntegerIterator.hasNext()){
            BigInteger diff = insertNode(root,bigIntegerIterator.next(),lowestDiff);
            lowestDiff = diff.compareTo(lowestDiff) < 0 ? diff : lowestDiff;
            i++;
        }
        System.out.println(lowestDiff);

    }

    private static BigInteger insertNode(Node root, BigInteger value, BigInteger diff){
        if (root.value.compareTo(value) > 0){
            BigInteger tmpDiff = root.value.subtract(value);
            diff = tmpDiff.compareTo(diff) < 0 ? tmpDiff : diff;
            if (root.left ==null){
                Node node = new Node(value);
                root.left = node;
                return diff;
            }else {
                return insertNode(root.left, value, diff);
            }
        }else if (root.value.compareTo(value) < 0){
            if (root.right ==null){
                Node node = new Node(value);
                root.right = node;
                return diff;
            }else {
                return insertNode(root.right, value, diff);
            }
        }else if (root.value == value){
            return diff;
        }

        return null;
    }

    private static class Node{
        Node left;
        Node right;
        BigInteger value;

        public Node(BigInteger value){
            this.value = value;
        }
    }
}
