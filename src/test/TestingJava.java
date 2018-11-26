import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by amit.bhengra on 22/08/18.
 */
public class TestingJava {

    Object object;
    @Test
    public void testLambda(){
        List<String> words = new ArrayList<String>();
        Collections.sort(words,
                (s1,s2) -> {
                    return 0;
                }
        );
    }

    @Test
    public void testStringToListOfCharacters(){
        String j = "abc";
        List<Character> collect = j.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }


    @Test
    public void testComparators(){
        List<Interval> start = new ArrayList<>();
        Collections.sort(start,
                new Comparator<Interval>(){
                    @Override
                    public int compare(Interval o1, Interval o2) {
                        return 0;
                    }
                });

    }

    @Test
    public void testStackDS(){
        Stack<Character> characterStack = new Stack<>();
        characterStack.push('a');
        characterStack.push('b');
        characterStack.peek();
        Iterator<Character> iterator = characterStack.listIterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

    @Test
    public void testCharArray(){
        char[] testArray = new char[4];
        System.out.println(testArray.length);
        String.valueOf(testArray);
    }

    @Test
    public void testArraysFunctions(){
        int[] nums = new int[10];
        Arrays.sort(nums);
    }

    @Test
    public void testStringSubstring(){
        String str = "1223";
        char[] chars = str.toCharArray();

        str.substring(0);
        str = "";
        System.out.println(str.length());
//        System.out.println(str.substring(0,4));
//        boolean contains = str.replaceAll("2", "4").replaceAll("3", "6").contains("1");
//        //System.out.println(newstr);
        str.toCharArray();
//        boolean matched = false;
//        matched |= false;
//        System.out.println(matched);
//        str = str.toLowerCase();

        System.out.println(str.substring(0,0));
    }

    @Test
    public void testList(){
        List<Character> characterList = new ArrayList<>();
        characterList.add(10,'2');
    }

    @Test
    public void testQueue(){
        Queue<String> queue = new LinkedList<>();
        queue.add("abc");
        queue.poll();
        queue.size();
        queue.peek();

    }

    @Test
    public void testStream(){
        List<String> test = new ArrayList<>();
        test.add("abc");
        test.add("xyz");
        String collect = test.stream().collect(Collectors.joining(","));
        System.out.println(collect);

    }

    @Test
    public void testLinkedList(){
        Queue<String> linkedList = new LinkedList<>();
        linkedList.add(null);
        linkedList.add(null);
        linkedList.add("abc");
        System.out.println(linkedList);
        int[] a = new int[1];

        String abc = null;
        boolean ok = abc == null ? true : false;
    }

    @Test
    public void testPriorityQueue(){
        int[] nums = new int[10];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        maxHeap.poll();
    }

    @Test
    public void testStringBuilderBuffer(){
        StringBuilder stringBuilder = new StringBuilder(10);
        stringBuilder.insert(8,'a');
        System.out.println(stringBuilder);
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder.append('j');
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('k');

    }

    @Test
    public void testHashMap(){
        Map<String,String> map = new HashMap<>();
        map.remove("abc");
        Map<Character,Character[]> keyPad = new HashMap<>();
        Character[] characterList = {'c'};
        keyPad.put('2',characterList);
        //characterList = {'b'};
        //keyPad.put(3,characterList);
    }

    @Test
    public void testIntToString(){
        List<String> paths = new ArrayList<>();
        paths.add(String.valueOf(1));
        String s = String.valueOf(1);
    }

    @Test
    public void testSet(){
        Set<String> stringSet = new HashSet<>();
        stringSet.add("abc");
        System.out.println(stringSet);
        stringSet.remove("abc");
        System.out.println(stringSet);
    }

    @Test
    public void test2DArray(){
        char[][] d2 = new char[2][4];
        int length = d2.length;
        System.out.println(length);
    }


    @Test
    public void testPrimitives(){
        //unsigned short abc = 6400;
    }

    public void testMath(){
        Math.min(1,2);
        Math.max(2,1);
    }

    @Test
    public void testObject(){
        //Object object = null;
        if( null == object)
            System.out.println(true);
    }

    @Test
    public void testArrayList(){
        ArrayList<Object> objects = new ArrayList<>();
        Collections.reverse(objects);
    }


    public static class Interval{
        int start;
        int end;
        Integer startArrayIndex;
        Integer endArrayIndex;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }


}
