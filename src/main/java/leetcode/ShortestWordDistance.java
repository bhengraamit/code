package leetcode;

/**
 * Created by amit.bhengra on 14/09/18.
 *
 * https://leetcode.com/problems/shortest-word-distance/description/
 */
public class ShortestWordDistance {

    public static void main(String[] args) {
        ShortestWordDistance wordDistance = new ShortestWordDistance();
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        wordDistance.shortestDistance(words,"practice","coding");
    }
    public int shortestDistance(String[] words, String word1, String word2) {
        if(words == null || words.length <=1)
            return 0;
        int firstIndex = Integer.MIN_VALUE;
        int secondIndex = Integer.MIN_VALUE;
        int shortest = Integer.MAX_VALUE;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(word1))
                firstIndex = i;
            if(words[i].equals(word2))
                secondIndex =i;
            if(firstIndex >=0 && secondIndex>=0){
                int diff = Math.abs(secondIndex - firstIndex);
                shortest = diff <shortest ? diff : shortest;
            }
        }
        return shortest;
    }
}
