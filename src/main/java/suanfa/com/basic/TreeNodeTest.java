package suanfa.com.basic;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNodeTest
{

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
       int a = maxDepth( root);
       System.out.println(a);
    }
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
}
