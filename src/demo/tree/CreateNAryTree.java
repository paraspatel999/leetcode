package demo.tree;

import com.sun.org.apache.xpath.internal.operations.String;

import javax.transaction.TransactionRequiredException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @auther
 */

public class CreateNAryTree {
    class TreeNode {
        String data;
        List<TreeNode> children;

        public TreeNode(String data) {
            this.data= data;
            this.children = new LinkedList<>();
        }
    }

//    public TreeNode createTree(String input) {
//        Stack<TreeNode> st = new Stack<>();
//        StringBuilder sb = new StringBuilder();
//
//        return new TreeNode();
//    }
}
