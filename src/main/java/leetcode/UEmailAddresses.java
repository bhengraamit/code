package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by amit.bhengra on 28/10/18.
 *
 * https://leetcode.com/contest/weekly-contest-108/problems/unique-email-addresses/
 */
public class UEmailAddresses {

    public static void main(String[] args) {
        UEmailAddresses uEmailAddresses = new UEmailAddresses();
        String[] emails = {"test.email+alex@leetco.de.com","test.e.mail+bob.cathy@le.etcode.com","testemail+david@leetcode.com"};
        System.out.println(uEmailAddresses.numUniqueEmails(emails));
    }
    public int numUniqueEmails(String[] emails) {
        if(emails == null || emails.length ==0)
            return 0;
        Set<String> emailSet = new HashSet<>();
        for (String email : emails){
            String[] split = email.split("@");
            String[] plusSplit = split[0].split("\\+");
            String firtAddress = plusSplit[0].replaceAll(".","");
            emailSet.add(firtAddress + "@"+ split[1]);
        }
        return emailSet.size();
    }
}
