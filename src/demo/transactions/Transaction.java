package demo.transactions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @auther
 */

public class Transaction {
    class Value {
        int value;
        boolean isUnset = false;
        public Value(int i) {
            this.value = i;
        }

    }
    final int id;
    Stack<Transaction> commited = new Stack<>();
    Map<String, Value> tData = new HashMap<>();

    public Transaction(int id) {
        this.id = id;
    }

    public void addKey(String key, int value) {
        Value v = this.tData.get(key);
        if (v == null) v = new Value(value);
        else {
            v.value = value;
            v.isUnset = false;
        }
        this.tData.put(key, v);
    }

    public void setUnsetValue(String key) {
        Value v = this.tData.get(key);
        if (v != null) {
            v.isUnset = true;
        } else {
            Value newValue = new Value(Integer.MIN_VALUE);
            newValue.isUnset = true;
            this.tData.put(key, newValue);
        }
    }

    public int getValue(String key) {
        Value v = this.tData.get(key);
        if (v != null && !v.isUnset) {
            return v.value;
        }
        return Integer.MIN_VALUE;
    }

}
