package com.company;

import java.util.*;
public class ValidTree {
        public static boolean validTree(int n, int[][] edges) {
            if (n == 0) {
                return false;
            }

            if (edges.length != n - 1) {
                return false;
            }

            HashMap<Integer, HashSet<Integer>> graph = initialGraph(edges, n);

            // Queue to keep track of nodes that need to process
            Queue<Integer> queue = new LinkedList<>();
            // Set to track of nodes that already have been processed
            Set<Integer> set = new HashSet<>();


            queue.offer(0);
            set.add(0);

            while (!queue.isEmpty()) {
                int head = queue.poll();
                for (Integer neighbor : graph.get(head)) {
                    if (set.contains(neighbor)) {
                        return false;
                    }
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }

            return set.size() == n;
        }

        /* if we want to check whether it's a valid tree, we have to know where the head is and what's its child. This means it requires to have a data structure to keep track of how nodes connected. int[][] edges is not sufficient, since we don't want to go over this 2-d array each time when we want to find connection. Therefore, a better solution might be the adjacency matrix.
         */
        private static HashMap<Integer, HashSet<Integer>> initialGraph(int[][] edges, int n) {
            HashMap<Integer, HashSet<Integer>> res = new HashMap<Integer, HashSet<Integer>>();

            // for (int i = 0; i < edges.length; i++) {
            //     int u = edges[i][0];
            //     int v = edges[i][1];
            //     if (res.get(u) == null) {
            //         res.put(u, new HashSet<Integer>());
            //     }
            //     res.get(u).add(v);
            //     if (res.get(v) == null) {
            //         res.put(v, new HashSet<Integer>());
            //     }
            //     res.get(v).add(u);
            // }
            for (int i=0; i<n; ++i) {
                res.put(i, new HashSet<Integer>());
            }
            for (int[] edge: edges) {
                res.get(edge[0]).add(edge[1]);
                res.get(edge[1]).add(edge[0]);
            }

            return res;
        }

        public static void main(String[] args) {
            int[][] arg = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
            validTree(5,arg);
        }
}
