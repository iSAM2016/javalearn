
/*****
 * （函数） 和 面向对象
 */
public class Main {
    /****
     * 方法结构 修饰符 返回值类型 方法名称（参数类型 参数名称）{ 方法体 return 返回值 }
     * 
     * @param args
     */
    public static void main(String[] args) {

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
 * 参数列表的不同包括：
 * 1.参数的个数不同；
 * 2.参数的类型不同；
 * 3.参数的多类型顺序不同。
 * 
 * 
 * 重载与下列因素无关：
 * 1.方法的返回值；
 * 2.参数的名称。
 */
    public static double sum(int a,double b) {
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
    
    public static int sum (int a, int b) {
        System.out.println("有2个int参数的方法执行！");
		return a + b;
    }
    
    public static int sum (int a, int b, int c) {
        System.out.println("有3个int参数的方法执行！");
		return a + b + c;
    }
    public static int sum(int a, int b, int c, int d) {
		System.out.println("有4个int参数的方法执行！");
		return a + b + c + d;
    }
    
    /*****
     * 参数传递
     * 1. 对于基本类型（以及string）来说，形参的操作不会影响实际参数
     * 2.对于引用类型（除了String）来说，形式参数的操作【会】影响实际参数。
     */
    
    
}

       

    

    

    