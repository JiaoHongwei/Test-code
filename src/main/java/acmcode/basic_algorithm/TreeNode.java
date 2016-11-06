package acmcode.basic_algorithm;

import java.util.Stack;

/**
 * Created by jiaohongwei on 2016/9/8.
 */
public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
        this.val = val;
    }

    /**
     * 404. Sum of Left Leaves  QuestionEditorial Solution
     * 求所有左子树的和
     *
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = sumOfLeftLeaves(root.left);
            if (root.left.left == null && root.left.right == null)
                left += root.left.val;
        }
        if (root.right != null)
            right = sumOfLeftLeaves(root.right);
        return left + right;
    }

    //返回二叉树的深度
    static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    static void scanNodes(TreeNode root) {
        if (root == null) {
            return;
        }
//            System.out.println(root.val); //先序遍历
        scanNodes(root.left);
//            System.out.println(root.val); //中序遍历
        scanNodes(root.right);
        System.out.println(root.val); //后序遍历
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        TreeNode right1 = new TreeNode(4);
        //创建一棵树
        root.left = left1;
        left1.right = left2;
        root.right = right1;
        scanNodes(root);
        System.out.println("树的深度是：" + getDepth(root));

    }

    /**
     * 反转 二叉树  递归
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 翻转二叉树 迭代
     *
     * @param root 二叉树的根
     * @return
     */
    public TreeNode invertTreeByIterate(TreeNode root) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }

    /**
     * 100. Same Tree  QuestionEditorial Solution
     * 判断两个tree是不是一样的
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val && isSameTree(p.right, q.right) && isSameTree(p.left, q.left)) {
            return true;
        }
        return false;
    }

}
