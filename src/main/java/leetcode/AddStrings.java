package leetcode;

/**
 * Created by amit.bhengra on 06/10/18.
 *
 * https://leetcode.com/problems/add-strings/description/
 */
public class AddStrings {
    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        System.out.println(addStrings.addStrings("12345","999"));
    }

    public String addStrings(String num1, String num2) {
        if(num1 == null || num2 ==null || num1.isEmpty() || num2.isEmpty())
            return null;
        int l1 = num1.length();
        int l2 = num2.length();
        int size = l1 > l2 ? l1 : l2;
        size +=1;           // for the extra carry
        StringBuilder sumStr = new StringBuilder(size);
        l1 -=1; l2 -=1;
        int carry = 0;
        int index = l1 > l2 ? l1 : l2;
        while(l1 >=0 && l2 >=0){
            int i1 = Integer.valueOf(num1.substring(l1,l1+1));
            int i2 = Integer.valueOf(num2.substring(l2,l2+1));
            int sum = i1+i2+carry;
            sumStr.append(String.valueOf(sum % 10));
            carry = sum / 10;
            l1--;l2--;
        }

        String lastStr = l1 > l2 ? num1 : num2;
        index = l1 > l2 ? l1 : l2;
        while(index>=0){
            int i1 = Integer.valueOf(lastStr.substring(index,index+1));
            int sum = i1 + carry;
            sumStr.append(String.valueOf(sum % 10));
            carry = sum / 10;
            index--;
        }
        if(carry > 0)
            sumStr.append(String.valueOf(carry));

        return sumStr.reverse().toString();

    }


    /**
     * Elgant Coding
     *
     *
     * public String addStrings(String num1, String num2) {
     StringBuilder sb = new StringBuilder();
     int carry = 0;
     for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
     int x = i < 0 ? 0 : num1.charAt(i) - '0';
     int y = j < 0 ? 0 : num2.charAt(j) - '0';
     sb.append((x + y + carry) % 10);
     carry = (x + y + carry) / 10;
     }
     return sb.reverse().toString();
     }
     *
     *
     *
     */
}
