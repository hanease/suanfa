package suanfa.com.biancheng;

public class Hash_serach {

    //哈希函数
    public static int hash(int value) {
        return value % 10;
    }
    //创建哈希表
    public static void creatHash(int [] arr,int [] hashArr) {
        int i,index;
        //将序列中每个元素存储到哈希表
        for (i = 0; i < 5; i++) {
            index = hash(arr[i]);
            while(hashArr[index % 10] != 0) {
                index++;
            }
            hashArr[index] = arr[i];
        }
    }
    //实现哈希查找算法
    public static int hash_serach(int [] hashArr,int value) {
        //查找目标元素对应的索引值
        int hashAdd = hash(value);
        while (hashArr[hashAdd] != value) {    // 如果索引位置不是目标元素，则发生了碰撞
            hashAdd = (hashAdd + 1) % 10;       // 根据线性探测法，从索引位置依次向后探测
            //如果探测位置为空，或者重新回到了探测开始的位置（即探测了一圈），则查找失败
            if (hashArr[hashAdd] == 0 || hashAdd == hash(value)) {
                return -1;
            }
        }
        //返回目标元素所在的数组下标
        return  hashAdd;
    }
    public static void main(String[] args) {
        int [] arr = new int[] {5, 20, 30, 50, 55};
        int[] hashArr = new int[10];
        //创建哈希表
        creatHash(arr,hashArr);
        // 查找目标元素 50 位于哈希表中的位置
        int hashAdd = hash_serach(hashArr,50);
        if(hashAdd == -1) {
            System.out.print("查找失败");
        }else {
            System.out.print("查找成功，目标元素所在哈希表中的下标为：" + hashAdd);
        }
    }
}
