package leetcode;

/**
 * Created by amit.bhengra on 09/09/18.
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
//        System.out.println(divideTwoIntegers.divide(2147483647,3));
//        System.out.println(divideTwoIntegers.divide(-2147483648,-1));
        System.out.println(divideTwoIntegers.divide(2147483647,1));
//        System.out.println(divideTwoIntegers.divide(-2147483648,1));
    }
        public class DivCount{
            int dividend;
            int divisor;
            int divValue;
        }


        public int divide(int dividend, int divisor) {
            int sign = 0;
            if(1== divisor) {
                int sign1 = getSign(dividend, divisor);
                if (sign1 == 0 && dividend < 0)
                    return -1*dividend;
                if (sign1 == 1 && dividend > 0)
                    return -1*dividend;
                return dividend;
            }
            if(dividend < 0){
                sign ^= 1;
                if(dividend == Integer.MIN_VALUE)
                    dividend = Integer.MAX_VALUE;
                else
                    dividend = -1*dividend;
            }
            if(divisor < 0){
                sign ^= 1;
                divisor = -1*divisor;
            }
            if(dividend < divisor)
                return 0;

            int totalCount = 0;
            while(dividend >= divisor && divisor!=Integer.MIN_VALUE){
                DivCount divCount = calculateCount(dividend,divisor);
                totalCount += divCount.divValue;
                dividend = divCount.dividend;
                divisor = divCount.divisor;
            }
            if(sign == 0)
                return totalCount;
            else {
                totalCount= -1 * totalCount;
                if (totalCount == Integer.MIN_VALUE)
                    return Integer.MAX_VALUE;
                return totalCount;
            }
        }

        public DivCount calculateCount(int dividend, int divisor){
            int tempCount = 1;
            int originalDivisor = divisor;
            int loopCount = 1;
            boolean overflow = false;
            int oldDivisor = divisor;
            while(dividend >= divisor){
                divisor = divisor << 1;
                if (oldDivisor > divisor){//(divisor == Integer.MIN_VALUE) {
                    divisor = Integer.MAX_VALUE;
                    overflow = true;
                    break;
                    //tempCount = Integer.MAX_VALUE;
                    //loopCount++;
                }
                if(divisor > dividend){
                    divisor = divisor >> 1;
                    dividend = dividend - divisor;
                    divisor = originalDivisor;
                    break;
                }else{
                    tempCount *= 2;
                    if (tempCount == Integer.MIN_VALUE)
                        tempCount = Integer.MAX_VALUE;
                    loopCount++;
                    if(overflow)
                        break;
                }
                oldDivisor = divisor;
            }
            DivCount divCount =  new DivCount();
            divCount.dividend = dividend;
            divCount.divisor = divisor;
            if (overflow) {
                divCount.divisor = originalDivisor;
                divCount.dividend = dividend  - oldDivisor;
            }
            divCount.divValue = tempCount;
            return divCount;
        }

        public int getSign(int dividend, int divisor){
            int sign = 0;
            if(dividend < 0){
                sign ^= 1;
            }
            if(divisor < 0){
                sign ^= 1;

            }
            return sign;
        }
}
