import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit.bhengra on 06/04/17.
 */
public class NthLargest {


    static class Heap{
        List<Integer> heap;
        int size;

        Heap(int size){
            this.heap = new ArrayList<>(size);
            this.size = size;
        }

        public Integer getNthLargest(){
            if (heap.size()==size)
                return heap.get(0);             // check for size first
            return null;
        }

        public void add(Integer value){
            if (heap.size()==this.size){
                if (heap.get(0) < value){
                    heap.set(heap.size()-1,value);
                    int parent = findParent(heap.size()-1);
                    heapify(parent);
                }else{
                    return;
                }
            }

            int size = heap.size();
            int rem = size % 2;
            heap.add(value);
            Integer parent = null;
            if (rem == 0)
                parent = size/2 - 1;
            else
                parent = size/2;
            heapify(parent);
        }

        public int findParent(int index){
            if (index == 0)
                return -1;
            int size = index;
            int rem = size % 2;
            Integer parent = null;
            if (rem == 0)
                parent = size/2 - 1;
            else
                parent = size/2;
            return parent;
        }

        public void remove(){
            int temp = heap.get(0);
            heap.set(0, heap.get(heap.size()-1));
            heap.set(heap.size()-1, temp);
            int parent = findParent(heap.size()-1);
            heapify(parent);

        }

        public void heapify(int index){
            while(index>=0) {
                int firstChildIndex = index * 2 + 1;
                int secondChildIndex = index * 2 + 2;
                int largestIndex = findLargestIndex(index,firstChildIndex,secondChildIndex);
                if (largestIndex == index)
                    break;
                else {
                    int temp = heap.get(largestIndex);
                    heap.set(largestIndex,heap.get(index));
                    heap.set(index,temp);
                    index = findParent(index);
                    if (index == -1)
                        break;
                }
            }

        }

        private int findLargestIndex(int index, int firstChildIndex, int secondChildIndex) {
            int largestIndex = index;
            if (firstChildIndex < heap.size()){
                if (heap.get(index) < heap.get(firstChildIndex))
                    largestIndex = firstChildIndex;
            }
            if (secondChildIndex < heap.size()){
                if (heap.get(largestIndex) < heap.get(secondChildIndex))
                    largestIndex = secondChildIndex;
            }
            return largestIndex;
        }
    }
}



