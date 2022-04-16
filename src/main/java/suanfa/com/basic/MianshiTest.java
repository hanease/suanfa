package suanfa.com.basic;

import java.util.*;

public class MianshiTest {

    public static void main(String[] args) {
        double[] myList = {1.9, 2.9, 3.4, 3.5};
        int[] input = new int[]{3, 1, 2, 6, -4, 2};
        int[] nums = new int[]{1, 1, 2, 3, 4, 4, 5};
        int[] nums1 = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("");
    }

    //面试题 01.01. 判定字符是否唯一
    //实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
    //
    //示例 1：
    //
    //输入: s = "leetcode"
    //输出: false
    public boolean isUnique(String astr) {
        for (int i=0;i<astr.length();i++){
            if (astr.lastIndexOf(astr.charAt(i))!=i){
                return false;
            }
        }
        return true;
    }

    public boolean isUnique2(String astr) {
        HashSet<Character> set = new HashSet<>();
        for(char c : astr.toCharArray()){
            if(!set.add(c)) {
                return false;
            }
        }
        return true;
    }

    //面试题 01.02. 判定是否互为字符重排
    //给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
    //
    //示例 1：
    //
    //输入: s1 = "abc", s2 = "bca"
    //输出: true
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for(int i = 0 ; i < c1.length ; i ++){
            if(c1[i] != c2[i]){
                return false;
            }
        }
        return true;
    }

    //面试题 01.03. URL化
    //URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
    //示例 1：
    //输入："Mr John Smith    ", 13
    //输出："Mr%20John%20Smith"
    public String replaceSpaces(String S, int length) {
        return S.substring(0,length).replace(" ","%20");
    }

    //面试题 01.06. 字符串压缩
    //字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
    //
    //示例1:
    //
    // 输入："aabcccccaaa"
    // 输出："a2b1c5a3"
    // 快慢指针
    public String compressString(String S) {
        if(S.length() == 0) return S;
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int slow = 0, fast = 0;
        while(fast <= chars.length){
            if(fast == chars.length){
                sb.append(chars[slow]).append(fast-slow);
            }else if(chars[fast] != chars[slow]){
                sb.append(chars[slow]).append(fast-slow);
                slow = fast;
            }
            fast++;
        }
        return sb.length() < chars.length ? sb.toString() : S;
    }

    //面试题 01.04. 回文排列
    //给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
    //
    //回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
    //
    //回文串不一定是字典当中的单词。输入："tactcoa"
    //输出：true（排列有"tacocat"、"atcocta"，等等）
    public boolean canPermutePalindrome(String s) {
        if(s == null){
            return false;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char c : chars){
            if(set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        return set.size() <= 1;
    }

    //面试题 01.07. 旋转矩阵
    //给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
    //
    //不占用额外内存空间能否做到？

    //给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
    //给定 matrix =
    //[
    //  [1,2,3],
    //  [4,5,6],
    //  [7,8,9]
    //],
    //原地旋转输入矩阵，使其变为:
    //[
    //  [7,4,1],
    //  [8,5,2],
    //  [9,6,3]
    //]
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrix[i][j] ^ matrix[n - i - 1][j];
                matrix[n - i - 1][j] = matrix[i][j] ^ matrix[n - i - 1][j];
                matrix[i][j] = matrix[i][j] ^ matrix[n - i - 1][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                matrix[j][i] = matrix[i][j] ^ matrix[j][i];
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
            }
        }
    }

    //面试题 01.08. 零矩阵
    //编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
    public void setZeroes(int[][] matrix) {
        ArrayList<int[]> book = new ArrayList();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    int[] a = new int[2];
                    a[0] = i;
                    a[1] = j;
                    book.add(a);
                }
            }
        }

        for (int[] b : book) {
            for (int i = 0; i <m ; i++) {
                matrix[i][b[1]]=0;
            }
            for (int i = 0; i <n ; i++) {
                matrix[b[0]][i]=0;
            }
        }
    }


    //面试题 01.09. 字符串轮转
    //字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
    //
    //示例1:
    //
    // 输入：s1 = "waterbottle", s2 = "erbottlewat"
    // 输出：True
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length()!=s2.length()) return false;
        String ss = s2+s2;
        return ss.contains(s1);
    }

    //面试题 02.01. 移除重复节点
    //编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
    //
    //示例1:
    //
    // 输入：[1, 2, 3, 3, 2, 1]
    // 输出：[1, 2, 3]
    public ListNode removeDuplicateNodes(ListNode head) {

        if (head == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null) {
            if (!set.contains(pre.next.val)) {
                set.add(pre.next.val);
                pre = pre.next;
            } else {
                pre.next = pre.next.next;
            }
        }
        return dummyHead.next;

    }

    //面试题 02.06. 回文链表
    //编写一个函数，检查输入的链表是否是回文的。
    //输入： 1->2
    //输出： false
    //示例 2：
    //
    //输入： 1->2->2->1
    //输出： true
    public boolean isPalindrome(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head;
        Stack<Integer> stack = new Stack<>();
        while(node1 != null) {
            stack.push(node1.val);
            node1 = node1.next;
        }
        while(node2 != null) {
            if(node2.val == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
            node2 = node2.next;
        }
        return true;
    }

    //面试题 02.07. 链表相交
    //给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
    //输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
    //输出：Intersected at '8'
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



    //面试题 08.07. 无重复字符串的排列组合
    //无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
    //
    //示例1:
    //
    // 输入：S = "qwe"
    // 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
    private List<String> list = new ArrayList<>();
    public String[] permutation(String S) {
        char[] ch = S.toCharArray();
        StringBuffer sb = new StringBuffer();
        boolean[] visited = new boolean[ch.length];
        backTrack(ch,sb,visited);
        return list.toArray(new String[sb.length()]);
    }

    public void backTrack(char[] ch,StringBuffer sb,boolean[] visited){
        if(sb.length() == ch.length){
            list.add(sb.toString());
        }
        for(int i = 0;i < ch.length;i++){
            if(!visited[i]){
                visited[i] = true;
                sb.append(ch[i]);
                backTrack(ch,sb,visited);
                sb.deleteCharAt(sb.length()-1);
                visited[i] = false;
            }
        }
    }

    //面试题 08.09. 括号
    //括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
    //
    //说明：解集不能包含重复的子集。
    //
    //例如，给出 n = 3，生成结果为：
    //
    //[
    //  "((()))",
    //  "(()())",
    //  "(())()",
    //  "()(())",
    //  "()()()"
    //]
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list,new StringBuilder("("),1,2*n,new char[]{'(',')'});
        return list;
    }
    private void backtrack(List<String> list,StringBuilder sb,int k,int n,char[] arr){
        if(k < 0) return;
        if(sb.length() == n){
            if(k ==0)list.add(sb.toString());
        }else{
            for(int i=0; i<2; i++){
                sb.append(arr[i]);
                int f = i == 0 ? 1 : -1;
                backtrack(list,sb,k+f,n,arr);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    //面试题 08.10. 颜色填充
    //编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
    //待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。需要填充的新颜色为 newColor 。
    //「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
    //请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
    //输入：
    //image = [[1,1,1],[1,1,0],[1,0,1]]
    //sr = 1, sc = 1, newColor = 2
    //输出：[[2,2,2],[2,2,0],[2,0,1]]
    //解释:
    //初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
    //初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
    //注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        helper(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    private void helper(int[][] image, int i, int j, int oldColor, int newColor){
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor || image[i][j] == newColor) return;
        image[i][j] = newColor;
        helper(image, i+1, j, oldColor, newColor);
        helper(image, i-1, j, oldColor, newColor);
        helper(image, i, j+1, oldColor, newColor);
        helper(image, i, j-1, oldColor, newColor);
    }

    //面试题 08.03. 魔术索引
    //魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
    //
    //示例1:
    //
    // 输入：nums = [0, 2, 3, 4, 5]
    // 输出：0
    // 说明: 0下标的元素为0
    public int findMagicIndex(int[] nums) {
        for(int i=0;i<nums.length; ){
            if(nums[i]==i)
                return i;
            i=Math.max(nums[i],i+1);
        }
        return -1;
    }

    //面试题 08.13. 堆箱子
    //堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。实现一种方法，搭出最高的一堆箱子。箱堆的高度为每个箱子高度的总和。
    //
    //输入使用数组[wi, di, hi]表示每个箱子。
    // 输入：box = [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
    // 输出：6
    //示例2:
    // 输入：box = [[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]
    // 输出：10
    public int pileBox(int[][] box) {
        Arrays.sort(box, (i, j) -> (i[0] != j[0] ? i[0] - j[0] : (i[1] != j[1] ? i[1] - j[1] : i[2] - j[2])));
        int[] dp = new int[box.length];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = box[i][2];
            for(int j = 0; j < i; j++) if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2])
                dp[i] = Math.max(dp[i], box[i][2] + dp[j]);
        }
        return Arrays.stream(dp).max().orElse(0);
    }
    public int pileBox1(int[][] box) {
        int m = box.length;
        if (m == 0) {
            return 0;
        }
        Arrays.sort(box, (o1, o2) -> o1[0] - o2[0]);
        int[] dp = new int[m];
        int res = 0;
        for (int i = 0; i < m; i++) {
            dp[i] = box[i][2];
            for (int j = 0; j < i; j++) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + box[i][2]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    //面试题 08.14. 布尔运算
    //给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。
    //
    //示例 1:
    //
    //输入: s = "1^0|0|1", result = 0
    //
    //输出: 2
    //解释: 两种可能的括号方法是
    //1^(0|(0|1))
    //1^((0|0)|1)
    /*解题思路：动态规划
     * 从s~e 选取一个中间操作符，如果 左 操作符 右 的结果==result,则当前位置选取的操作符对应种类为 ：左*右
     * 然后选取到下一个位置操作符
     * dp[i][j][k]：表示截取字符串从：i~j，该字符串结果为 k 的表达式种类  */
    public int countEval(String s, int result) {
        char []chars=s.toCharArray();
        int len=s.length();
        int [][][]dp=new int[len][len][2];
        //初始化
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                for(int k=0;k<2;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return count(dp,chars,0,len-1,result);
    }
    private int count(int[][][]dp,char[]arr,int start,int end,int result){
        //当起点终点一致，表示递归结束
        if(start==end){
            return arr[start]-'0'==result?1:0;
        }
        //如果该位置已经遍历过
        if(dp[start][end][result]!=-1)
            return dp[start][end][result];
        int curCount=0;
        //遍历起点位置，每次+2
        for(int i=start;i<end;i+=2){
            char operator=arr[i+1];
            //前序列(start~i)的取值，可以为0/1
            for(int j=0;j<2;j++){
                //后序列(i+2~end)的取值，也可以为0/1
                for(int k=0;k<2;k++)
                {
                    //当前 操作符 后 ==result时，说明此时分割是可以的，然后继续分割
                    if(getBoolAns(j,k,operator)==result){
                        curCount+=count(dp,arr,start,i,j)*count(dp,arr,i+2,end,k);
                    }
                }
            }
        }
        dp[start][end][result]=curCount;
        return curCount;
    }
    //传入两个数值以及一个操作数，返回结果
    private int getBoolAns(int val1,int val2,char operator){
        switch (operator){
            case '&':
                return val1&val2;
            case '|':
                return val1|val2;
            default:
                return val1^val2;
        }
    }

    //面试题 10.03. 搜索旋转数组
    //搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
    //
    //示例1:
    //
    // 输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
    // 输出: 8（元素5在该数组中的索引）
    public int search(int[] arr, int target) {
        if (arr[0] == target)
            return 0;
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            //mid值==target,则继续往左搜寻，找到最小的索引，最小索引一定不为0
            if (arr[mid] == target) {
                while (mid > 0 && arr[mid - 1] == arr[mid]) mid--;
                return mid;
            }
            //说明mid~r是递增序列，判读target是否在中间
            if (arr[mid] < arr[r]) {
                if (arr[mid] < target && target <= arr[r]) l = mid + 1;
                else r = mid - 1;
            }
            //说明 l~mid 是递增序列，判读target是否在中间
            else if (arr[mid] > arr[r]) {
                if (arr[l] <= target && target < arr[mid]) r = mid - 1;
                else l = mid + 1;
            }
            //arr[mid]==arr[r]说明要么r~0~mid都相等，要么mid~r都相等，无论哪种r 都可以舍去
            else {
                r--;
            }
        }
        return -1;
    }

    //面试题 17.26. 稀疏相似度
    //两个(具有不同单词的)文档的交集(intersection)中元素的个数除以并集(union)中元素的个数，就是这两个文档的相似度。例如，{1, 5, 3} 和 {1, 7, 2, 3} 的相似度是 0.4，其中，交集的元素有 2 个，并集的元素有 5 个。给定一系列的长篇文档，每个文档元素各不相同，并与一个 ID 相关联。它们的相似度非常“稀疏”，也就是说任选 2 个文档，相似度都很接近 0。请设计一个算法返回每对文档的 ID 及其相似度。只需输出相似度大于 0 的组合。请忽略空文档。为简单起见，可以假定每个文档由一个含有不同整数的数组表示。
    //
    //输入为一个二维数组 docs，docs[i] 表示 id 为 i 的文档。返回一个数组，其中每个元素是一个字符串，代表每对相似度大于 0 的文档，其格式为 {id1},{id2}: {similarity}，其中 id1 为两个文档中较小的 id，similarity 为相似度，精确到小数点后 4 位。以任意顺序返回数组均可。
    //
    //示例:
    //
    //输入:
    //[
    //  [14, 15, 100, 9, 3],
    //  [32, 1, 9, 3, 5],
    //  [15, 29, 2, 6, 8, 7],
    //  [7, 10]
    //]
    //输出:
    //[
    //  "0,1: 0.2500",
    //  "0,2: 0.1000",
    //  "2,3: 0.1429"
    //]
    public List<String> computeSimilarities(int[][] docs) {
        List<String> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[][] ans = new int[docs.length][docs.length];
        for (int i = 0; i < docs.length; i++) {
            for (int j = 0; j < docs[i].length; j++) {
                List<Integer> list = map.get(docs[i][j]);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(docs[i][j], list);
                } else {
                    for (Integer k : list) {
                        ans[i][k]++;
                    }
                }
                list.add(i);
            }

            for (int k = 0; k < docs.length; k++) {
                if (ans[i][k] > 0) {
                    res.add(k + "," + i + ": " + String.format("%.4f", (double) ans[i][k] / (docs[i].length + docs[k].length - ans[i][k])));
                }
            }
        }
        return res;
    }

    //面试题 16.21. 交换和
    //给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
    //
    //返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
    //
    //示例:
    //
    //输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
    //输出: [1, 3]
    public  int[] findSwapValues(int[] array1, int[] array2) {
        // a - x + y = b - y + x
        // a - b = del
        // a - b = 2x - 2y
        /**
         *  del/2 = x - y
         * del/2 + y = x
         */
        //所以 差值一定是一个偶数
        int sum1 = 0;
        int sum2 = 0;
        for(int n : array1){
            sum1 += n;
        }
        for(int n : array2){
            sum2 += n;
        }
        int del = sum1 - sum2;
        if((del & 1) == 1){
            return new int[]{};
        }
        del = del/2;
        // del/2 - x = -y
        Set<Integer> set = new HashSet<>();
        for (int x : array1) {
            set.add(del - x);
        }
        for (int y : array2) {
            y = 0 - y;
            if (set.contains(y)){
                return new int[]{del - y,-y};
            }
        }
        return new int[]{};
    }

    //面试题 17.18. 最短超串
    //假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
    //
    //返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
    //
    //示例 1:
    //
    //输入:
    //big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
    //small = [1,5,9]
    //输出: [7,10]
    public int[] shortestSeq(int[] big, int[] small) {
        Set<Integer> list=new HashSet<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<small.length;i++){
            list.add(small[i]);
        }
        int[] res=new int[2];
        int left=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<big.length;i++){
            if(list.contains(big[i])){
                map.put(big[i],i);
            }
            while(list.size()==map.size()){
                if(!list.contains(big[left]) || left<map.get(big[left])){
                    left++;
                }else{
                    if(min>i-left){
                        min=i-left;
                        res[0]=left;
                        res[1]=i;
                    }
                    map.remove(big[left]);
                    left++;
                }
            }
        }
        if(res[0]==0 && res[1]==0){
            return new int[0];
        }
        return res;

    }

    //面试题 16.24. 数对和
    //设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
    //示例 1:
    //
    //输入: nums = [5,6,5], target = 11
    //输出: [[5,6]]
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int sum = nums[l] + nums[r];
            if(sum == target){
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[l]);
                temp.add(nums[r]);
                res.add(temp);
                ++l;
                --r;
            }else if(sum > target){
                --r;
            }else{
                ++l;
            }
        }
        return res;

    }

    //面试题 10.02. 变位词组
    //编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
    //
    //注意：本题相对原题稍作修改
    //
    //示例:
    //
    //输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
    //输出:
    //[
    //  ["ate","eat","tea"],
    //  ["nat","tan"],
    //  ["bat"]
    //]
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            if(!map.containsKey(s)){
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(s,temp);
            }else{
                map.get(s).add(strs[i]);
            }
        }

        for(String key: map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }

    //面试题 17.10. 主要元素
    //数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
    //
    //
    //
    //示例 1：
    //
    //输入：[1,2,5,9,5,9,5,5,5]
    //输出：5
    public int majorityElement(int[] nums) {

        int n = nums.length;
        if(n==1) return nums[0];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i, 0) + 1);
            if(map.get(i) > n/2) return i;
        }
        return -1;

    }

    //面试题 17.08. 马戏团人塔
    //有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
    //
    //示例：
    //输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
    //输出：6
    //解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int n = height.length;
        if(n < 2) return n;
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; ++i){
            arr[i][0] = height[i];
            arr[i][1] = weight[i];
        }
        // 对身高进行排序，对于身高相同的，对体重进行降序
        Arrays.sort(arr,(o1, o2) -> o1[0] - o2[0] == 0 ? o2[1] - o1[1] : o1[0] - o2[0]);

        // 转为利用 二分法 求 上升子序列 问题
        List<Integer> list = new ArrayList<>();
        list.add(arr[0][1]);

        for(int i = 1; i < n; ++i){
            int num = arr[i][1];

            if(num > list.get(list.size() - 1)) list.add(num);
            else{
                int index = binarySearch(list,num);
                list.set(index,num);
            }
        }
        return list.size();
    }
    int binarySearch(List<Integer> arr,int target){
        int l = 0,r = arr.size();
        while(l < r){
            int mid = (r - l) / 2 + l;
            if(arr.get(mid) < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    //面试题 17.05.  字母与数字
    //给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
    //
    //返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
    //输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
    //
    //输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
    public String[] findLongestSubarray(String[] array) {
        int len = array.length, cnt = 0, max = 0, st = -2;
        Integer hash[] = new Integer[2 * len];
        hash[len] = -1;
        for(int i = 0; i < len; i++) {
            if(array[i].charAt(0) <= '9') {
                cnt++;
            }else {
                cnt--;
            }
            if(hash[cnt + len] == null) {
                hash[cnt + len] = i;
            }else {
                if(i - hash[cnt + len] > max) {
                    st = hash[cnt + len];
                    max = i - hash[cnt + len];
                }
            }
        }
        return st == -2 ? new String[] {} : Arrays.copyOfRange(array, st + 1, st + 1 + max);
    }

    //面试题 17.17. 多次搜索
    //给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
    //输入：
    //big = "mississippi"
    //smalls = ["is","ppi","hi","sis","i","ssippi"]
    //输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
    public int[][] multiSearch(String big, String[] smalls) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<smalls.length;i++){
            List<Integer> loc=new ArrayList<>();
            //注意边界j>0&&j<=big.length()
            for(int j=smalls[i].length();j>0&&j<=big.length();j++){
                if(smalls[i].equals(big.substring(j-smalls[i].length(),j))){
                    loc.add(j-smalls[i].length());
                }
            }
            list.add(new ArrayList<>(loc));
        }
        int[][] ans=new int[smalls.length][];
        for(int k=0;k<smalls.length;k++){
            ans[k]=new int[list.get(k).size()];
            for(int p=0;p<list.get(k).size();p++){
                ans[k][p]=list.get(k).get(p);
            }
        }
        return ans;

    }

    //937. 重新排列日志文件
    //给你一个日志数组 logs。每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的 标识符 。
    //有两种不同类型的日志：
    //字母日志：除标识符之外，所有字均由小写字母组成
    //数字日志：除标识符之外，所有字均由数字组成
    //请按下述规则将日志重新排序：
    //所有 字母日志 都排在 数字日志 之前。
    //字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
    //数字日志 应该保留原来的相对顺序。
    //返回日志的最终顺序。
    //输入：logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
    //输出：["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
    //解释：
    //字母日志的内容都不同，所以顺序为 "art can", "art zero", "own kit dig" 。
    //数字日志保留原来的相对顺序 "dig1 8 1 5 1", "dig2 3 6" 。
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {//运用到了java里的泛型，第二个参数重新定义排序规则
            String[] split1 = log1.split(" ", 2); //将log1 按分隔符“ ” ，分成2份，即把标识符分开来
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));//判断除标识符外的第一个字符是数字true，字母false
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) { //如果两个日志都是字母日志
                int cmp = split1[1].compareTo(split2[1]); //先比较内容字母split1>split2则返回1，等于返0，小于返-1
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);//若内容字母相同则比较标识符
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            //如果split1是数字字符，且split2是数字字符返回0，
            // 如果split1是数字字符，且split2是字母字符返回1，即split1>split2,从小到大排序，split2提前
            // 如果split1是字母字符，返回-1，
        });
        return logs;
    }

    public String[] reorderLogFiles2(String[] logs) {
        if(logs.length<=1)return logs;
        List<String> num=new LinkedList();
        List<String> alph=new ArrayList();
        for(String tmp:logs){
            for(int i=0;i<tmp.length();i++){
                if(tmp.charAt(i)==' '){
                    if(tmp.charAt(i+1)>='0'&&tmp.charAt(i+1)<='9')
                        num.add(tmp);
                    else
                        alph.add(tmp);
                    break;
                }
            }
        }
        Collections.sort(alph,new Comparator<String>(){
            public int compare(String t1,String t2){
                int i=1,j=1;
                for(;i<t1.length();i++)
                    if(t1.charAt(i-1)==' ')
                        break;
                for(;j<t2.length();j++)
                    if(t2.charAt(j-1)==' ')
                        break;
                int t=(t1.substring(i)).compareTo(t2.substring(j));
                if(t==0) return (t1.substring(0,i-1).compareTo(t2.substring(0,j-1)));
                return t;
            }
        });
        String res[]=new String[logs.length];
        int i=0;
        for(String str:alph)
            res[i++]=str;
        for(String str:num)
            res[i++]=str;
        return res;
    }

    //1598. 文件夹操作日志搜集器
    //每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。
    //
    //下面给出对变更操作的说明：
    //
    //"../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。
    //"./" ：继续停留在当前文件夹。
    //"x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。
    //给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作。
    //
    //文件系统启动时位于主文件夹，然后执行 logs 中的操作。
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<String>();
        for(String s : logs){
            if(s.equals("../")){
                if(stack.size() != 0){
                    stack.pop();
                }
            }else{
                if(!s.equals("./")){
                    stack.push(s);
                }
            }
        }
        return stack.size();
    }

}
