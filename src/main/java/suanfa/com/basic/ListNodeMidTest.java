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

}
