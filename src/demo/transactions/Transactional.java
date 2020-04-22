package demo.transactions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @auther
 */

public class Transactional {
    int count = 0;

    public Transactional() {
        transactions.push(new Transaction(0));
    }
    Map<String, Stack<Transaction>> data = new HashMap<>();
    Stack<Transaction> transactions = new Stack<>();

    public void set(String key, int i) {
        Transaction currentTrans = transactions.peek();
        currentTrans.addKey(key, i);
        Stack<Transaction> values = data.getOrDefault(key, new Stack<>());
        if (values.isEmpty() || values.peek().id != currentTrans.id) values.push(currentTrans);
        data.put(key, values);
    }


    public int get(String key) {
        if (!data.containsKey(key) || data.get(key).isEmpty()) {
           return Integer.MIN_VALUE;
        }
        return data.get(key).peek().getValue(key);
    }

    public void begin() {
        Transaction newTrans = new Transaction(++count);
        transactions.push(newTrans);
    }

    public void commit() {
        Transaction t = transactions.pop();
        Transaction prev = transactions.peek();
        prev.commited.add(t);
    }

    public void unset(String key) {
        Transaction t = transactions.peek();
        t.setUnsetValue(key);
        if (data.get(key).peek().id != t.id) data.get(key).push(t);
    }

    public void abort() {
       Transaction currentTransaction = transactions.pop();
       while (!currentTransaction.commited.isEmpty()) {
           Transaction t = currentTransaction.commited.pop();
           for (String s : t.tData.keySet()) {
               if (data.get(s).peek().id == t.id) data.get(s).pop();
           }
       }
        for (String s : currentTransaction.tData.keySet()) {
            if (data.get(s).peek().id == currentTransaction.id) data.get(s).pop();
        }
    }

    public static void main(String[] args) {
        Transactional t = new Transactional();

        t.set("c", 0);
        t.begin();
            t.set("c", 1);
            t.begin();
                t.unset("c");
                System.out.println(t.get("c"));
                t.set("c", 1);
            t.commit();
        t.commit();
            t.begin();
                t.set("a", 7);
                t.set("b", 7);
                t.unset("c");
                t.unset("a");
            t.abort();
            System.out.println("a -> "  + t.get("a"));
            System.out.println("b -> "  + t.get("b"));
            System.out.println("c -> "  + t.get("c"));
        //t.set("d", 9);
        //t.commit();

//        System.out.println("a -> "  + t.get("a"));
//        System.out.println("b -> "  + t.get("b"));
//        System.out.println("c -> "  + t.get("c"));
//        System.out.println("d -> "  + t.get("d"));
//        System.out.println("e -> "  + t.get("e"));
    }

}


