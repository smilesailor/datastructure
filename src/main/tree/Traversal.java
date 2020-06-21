package main.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
    /**
     * 递归方式实现先序遍历：
     * 首先访问根节点
     * 然后先序遍历左子树
     * 最后先序遍历右子树
     */
    public static void preOrderTraversalByRecursion(TreeNode head){
        if (head!=null){
            System.out.print(head.value + " ");
            preOrderTraversalByRecursion(head.left);
            preOrderTraversalByRecursion(head.right);
        }
    }

    /**
     * 非递归方式实现先序遍历：
     * 遇到一个节点就访问它并压入堆栈，遍历这个节点的左子树
     * 当左子树遍历结束后，从栈顶弹出这个节点
     * 然后遍历这个节点的右子树
     */
    public static void preOrderTraversalByLoop(TreeNode head){
        TreeNode T = head;
        Stack<TreeNode> stack = new Stack<>();
        while (T != null || !stack.isEmpty()){
            while (T != null){/*一路向左并将沿途节点压入堆栈*/
                System.out.print(T.value + " ");/*访问节点*/
                stack.push(T);
                T = T.left;
            }
            if (!stack.isEmpty()){
                T = stack.pop();/*节点弹出堆栈*/
                T = T.right;/*转向右子树*/
            }
        }
    }

    /**
     * 递归方式实现中序遍历：
     * 首先中序遍历左子树
     * 然后访问根节点
     * 最后中序遍历右子树
     */
    public static void inOrderTraversalByRrcursion(TreeNode head){
        if (head!=null){
            inOrderTraversalByRrcursion(head.left);
            System.out.print(head.value + " ");
            inOrderTraversalByRrcursion(head.right);
        }
    }

    /**
     * 非递归方式实现中序遍历：
     * 遇到一个节点就把它压入堆栈，遍历这个节点的左子树
     * 当左子树遍历结束后，从栈顶弹出这个节点并访问它
     * 然后遍历这个节点的右子树
     */
    public static void inOrderTraversalByLoop(TreeNode head){
        TreeNode T = head;
        Stack<TreeNode> stack= new Stack<>();
        while (T!=null || !stack.isEmpty()){
            while (T!=null){/*一路向左并将沿途节点压入堆栈*/
                stack.push(T);
                T = T.left;
            }
            if(!stack.isEmpty()){
                T = stack.pop();/*节点弹出堆栈*/
                System.out.print(T.value + " ");/*访问节点*/
                T = T.right;/*转向右子树*/
            }
        }
    }

    /**
     * 递归方式实现后序遍历：
     * 首先后序遍历左子树
     * 然后后序遍历右子树
     * 最后访问根节点
     */
    public static void postOrderTraversalByReCursion(TreeNode head){
        if (head!=null){
            postOrderTraversalByReCursion(head.left);
            postOrderTraversalByReCursion(head.right);
            System.out.print(head.value + " ");
        }
    }

    /**
     * 非递归方式实现后序遍历：
     * 遇到一个节点就把它压入堆栈，遍历这个节点的左子树
     * 当左子树遍历结束后，从栈顶暂时弹出这个节点
     * 如果该节点的右子树已被访问或右子树不存在,则访问结点
     * 否则不应该弹出该结点, 结点再次入栈并继续遍历右子树
     */
    public static void postOrderTraversalByLoop(TreeNode head){
        TreeNode T = head;
        TreeNode P = null;/*P是上一个已经被访问的节点*/
        Stack<TreeNode> stack = new Stack<>();
        while (T!=null || !stack.isEmpty()){
            while (T!=null){/*一直向左并将沿途结点压入堆栈*/
                stack.push(T);
                T = T.left;
            }
            if (!stack.isEmpty()){
                T = stack.pop();/*暂时将节点弹出*/
                if (T.right == P || T.right == null){/*如果，右孩子已访问或右孩子不存在, 访问结点*/
                    System.out.print(T.value + " ");/*访问节点*/
                    P = T;/*p指向已经被访问的节点*/
                    T = null;/*树置为空(该树的左\右\根结点已经访问)*/
                }
                else {
                    stack.push(T);/*否则，不应该弹出结点, 结点再次入栈*/
                    T = T.right;/*继续遍历右子树*/
                }
            }
        }
    }

    /**
     * 层次遍历可以通过队列来实现：
     * 从根节点开始
     * 首先根节点入队
     * 然后执行循环：节点出队，访问该节点，其左右儿子入队
     */
    public static void levelOrderTraversalByQueue(TreeNode head){
        TreeNode T = head;
        if (T!=null){
            Queue<TreeNode> queue = new ArrayDeque<>();/*创建队列*/
            queue.offer(T);/*根节点入队*/
            while (!queue.isEmpty()){
                T = queue.poll();/*节点出队*/
                System.out.print(T.value + " ");/*访问节点*/
                if (T.left!=null){/*其左右儿子入队*/
                    queue.offer(T.left);
                }
                if (T.right!=null){
                    queue.offer(T.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");
        TreeNode J = new TreeNode("J");
        TreeNode K = new TreeNode("K");

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        D.left = H;
        D.right = I;
        E.right = J;
        C.left = F;
        C.right = G;
        F.right = K;

        preOrderTraversalByRecursion(A);
        System.out.println();
        preOrderTraversalByLoop(A);
        System.out.println();
        inOrderTraversalByRrcursion(A);
        System.out.println();
        inOrderTraversalByLoop(A);
        System.out.println();
        postOrderTraversalByReCursion(A);
        System.out.println();
        postOrderTraversalByLoop(A);
        System.out.println();
        levelOrderTraversalByQueue(A);
    }
}