package leetcode;

import java.util.*;

/**
 * Created by amit.bhengra on 11/09/18.
 *
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * It can be further optimised if we do BFS from both ends,
 * that is from start word and end word as well.
 */
public class WordLadder {

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        String[] words = {"hot","dog"};
        List<String> strings = new ArrayList<>();
        for (String word: words){
            strings.add(word);
        }
        int i = wordLadder.ladderLength("hot", "dog", strings);
        System.out.println(i);
    }

    static boolean found = false;
    static boolean breakLoop = false;
    Map<String,Integer> wordMap = new HashMap<>();
    Set<String> alreadyGenerated = new HashSet<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equalsIgnoreCase(endWord))
            return 0;

        Queue<String> linkedList = new LinkedList<>();
        linkedList.add(beginWord);
        populateMap(wordList);
        int length = doBFS(endWord,wordList,0,linkedList);
        if (found == true)
            return length+1;
        return 0;
    }

    private void populateMap(List<String> wordList) {
        wordList.stream().forEach( word ->{
            wordMap.put(word,null);
        });
    }

    private int doBFS(String endWord, List<String> wordList, int changeCount, Queue<String> linkedList) {
        if (breakLoop)
            return changeCount;
        int size = linkedList.size();
        int i = 0;
        if (size == 0)
            return changeCount;
        while(i<size){
            String poll = linkedList.poll();
            int j = 0;
            while(j < poll.length()){
                for (char k =97; k <= 122; k++){
                    String s = (j==0 ? "" : poll.substring(0,j) ) + String.valueOf(k) + (j == poll.length()-1 ? "" : poll.substring(j+1));
                    if (alreadyGenerated.contains(s))
                        continue;
                    else
                        alreadyGenerated.add(s);
                    if(isPresent(s)) {
                        if (s.equalsIgnoreCase(endWord)) {
                            found = true;
                            return changeCount + 1;
                        }
                        linkedList.add(s);
                    }
                }
                j++;
            }
            i++;
        }
        return doBFS(endWord,wordList,changeCount+1, linkedList);
    }

    public boolean isPresent(String checkWord){
        boolean dictionaryFound = false;

        if (wordMap.containsKey(checkWord)){
            dictionaryFound = true;
            wordMap.remove(checkWord);
        }
        if(wordMap.size()==0)
            breakLoop = true;
        return dictionaryFound;
    }
}
