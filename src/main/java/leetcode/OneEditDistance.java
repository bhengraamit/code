package leetcode;

/**
 * Created by amit.bhengra on 10/09/18.
 *
 * https://leetcode.com/problems/one-edit-distance/description/
 *
 *
 */
public class OneEditDistance {

    public static void main(String[] args) {
        OneEditDistance oneEditDistance = new OneEditDistance();
        System.out.println(oneEditDistance.isOneEditDistance("ab","acb"));
        System.out.println(oneEditDistance.isOneEditDistance("afce","abcd"));
        System.out.println(oneEditDistance.isOneEditDistance("",""));
    }
    public boolean isOneEditDistance(String s, String t) {
        if (s== null || t == null)
            return true;

        if (s.length()!=t.length()){
            if(Math.abs(s.length() - t.length()) > 1)
                return false;
            // check for insertion or deletion

            char[] shorter = s.toCharArray();
            char[] longer = t.toCharArray();
            if (s.length() > t.length()){
                shorter = t.toCharArray();
                longer = s.toCharArray();
            }

            int diffCount = 0;

            int i = 0;
            int j = 0;
            for (;i<shorter.length && j<longer.length; ){
                if(shorter[i] != longer[j]) {
                    diffCount++;
                    j++;
                }else {
                    i++;
                    j++;
                }
                if (diffCount == 2)
                    break;
            }
            if (diffCount <=1)
                return true;
            else
                return false;
        }

        if (s.length() == t.length()){
            char[] shorter = s.toCharArray();
            char[] longer = t.toCharArray();

            int diffCount = 0;

            int i = 0;
            int j = 0;
            for (;i<shorter.length && j<longer.length; ){
                if(shorter[i] != longer[j]) {
                    diffCount++;
                }
                i++;
                j++;
                if (diffCount == 2)
                    break;
            }
            if (diffCount ==1)
                return true;
            else
                return false;
        }

        return false;
    }
}
