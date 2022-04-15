package suanfa.com.basic;

import java.util.*;

public class ListNodeMidTest {

    //两数相加
    //给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    //
    //请你将两个数相加，并以相同形式返回一个表示和的链表。
    //输入：l1 = [2,4,3], l2 = [5,6,4]
    //输出：[7,0,8]
    //解释：342 + 465 = 807.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode p = res;//头指针
        int flag = 0;//进位标志
        while(l1!=null&&l2!=null){
            res.val = l1.val + l2.val + flag;
            flag = res.val / 10;
            res.val = res.val % 10;
            l1 = l1.next;
            l2 = l2.next;
            //解决当两个链表长度相等时，会多申请一个值为0的节点
            if(l1 == null || l2 == null){
                break;
            }
            //申请一个新节点链接到res并将res指向新节点
            ListNode t = new ListNode();
            res.next = t;
            res = t;
        }
        while(l1!=null){
            ListNode t = new ListNode();
            t.val = l1.val + flag;
            flag = t.val / 10;
            t.val = t.val % 10;
            res.next = t;
            res = t;
            l1 = l1.next;
        }
        while(l2!=null){
            ListNode t = new ListNode();
            t.val = l2.val + flag;
            flag = t.val / 10;
            t.val = t.val % 10;
            res.next = t;
            res = t;
            l2 = l2.next;
        }
        //判断最高位是否有进位
        if(flag==1){
            res.next = new ListNode(1,null);
        }
        return p;
    }

    //反转链表
    //输入：head = [1,2,3,4,5]
    //输出：[5,4,3,2,1]
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        //把链表节点全部摘掉放到栈中
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty())
            return null;
        ListNode node = stack.pop();
        ListNode dummy = node;
        //栈中的结点全部出栈，然后重新连成一个新的链表
        while (!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        //最后一个结点就是反转前的头结点，一定要让他的next
        //等于空，否则会构成环
        node.next = null;
        return dummy;
    }

    //合并两个有序链表
    //输入：l1 = [1,2,4], l2 = [1,3,4]
    //输出：[1,1,2,3,4,4]
    public ListNode mergeTwoLists(ListNode linked1, ListNode linked2) {
        //下面4行是空判断
        if (linked1 == null)
            return linked2;
        if (linked2 == null)
            return linked1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (linked1 != null && linked2 != null) {
            //比较一下，哪个小就把哪个放到新的链表中
            if (linked1.val <= linked2.val) {
                curr.next = linked1;
                linked1 = linked1.next;
            } else {
                curr.next = linked2;
                linked2 = linked2.next;
            }
            curr = curr.next;
        }
        //然后把那个不为空的链表挂到新的链表中
        curr.next = linked1 == null ? linked2 : linked1;
        return dummy.next;
    }

    //合并K个排序链表
    //给你一个链表数组，每个链表都已经按升序排列。
    //
    //请你将所有链表合并到一个升序链表中，返回合并后的链表。
    //输入：lists = [[1,4,5],[1,3,4],[2,6]]
    //输出：[1,1,2,3,4,4,5,6]
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode node1, ListNode node2){
                return node1.val - node2.val;
            }
        });

        for(ListNode node: lists){
            if(node != null){
                q.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while(!q.isEmpty()){
            ListNode node = q.poll();

            if(node.next != null){
                q.offer(node.next);
            }

            node.next = null;
            p.next = node;
            p = p.next;
        }

        return dummyHead.next;
    }

    //奇偶链表
    //给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
    //
    //第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
    //
    //请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        //奇数链表的头节点
        ListNode oddHead = head;
        //奇数链表的当前节点
        ListNode oddCur = oddHead;

        //偶数链表的头节点
        ListNode evenHead = head.next;
        //偶数链表的当前节点
        ListNode evenCur = evenHead;

        while (evenCur != null && evenCur.next != null) {
            //奇数节点串一起
            oddCur.next = oddCur.next.next;
            //偶数节点串一起
            evenCur.next = evenCur.next.next;
            //奇偶指针往后移
            oddCur = oddCur.next;
            evenCur = evenCur.next;
        }
        //最后偶数链表和奇数链表需要串在一起
        oddCur.next = evenHead;
        return oddHead;
    }

    //相交链表
    //给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //创建集合set
        Set<ListNode> set = new HashSet<>();
        //先把链表A的结点全部存放到集合set中
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        //然后访问链表B的结点，判断集合中是否包含链表B的结点，如果包含就直接返回
        while (headB != null) {
            if (set.contains(headB))
                return headB;
            headB = headB.next;
        }
        //如果集合set不包含链表B的任何一个结点，说明他们没有交点，直接返回null
        return null;
    }


    //反转链表
    public ListNode reverseList22(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        //把链表节点全部摘掉放到栈中
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty())
            return null;
        ListNode node = stack.pop();
        ListNode dummy = node;
        //栈中的结点全部出栈，然后重新连成一个新的链表
        while (!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        //最后一个结点就是反转前的头结点，一定要让他的next
        //等于空，否则会构成环
        node.next = null;
        return dummy;
    }

    //删除链表中的节点
    //请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
    //
    //输入：head = [4,5,1,9], node = 5
    //输出：[4,1,9]
    public void deleteNode(ListNode node) {
        //把要删除结点的下一个结点的值赋给要删除的结点
        node.val = node.next.val;
        //然后删除下一个结点
        node.next = node.next.next;

    }


    //移除链表元素
    private ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode index = head;
        // 如果当前节点的 next节点值和 val相同，则删除。如果不相同，继续执行下一个。
        while (index != null && index.next != null) {
            if (index.next.val == val) {
                index.next = index.next.next;
                continue;// 这里是关键，防止出现多个目标值时露删的情况
            }
            index = index.next;
        }
        // 最后处理头部
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    //删除链表的倒数第N个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slow = dummyHead, fast = dummyHead;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
    public ListNode removeNthFromEnd1(ListNode head, int n) {

        ListNode tail=head,top=head;
        for(int i=0;i<n;i++){
            tail=tail.next;
        }
        if(tail==null){
            return head.next;
        }
        while(tail.next!=null){
            top=top.next;
            tail=tail.next;
        }
        top.next=top.next.next;
        return head;

    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode pre = head;
        int last = length(head) - n;
        //如果last等于0表示删除的是头结点
        if (last == 0)
            return head.next;
        //这里首先要找到要删除链表的前一个结点
        for (int i = 0; i < last - 1; i++) {
            pre = pre.next;
        }
        //然后让前一个结点的next指向要删除节点的next
        pre.next = pre.next.next;
        return head;
    }

    //求链表的长度
    private int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    //奇偶链表
    public ListNode oddEvenList3(ListNode head) {
        //快慢指针
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            ListNode target=fast.next;
            fast.next=fast.next.next;
            fast=fast.next;
            target.next=slow.next;
            slow.next=target;
            slow=slow.next;
        }
        return head;

    }

    //回文链表
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack();
        //把链表节点的值存放到栈中
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        //然后再出栈
        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //5、LinkedList 去除重复元素
    public static void main222(String []args) {
        System.out.println("Hello World!");
        LinkedList<String> list = new LinkedList<>();
        list.add("wwew");
        list.add("eeee");
        list.add("eeee");
        LinkedList<String> linkedList = new LinkedList<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String str=it.next();
            if (!linkedList.contains(str)){
                linkedList.add(str);
            }
        }
        System.out.println(linkedList.size());
    }

    //6、你的代码需要从标准输入流（控制台）中读取一段字符串，利用 LinkedList 中的方法将该字符串反转输出在标准输出流（控制台）中。
    public static void main2323(String[] args) {

        //write your code here
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入：");
        String text = sc.next();

        System.out.print(text);
        //转化为集合字符集合
        char[] ch = text.toCharArray();
        LinkedList<Character> linkedList = new LinkedList<Character>();
        for (Character c : ch) {
            linkedList.add(c);
        }
        for (int i = linkedList.size()-1; i >= 0; i--) {
            System.out.print(linkedList.get(i));
        }
    }

    //旋转链表
    //给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
    //输入：head = [1,2,3,4,5], k = 2
    //输出：[4,5,1,2,3]
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        // 记录链表长度
        int length = 1;
        // 复制链表
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            length++;
        }
        // 真正需要移动的步数
        int add = length - k % length;
        // 若移动步数与长度相等，则会复原（无需操作）
        if (add == length) {
            return head;
        }
        // 指向头节点，形成循环链表
        iter.next = head;
        // 移动
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        // 断开
        iter.next = null;
        return ret;
    }

    //环形链表
    //给你一个链表的头节点 head ，判断链表中是否有环。
    //
    //如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
    //输入：head = [3,2,0,-4], pos = 1
    //输出：true
    //解释：链表中有一个环，其尾部连接到第二个节点。
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        //快慢两个指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            //慢指针每次走一步
            slow = slow.next;
            //快指针每次走两步
            fast = fast.next.next;
            //如果相遇，说明有环，直接返回true
            if (slow == fast)
                return true;
        }
        //否则就是没环
        return false;

    }

    //环形链表 II
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            //快慢指针，快指针每次走两步，慢指针每次走一步
            fast = fast.next.next;
            slow = slow.next;
            //先判断是否有环，
            if (slow == fast) {
                //确定有环之后才能找环的入口
                while (head != slow) {
                    //两相遇指针，一个从头结点开始，
                    //一个从相遇点开始每次走一步，直到
                    //再次相遇为止
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }


}
