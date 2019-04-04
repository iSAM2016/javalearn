/****
 * 数组
 * 
 * 1. 基本定义
 * 
 * 2. 选择排序
 */
public class Main {
    public static void main(String[] args) {
        // 1 定义一个数组的格式为：数据类型[] 数组名称;
        // 2.数组一定要初始化之后才可以使用。初始化是指：为数组在内存当中开辟内存空间，用来保存数据，并且设置默认值。没有初始化的数组无法使用。
        // 数组的初始化方式分成两种：
        // a)动态初始化，指定长度；
        // b)静态初始化，指定内容。

        // 动态初始化
        // 数组的动态初始化是直接指定数组的长度，并且为数组中的每一个元素赋予一个默认值。
        // 动态初始化的格式为：
        // 数据类型[] 数组名称 = new 数据类型[长度];
        // 或者：
        // 数据类型[] 数组名称;
        // 数组 = new 数据类型[长度];
        // 数组元素的默认值规则为：
        // 整数默认为0，浮点数默认为0.0，字符默认为’\u0000’，布尔值默认为false，字符串等引用类型默认为null。

        // 静态初始化数组
        int[] arr = new int[] { 1, 2, 3, 4 };

        // 动态初始化 数组溢出会有问题
        int[] arrs = new int[4];
        arrs[0] = 190;
        arrs[1] = 110;
        arrs[2] = 140;
        arrs[3] = 130;

        selectSort(arrs);

    }

    public static void printArray(int[] args) {
        for (int x = 0; x < args.length; x++) {
            System.out.println(args[x] + ",");
        }
        /****
         * [I@7852e922 I 数组类型 7852e922 数组类型的地址
         */
        System.out.println(args);
    }

    // 选择排序,在一个数组中交换位置
    public static void selectSort(int[] arrs) {
        for (int x = 0; x < arrs.length; x++) {
            for (int y = 0; y < arrs.length; y++) {
                if (arrs[x] > arrs[y]) {
                    int tem = arrs[x];
                    arrs[x] = arrs[y];
                    arrs[y] = tem;

                }
            }
        }
        printArray(arrs);
    }
}