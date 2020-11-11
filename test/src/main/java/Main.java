/*
 * # 面向对象
 *
 * ## static 关键字
 * 用法：用于修饰成员 成员变量成员函数 =》修饰之前（图1） 修饰之后 图2  特有内容在堆中，
 * 当成员被静态修饰后，就多了一个调用方法，除了可以被对象调用外，还可以被类名调用 。 类名.静态成员
 *
 * ### 被修饰的成员以后具备以下特点：
 *  1.随着类的加载而加载，消失而消失
 *      说明周期很长
 *  2.优先于对象存在
 *      静态先存在，对象后存在
 *  3. 被所有对象所共享
 *  4. 可以直接被类名调用
 *
 * ### 实例变量和类变量的区别：
 * 1. 存放位置、
 *   类变量随着类的加载而存在于方法区中
 *   实例变量随着对象的建立在堆内存中
 * 2.声明周期
 *  类变量的声明周期最长
 *  实例变量的生命周期随着对象的消失而消失
 *
 * ### 静态使用注意
 * 1. 静态方法只能访问静态成员
 *      非静态访方法既可以访问静态也可以访问非静态
 * 2. 静态方法中不可以写this super 关键字
 *      因为静态优先于对象存在，所以静态方法中不可以出现this
 * 3. 主函数是静态的
 *
 * ### 静态有利有弊端
 * 好处： 对象共享数据进项单独的空间存储，节约空间，没必要每个对象都存储一份
 * 弊端： 声明周期过长
 *
 * ### 主函数
 * public static void main(String[] args)
 * 主函数： 是一个特殊的函数，作为程序的入口，可以被jvm调用
 * 主函数的定义：
 *  public: 代表改函数访问权限已经是最大
 *  static: 代表该函数随着类的加载已经就存在了
 *  void:  主函数没有具体的返回值
 *  main: 被jvm 识别
 *
 * jvm 在调用主函数的时候传入的是 new String(0)
 *
 * ### 什么时候使用静态
 *
 * 什么是静态？
 * 要从两方面下手
 * 因为静态修饰的内容有成员变量和函数
 *
 * 什么时候定义静态变量（类变量）呢
 * 当对象中出现共享数据时候，该数据被静态所修饰
 * 当对象中特有数据要定义成静态存在于内存中
 *
 * 什么时候定义静态函数呢
 * 当功能内部没有访问到非静态数据（对象的特有数据）
 * 那么改功能可以定义成静态
 *
 * 虽然可以通过建立Array 的对象使用这些工具方法 对数组进行操作，，发现了问题
 *
 * 1. 对象是用于封装数据的，可是ArratTool 对象并未封装特有的数据
 * 2. 操作数据的每一个方法都没用到ArrayTool 对象中的特有数据
 *
 *
 * 可以让Array static 静态化直接调用类名即可
 *
 * 将方法都静态后，可以方便使用但是该类韩式可以被其他对象建立对象的，为了更加严谨，强制让该类不能见了对象 将构造函数私有化
 *
 *
 * ###  静态代码块
 * 格式：
 * static {
 *  静态代码块中执行语句
 * }
 *
 *特点：  随着类的加载而而执行，只执行一次，并优先于主函数，用于给类进行初始化。 无法访问非静态常量
 *
 *
 * ### 静态代码初始化过程
 *
 * Person p = new Persion("zhang",20)
 *
 * 该句话都做了什么
 * 1.  因为new 用到了Persion.class 所以会找到Persion.class 文件并加载到内存中
 * 2. 执行该类中的static 代码块 如果有的话，给persion.class 类进行初始化
 * 3. 在堆内存中开辟空间，分配内存地址
 * 4. 在堆内存中建立对象的特有属性，并进行默认初始化
 * 5. 对属性进行显示初始化
 * 6. 对对象进行构造代码初始化
 * 7. 对对象进行对应的构造函数初始化
 * 8. 将内存地址付给栈内存中的p 变量。
 *
 */

/******** 什么时候使用静态 */
class Persion {
    String name; // 成员变量 实例变量
    static String country = "cn";// 静态的成员变量 类变量

    public void show() {
        System.out.println(name + "::" + country);
    }

    public static void close() {
        // System.out.println(name + "::" + country);
    }

    public static void country() {// 静态方法只能访问静态成员
        System.out.println(country);
    }
}

/***************************************************** 静态代码块 */

class StaticCode {
    int num = 9;

    static {
        // 无法访问 内部变量
        System.out.println("a");
    }
    {
        System.out.println("c" + this.num);
    }

    StaticCode() {
        System.out.println("b");
    }

    StaticCode(int x) {
        System.out.println("d");
    }

    public static void show() {
        System.out.println("show run");
    }
}

class StaticCodeDemo {
    static {
        System.out.println("e");
    }

    public static void show() {
        new StaticCode();// 注意只打印一次a 因为只加载一次类
        new StaticCode();
        System.out.println("over");
        StaticCode.show();
        StaticCode s = null;
        s = new StaticCode(3);
        StaticCode.show();
    }

    static {
        System.out.println("f");
    }
}

/*********** 单例模式 */

class Single {
    private int num;

    public void setNum(int num) {
        this.num = num;
    }

    private Single() {
    }

    private static Single s = new Single();

    public static Single getInstance() {
        return s;
    }
}

/******** 什么时候使用静态 */

public class Main {
    public static void main(String[] args) {

        Persion p = new Persion();
        p.name = "zhangssh";
        p.show(); //
        System.out.println(Persion.country);
        // Persion.show(); // error 非静态不能访问静态 此时没有初始化
        Persion.close(); // 法从静态上下文中引用非静态 变量 name
        int[] arr = { 3, 1 };
        /********* 什么时候使用静态 */
        // 此时没有必要进行new 对象占用内存，Array 里面的东西都没有用到变量
        // ArrayTool tool = new ArrayTool();
        // int max = tool.getMax(arr);
        // int max = ArrayTool.getMax(arr);
        // System.out.println(max);
        /** 静态代码块 */
        StaticCodeDemo scd = new StaticCodeDemo();

        String s = "Hello";
String t = s;
s = s + "t";
System.out.println(t);
System.out.println(s);
        // scd.show();
    }
}
