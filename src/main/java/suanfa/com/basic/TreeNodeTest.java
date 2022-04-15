package suanfa.com.basic;

import java.util.*;

public class TreeNodeTest
{

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
       int a = maxDepth( root);
       System.out.println(a);
    }

    //二叉树的最大深度
    //给定一个二叉树，找出其最大深度。
    //二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    //说明: 叶子节点是指没有子节点的节点。
    //示例：
    //给定二叉树 [3,9,20,null,null,15,7]，
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回它的最大深度 3 。
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        //创建一个队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int count = 0;
        while (!deque.isEmpty()) {
            //每一层的个数
            int size = deque.size();
            while (size-- > 0) {
                TreeNode cur = deque.pop();
                if (cur.left != null)
                    deque.addLast(cur.left);
                if (cur.right != null)
                    deque.addLast(cur.right);
            }
            count++;
        }
        return count;
    }

    //验证二叉搜索树
    //给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
    //
    //有效 二叉搜索树定义如下：
    //
    //节点的左子树只包含 小于 当前节点的数。
    //节点的右子树只包含 大于 当前节点的数。
    //所有左子树和右子树自身必须也是二叉搜索树。
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    //对称二叉树
    //给你一个二叉树的根节点 root ， 检查它是否轴对称。
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        //从两个子节点开始判断
        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        //如果左右子节点都为空，说明当前节点是叶子节点，返回true
        if (left == null && right == null)
            return true;
        //如果当前节点只有一个子节点或者有两个子节点，但两个子节点的值不相同，直接返回false
        if (left == null || right == null || left.val != right.val)
            return false;
        //然后左子节点的左子节点和右子节点的右子节点比较，左子节点的右子节点和右子节点的左子节点比较
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    //二叉树的层序遍历
    //给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
    public List<List<Integer>> levelOrder(TreeNode root) {
        //边界条件判断
        if (root == null)
            return new ArrayList<>();
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        //根节点入队
        queue.add(root);
        //如果队列不为空就继续循环
        while (!queue.isEmpty()) {
            //BFS打印，levelNum表示的是每层的结点数
            int levelNum = queue.size();
            //subList存储的是每层的结点值
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                //出队
                TreeNode node = queue.poll();
                subList.add(node.val);
                //左右子节点如果不为空就加入到队列中
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            //把每层的结点值存储在res中，
            res.add(subList);
        }
        return res;
    }

    //将有序数组转换为二叉搜索树
    //给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
    //
    //高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0)
            return null;
        return sortedArrayToBST(num, 0, num.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);
        return root;
    }

    //二叉树的中序遍历
    //给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
    //输入：root = [1,null,2,3]
    //输出：[1,3,2]

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        //递归的终止条件
        if (root == null)
            return;
        //递归遍历左子节点
        inorder(root.left, res);
        //访问当前节点
        res.add(root.val);
        //递归遍历右子节点
        inorder(root.right, res);
    }

    //二叉搜索树中第K小的元素
    //给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
    //输入：root = [3,1,4,null,2], k = 1
    //输出：1
    public int kthSmallest(TreeNode root, int k) {
        //先统计左子节点的个数
        int leftCount = countNodes(root.left);
        if (leftCount >= k) {
            //如果左子节点的个数大于等于k，说明我们要找的元素就在左子节点中，
            //直接在左子节点中查找即可
            return kthSmallest(root.left, k);
        } else if (leftCount + 1 == k) {
            //如果左子节点的个数加当前节点（1）正好等于k，说明根节点
            //就是要找到元素
            return root.val;
        } else {
            //否则要找的元素在右子节点中，到右子节点中查找
            return kthSmallest(root.right, k - 1 - leftCount);
        }
    }

    //统计节点个数
    public int countNodes(TreeNode n) {
        if (n == null)
            return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }

}
