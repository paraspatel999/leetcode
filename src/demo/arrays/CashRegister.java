package demo.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther
 */

public class CashRegister {
    public List<String> getChange(double amount, String[] amountPaid) {
        Map<String, Double> money = new HashMap<>();

        money.put("PENNY", 0.1);
        money.put("NICKEL", 0.5);
        money.put("DIME", 0.10);
        money.put("QUARTER", 0.25);
        money.put("HALF A DOLLAR", 0.1);
        money.put("PENNY", 0.1);

        return new ArrayList<>();
    }
}
