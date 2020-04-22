package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @auther parapatel
 */

public class InvalidTransaction {

    public class TransactionComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String[] str1 = o1.split(",");
            String[] str2 = o2.split(",");
            if (!str1[0].equals(str2[0])) {
                return str1[0].compareTo(str2[0]);
            }
            if (!str1[3].equals(str2[3])) {
                return str1[3].compareTo(str2[3]);
            }
            return Integer.parseInt(str1[1]) - Integer.parseInt(str2[1]);
        }
    }

    public List<String> invalidTransactions(String[] input) {

        Set<String> result = new HashSet<>();
        Arrays.sort(input, new TransactionComparator());
        String prev = input[0];
        for (int i= 1; i< input.length; i++) {
            String[] prevStr = prev.split(",");
            String[] curr = input[i].split(",");

            if (!prevStr[0].equals(curr[0])) {
                if (Integer.parseInt(prevStr[2]) > 1000){
                    result.add(prev);
                }
                prev = input[i];
                continue;
            }
            if (prevStr[3].equals(curr[3])) {
                if (Integer.parseInt(curr[2]) > 1000){
                    result.add(input[i]);
                }
                prev = input[i];
                continue;
            }
            if (Math.abs(Integer.parseInt(prevStr[1]) - Integer.parseInt(curr[1])) <=60) {
                result.add(prev);
                result.add(input[i]);
                prev = input[i];
            }

        }
        return new ArrayList<>(result);
    }


    public static void main(String[] args) {
        InvalidTransaction s = new InvalidTransaction();
        String[] input = {"alice,10,800,mtv","alice,90,800,mtv", "bob,40,800,fubotv","alice,20,1400,beijing"};

        /*

           "alice,20,1400,beijing"
           "alice,80,800,mtv"
           "alice,90,800,mtv"
         */
        for (String output: s.invalidTransactions(input)) {
            System.out.println(output);
        }
    }
}
