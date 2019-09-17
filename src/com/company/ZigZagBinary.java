package com.company;
import java.text.CollationElementIterator;
import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class ZigZagBinary {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();

                curLevel.add(head.val);
                // add next level to queue by the order

                if (head.right != null) {
                    queue.offer(head.right);
                }
                if (head.left != null) {
                    queue.offer(head.left);
                }
            }
            if (level % 2 == 0) {
                Collections.reverse(curLevel);
                res.add(curLevel);
            } else {
                res.add(curLevel);
            }
            level++;


        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode x = new TreeNode(3);
        x.left = new TreeNode(6);
        x.right = new TreeNode(9);
        x.right.left = new TreeNode(15);
        x.right.right = new TreeNode(18);
        System.out.println(zigzagLevelOrder(x));

        // 3, 9 6, 15 18
    }
}
