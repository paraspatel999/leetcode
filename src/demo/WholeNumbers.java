package demo;

import java.util.List;

/**
 * @auther
 */

public class WholeNumbers {

    public List<Double> getNumbers(List<Double> numbers, int index, double sum) {


        double d = numbers.get(index);
        double floor = Math.floor(d);

        if ((sum - floor) > 0) {
            List<Double> getLeftNumber = getNumbers(numbers, index+1, sum - floor);
            if (getLeftNumber != null ) {
                getLeftNumber.add(floor);
                return getLeftNumber;
            }
        }
        double ceil = Math.ceil(d);
        if ((sum - ceil) > 0) {
            List<Double> getRightNumber = getNumbers(numbers, index+1, sum - ceil);
            if (getRightNumber != null) {
                getRightNumber.add(ceil);
                return getRightNumber;
            }
        }
        return null;
    }
}
