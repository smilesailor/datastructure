package main.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class ApplicationOfTraversal {
    /**
     * 求树的高度：
     * 使用后序遍历的方法
     * Height=max{H_{l},H_{r}}+1
     */
    public static int postOrderGetHeight(TreeNode head) {
        int HL, HR, MaxH;
        TreeNode T = head;
        if (T != null) {
            HL = postOrderGetHeight(head.left);
            HR = postOrderGetHeight(head.right);
            MaxH = (HL >= HR) ? HL : HR;
            return MaxH + 1;
        } else {
            return 0;
        }
    }

    /**
     * 求树的高度：
     * 使用递归的方法
     * Height=max{H_{l},H_{r}}+1
     */
    public static int maxDepth(TreeNode root) {
        int Hl, HR, MaxH;
        if (root == null) {
            return 0;
        }
        Hl = maxDepth(root.left);
        HR = maxDepth(root.right);
        MaxH = Math.max(Hl, HR) + 1;
        return MaxH;
    }

    /**
     * 求树的高度：
     * 使用循环的方法
     * 使用队列
     */
    public static int itermaxDepth(TreeNode root) {
        TreeNode T = root;
        if (T == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();/*创建队列*/
        queue.offer(T);/*节点入队*/
        int level = 0;/*记录当前层的指标*/
        while (!queue.isEmpty()) {
            level++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                T = queue.poll();/*节点出队*/
                if (T.left != null) {/*其左右儿子入队*/
                    queue.offer(T.left);
                }
                if (T.right != null) {/*其左右儿子入队*/
                    queue.offer(T.right);
                }
            }
        }
        return level;
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(6);
        TreeNode B = new TreeNode(3);
        TreeNode C = new TreeNode(9);
        TreeNode D = new TreeNode(1);
        TreeNode E = new TreeNode(4);
        TreeNode F = new TreeNode(7);
        TreeNode G = new TreeNode(10);
        TreeNode H = new TreeNode(2);
        TreeNode I = new TreeNode(5);
        TreeNode J = new TreeNode(8);
        TreeNode K = new TreeNode(11);

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        D.right = H;
        E.right = I;
        F.right = J;
        G.right = K;

        System.out.println(postOrderGetHeight(A));
        System.out.println(maxDepth(A));
        System.out.println(itermaxDepth(A));
    }
}
