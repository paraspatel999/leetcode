package demo.arrays;

/**
 * @auther parapatel
 */

public class NumbersToWords {

    public String numberToWords(int num) {
        String[] terms = new String[]{"", "Thousand", "Million", "Billion", "Trillion"};
        int i = 0;
        String res = "";
        while (num > 0) {
            int nextThreeDigit = num %1000;
            if (nextThreeDigit > 0) {
                res = getWordFor3Digit(nextThreeDigit) + " " + terms[i] +  " " + res;
            }
            i++;
            num = num /1000;
        }
        return res.trim();
    }

    private String getWordFor3Digit(int n) {
        String[] oneToTwenty = new String[]{"", "One", "Two", "Three", "four", "five", "six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen","Seventeen", "Eighteen" ,"Nineteen"};

        String[] mutliplier = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        StringBuilder sb = new StringBuilder();
        if (n/100 > 0) {
            sb.append(oneToTwenty[n/100] + " Hundred ");
        }
        int lastTwo = n%100;
        if (lastTwo < 20) {
            sb.append(oneToTwenty[lastTwo]);
        } else {
            sb.append(mutliplier[lastTwo/10 - 2] + " " + oneToTwenty[lastTwo%10]);
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        NumbersToWords n = new NumbersToWords();
        int num = 1000;
        System.out.println((int)1e9);
    }
}
