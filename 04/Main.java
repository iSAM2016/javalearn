/*
 * day1-day4
 * 
 * 1. 基本定义 
 * 2. 选择排序 
 * 3.重载
 */
public class Main {
    public static void main(String[] args) {
        // 只能存储统一类型
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

        /***************************************************************** 函数重载 */
        // 单独调用
        // printHelloWorld();
        System.out.println("===============");

        // 单独调用
        // printHelloWorldCount(15);
        System.out.println("===============");

        // 错误写法！void的方法不能使用打印调用
        // System.out.println(printHelloWorld());

        System.out.println(sum(10, 20)); // 30
        System.out.println(sum(10, 20, 30)); // 60
        System.out.println(sum(10, 20, 30, 40)); // 100

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

    /****
     * 方法结构 修饰符 返回值类型 方法名称（参数类型 参数名称）{ 方法体 return 返回值 }
     * 
     * @param args
     */
    public static void printHelloWorld() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello, World! " + (i + 1));
        }
    }

    public static void printHelloWorldCount(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Hello, World! " + (i + 1));
        }
    }

    /***
     * 方法重载：方法名称相同，但是参数列表不同。
     * 
     * 参数列表的不同包括： 1.参数的个数不同； 2.参数的类型不同； 3.参数的多类型顺序不同。
     * 
     * 
     * 重载与下列因素无关： 1.方法的返回值； 2.参数的名称。
     */
    public static double sum(int a, double b) {
        System.out.println("先int后double的方法执行！");
        return a + b; // 注意！不同数据类型的数值相加，谁的范围大，结果就是谁
    }

    public static double sum(double a, int b) {
        System.out.println("先double后int的方法执行！");
        return a + b; // 注意！不同数据类型的数值相加，谁的范围大，结果就是谁
    }

    public static double sum(double a, double b) {
        System.out.println("有2个double参数的方法执行！");
        return a + b;
    }

    public static int sum(int a, int b) {
        System.out.println("有2个int参数的方法执行！");
        return a + b;
    }

    public static int sum(int a, int b, int c) {
        System.out.println("有3个int参数的方法执行！");
        return a + b + c;
    }

    public static int sum(int a, int b, int c, int d) {
        System.out.println("有4个int参数的方法执行！");
        return a + b + c + d;
    }

    /*****
     * 参数传递 1. 对于基本类型（以及string）来说，形参的操作不会影响实际参数
     * 2.对于引用类型（除了String）来说，形式参数的操作【会】影响实际参数。
     */

}