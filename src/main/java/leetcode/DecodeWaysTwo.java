package leetcode;

/**
 * Created by amit.bhengra on 12/09/18.
 */
public class DecodeWaysTwo {

    public static void main(String[] args) {
        DecodeWaysTwo decodeWaysTwo = new DecodeWaysTwo();
        System.out.println(decodeWaysTwo.numDecodings("**********"));
    }
    public int numDecodings(String s) {
        if(s == null || s.isEmpty())
            return 0;
        if(s.length() == 1){
            if("0".equals(s))
                return 0;
            if("*".equals(s))
                return 9;
            Integer num = Integer.valueOf(s);
            if(num >=1 && num <=9)
                return 1;
        }

        // all strings greater than equal to 2;
        long pprev = 1;
        long prev = 1;
        char[] chArr = s.toCharArray();
        prev = validNumAndComb(String.valueOf(chArr[chArr.length-1]));
        for(int i = chArr.length-2; i>=0; i--){
            //check for singleCharacter
            int firstComb = validNumAndComb(String.valueOf(chArr[i]));

            //check for double Character
            StringBuilder builder = new StringBuilder();
            builder.append(chArr[i]);
            builder.append(chArr[i+1]);
            int secondComb = validNumAndComb(builder.toString());

            long temp = prev;
            prev = (prev * firstComb + secondComb * pprev ) % 1000000007;
            pprev = temp;
        }

        return (int)prev ;
    }

    public int validNumAndComb(String num){
        if(num.length() == 1){
            if("0".equals(num))
                return 0;
            if("*".equals(num))
                return 9;
            Integer no = Integer.valueOf(num);
            if(no >=1 && no <=9)
                return 1;
        }

        if(num.length() == 2){
            if(num.equals("**"))
                return 15;
            char[] chArr = num.toCharArray();
            char firstChar = chArr[0];
            char secondChar = chArr[1];
            if('*' == firstChar){
                Integer secDig = Integer.valueOf(String.valueOf(secondChar));
                int comb = 0;
                if(secDig >=1 && secDig <=6)
                    comb = 2;
                if(secDig > 6)
                    comb = 1;
                if(secDig == 0)
                    comb = 2;
                return comb;
            }

            if('*' == secondChar){
                int firstDig = Integer.valueOf(String.valueOf(firstChar));
                if(firstDig ==1)
                    return 9;
                if(firstDig ==2)
                    return 6;
                return 0;
            }
            Integer no = Integer.valueOf(num);
            if(no >= 10 && no<=26)
                return 1;
        }
        return 0;
    }
}
