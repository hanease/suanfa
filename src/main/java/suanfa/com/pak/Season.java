package suanfa.com.pak;

public enum Season {
    SPRING(1,"春"),
    SUMMER(2,"夏" ),
    AUTUMN(3,"秋" ),
    WINTER(4,"冬");  //这里最后一个一定要分号，否则报错

    /*我们可以理解成
     *public static final Season SPRING = new Season(1,春);
     *public static final Season SUMMER = new Season(2,夏);
     *public static final Season AUTUMN = new Season(3,秋);
     *public static final Season WINTER = new Season(4,冬);
     *既然是对象，那下面就很好理解了
     */
    /*
     * 1.上面对象里放了两个参数，那下面就肯定要有这个类型的构造函数
     * 2.这里是private，因为不能在被new对象了
     */
    private Season(int code,String name) {
        this.name = name;
        this.code = code;
    }

    //对象的属性
    private String name;
    private int code;


    //获取对象属性的方法
    public String getName() {
        return this.name;
    }
    public String getCode() {
        return this.name;
    }

    //通过code获得对象，我们就可以获得对象的其它属性
    public static Season decode(int code) {
        Season season = null;
        for (Season type : Season.values()) {
            if (type.code==code) {
                season = type;
                break;
            }
        }
        return season;
    }

    //重新toString方法
    public String toString() {
        return this.name;
    }
}
