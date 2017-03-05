/**
 * Created by amit.bhengra on 30/01/17.
 */
public class Rotation {
    public static void main(String[] args) {
        Integer numToFind = 1;
        Integer[] input = {10,10,10,10,10};//{23,25,33,46,52,52,13,16,20};
        Integer point = findRotationPoint(input,0,input.length-1);
        Integer num = null;
        if(point!=null){

            if(numToFind >= input[0]) {
                num  = findNumberIN(input, 0, point - 1, 0,numToFind);
            }else if(numToFind >= input[point]){
                num = findNumberIN(input,point,input.length-1, point,numToFind);
            }else{
                num = -1;
            }
        }else{
            // if there is no point of rotation
            num = findNumberIN(input,0,input.length-1,0,numToFind);
        }
        System.out.println(num);
    }

    private static Integer findNumberIN(Integer[] input, int start, int end, int globalStart,int numToFind) {
        if (start == end){
            if (numToFind==input[start]){
                return start;
            } else if(input[start] != numToFind) {
                if (numToFind > input[start]){
                    return start;
                }else {
                    if (start > globalStart)
                        return start - 1;
                    else
                        return -1;
                }
            }
        }
        else {
            int mid = (start + end) / 2;
            if (numToFind <= input[mid]) {
                return findNumberIN(input, start, mid, globalStart, numToFind);
            } else {
                return findNumberIN(input, mid + 1, end, globalStart, numToFind);
            }
        }
        return null;
    }

    private static Integer findRotationPoint(Integer[] input, int start, int end) {
        if (input!=null && input.length >0){
            if (end-start == 1) {
                if (input[end] < input[start])
                    return end;
                else
                    return start;
            }
            int mid = (start + end)/2;
            if (input[start] > input[mid]){
                return findRotationPoint(input,start,mid);
            }else if(input[mid] > input[end]){
                return findRotationPoint(input,mid,end);
            }
        }
        return null;
    }
}
