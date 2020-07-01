package main.tree;

public class BinSearchTree {
    /**
     * 使用递归方法查找元素
     * 从根节点开始，如果为空则返回NULL
     * 若非空，则s与根节点元素比较：
     * 1 s大于根节点键值，只需在右子树寻找
     * 2 s小于根节点键值，只需在左子树寻找
     * 3 s等于根节点键值，搜索完成，返回此节点值或指针
     */
    public static TreeNode find(int s, TreeNode T) {
        if (T != null) {
            if (s > T.value) {
                return find(s, T.right);
            } else if (s < T.value) {
                return find(s, T.left);
            } else {
                return T;
            }
        }
        return null;
    }

    /**
     * 使用迭代方法查找元素
     * 由于递归效率低
     * 可将尾递归改为迭代函数
     * 查找的速度取决于树的高度
     */
    public static TreeNode iterFind(int s, TreeNode T) {
        while (T != null) {
            if (s > T.value) {
                T = T.right;
            } else if (s < T.value) {
                T = T.left;
            } else {
                return T;
            }
        }
        return null;
    }

    /**
     * 使用递归查找最小元素
     */
    public static TreeNode findMin(TreeNode T) {
        if (T == null) {/*空的二叉搜索树，返回NULL*/
            return null;
        } else if (T.left == null) {/*找到最左叶子节点*/
            return T;
        } else {/*沿左子树继续找*/
            return findMin(T.left);
        }
    }

    /**
     * 使用循环查找最小元素
     */
    public static TreeNode iterFindMin(TreeNode T) {
        if (T != null) {
            while (T.left != null) {
                T = T.left;/*沿着左子树一直找，直到最左叶子节点*/
            }
        }
        return T;
    }

    /**
     * 使用递归插入元素
     * 可以借鉴查找的代码
     */
    public static TreeNode insert(int s, TreeNode T) {
        if (T == null) {/*若树为空，生成并返回一个节点的二叉搜索树*/
            T = new TreeNode(s);
            T.left = null;
            T.right = null;
        } else {
            if (s < T.value) {/*递归插入左子树*/
                T.left = insert(s, T.left);
            } else if (s > T.value) {/*递归插入右子树*/
                T.right = insert(s, T.right);
                /*else s已经存在，什么都不做*/
            }
        }
        return T;
    }

    /**
     * 递归删除元素
     * 有三种情况：
     * 1 删除叶节点
     * 2 删除的节点只有一个孩子
     * 3 删除的节点有左右两个孩子
     */
    public static TreeNode delete(int s, TreeNode T) {
        TreeNode tmp;
        if (T == null) {
            System.out.print("要删除的元素未找到");
        } else if (s < T.value) {/* 从左子树递归删除 */
            T.left = delete(s, T.left);
        } else if (s > T.value) {/* 从右子树递归删除 */
            T.right = delete(s, T.right);
        } else {/* BST就是要删除的结点 */
            if (T.left != null && T.right != null) {/* 如果被删除结点有左右两个子结点 */
                tmp = findMin(T.right);/* 从右子树中找最小的元素填充删除结点 */
                T.value = tmp.value;
                T.right = delete(T.value, T.right);/* 从右子树中删除最小元素 */
            } else { /* 被删除结点有一个或无子结点 */
                tmp = T;
                if (T.left == null) {/* 只有右孩子或无子结点 */
                    T = T.right;
                } else if (T.right == null) {/* 只有左孩子或无子结点 */
                    T = T.left;
                }
            }
        }
        return T;
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

        System.out.println(find(11, A).value);
        System.out.println(iterFind(5, A).value);
        System.out.println(findMin(A).value);
        System.out.println(iterFindMin(A).value);
        insert(14, A);
        System.out.println(iterFind(14, A).value);
        delete(14, A);
        System.out.println(iterFind(14, A));
    }
}
