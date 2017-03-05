import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by amit.bhengra on 17/12/16.
 * https://www.hackerrank.com/contests/zalando-codesprint/challenges/the-inquiring-manager
 *
 */
public class TheInquiringManager {

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        Integer events = Integer.valueOf(bi.readLine());
        Heap heap = new Heap();
        while (events-- > 0){
            String[] event = bi.readLine().split(" ");
            if (event[0].equals("1")){
                Integer value = Integer.valueOf(event[1]);
                Integer time = Integer.valueOf(event[2]);
                Node node = new Node(value,time);
                heap.addToHeap(node);
            }else{
                Integer time = Integer.valueOf(event[1]);
                Integer fromTime = time - 59 < 0 ? 0 : time-59;
                Node maxNode = heap.getMax();
                Integer find = null;
                while (maxNode.time < fromTime){
                    try {
                        heap.removeFromHeap(1);
                        maxNode = heap.getMax();
                    }catch (Exception e){
                        find = -1;
                        System.out.println(find);
                        break;
                    }
                }
                if (find==null)
                    System.out.println(maxNode.value);

            }
        }

    }

    static class Heap{
        Node[] heap = new Node[1000000];
        int currentPos = 0;

        Node getMax(){
            return heap[1];
        }
        void addToHeap(Node newNum){
            currentPos++;
            heap[currentPos] = newNum;
            if (currentPos > 1)
                heapify(currentPos);

        }

        void removeFromHeap(Integer removePos) throws Exception {
            Node lastNode = heap[currentPos];
            Node removeNode = heap[removePos];
            heap[currentPos] = removeNode;
            heap[removePos] = lastNode;
            currentPos--;
            if (currentPos==0)
                throw new Exception();
            heapify(removePos);
        }

        private void heapify(int currentPos) {
            // check for parents only
            int parentPos = currentPos/2;
            Node parent = heap[parentPos];
            Node current = heap[currentPos];
            if (parentPos > 0 && parent.value < current.value){
                //replace node values
                heap[parentPos] = current;
                heap[currentPos] = parent;
                if (parentPos > 1)
                    heapify(parentPos);
            }
            else {     // check for children as well as parents
                //children check, if left child exists
                int leftChildPos = currentPos*2;
                int rightChildPos = currentPos*2 + 1;
                Node leftChild = null;
                Node rightChild = null;
                Node currentChild = heap[currentPos];
                if (leftChildPos <= this.currentPos){
                    leftChild = heap[leftChildPos];
                }
                if (rightChildPos <= this.currentPos){
                    rightChild = heap[rightChildPos];
                }
                if (leftChild !=null && rightChild!=null){
                    Integer largestChildPos = null;
                    if (leftChild.value >= rightChild.value)
                        largestChildPos = leftChildPos;
                    else
                        largestChildPos = rightChildPos;

                    Node largestChild = heap[largestChildPos];
                    if (largestChild.value > currentChild.value){
                        heap[largestChildPos] = currentChild;
                        heap[currentPos] = largestChild;
                        heapify(largestChildPos);
                    }

                }else if (leftChild!=null){
                    if (leftChild.value > currentChild.value ){
                        heap[leftChildPos] = currentChild;
                        heap[currentPos] = leftChild;
                        heapify(leftChildPos);
                    }
                }

                // no need to check for right child as if no left child implies no right child

            }
        }

    }

    static class Node{
        int value;
        int time;

        public Node(Integer value, Integer time) {
            this.value = value;
            this.time = time;
        }
    }

}
