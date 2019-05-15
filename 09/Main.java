/*
 * # 内部类 
 * 将一个雷定义在另一个类的里面，对里面那个类就称为内部类（内置类，嵌套类）
 * ## 访问规则
 * 1. 内部类可以直接访问外部类中的成员 包括私有 之所以可以直接访问外部类的成员，是因为内部类中持有一个外部类的引用 格式： 外部类名.this
 * 2.外部类要访问内部类，必须建立内部类对象
 * 
 * // TODO: 内部类 没有学
 * 
 * ##异常
 * 1.对于严重的：java 通过Error 来进行描述
 *      一般不进行处理
 * 2。对于不严重的java 通过 Exception 进行描述
 *    可以进行针对性的处理
 * 3 异常处理
 * 
 * try{
 * 检测的代码
 * }catch(变量){
 *  处理异常
 * }
 * finall{
 * }
 * 
 * 对捕获的异常 对象 使用 String getMessage()
 */

class Outer {
    private int x = 3;

    class Inner { // 内部类
        int x = 4;

        void function() {
            System.out.println("inner" + this.x);
            System.out.println("out" + Outer.this.x);
        }
    }

    void method() {
        Inner in = new Inner();
        in.function();
    }
}

class Demo {
    // 在功能上通过throws 的关键字声明了该功能会有可能出现的问题 提示使用者需要进行处理
    int div(int a, int b) throws Exception {
        return a / b;
    }
}

public class Main {
    public static void main(String[] args) {
        Outer out = new Outer();
        out.method();
        // 直接访问内部成员变量
        Outer.Inner in = new Outer().new Inner();
        in.function();

        try {
        } catch (Exception e) { // Exception e = new ArithmeticException();
            System.out.println(e.getMessage());
            System.out.println(e.toString()); // 异常名称： 异常信息
            e.printStackTrace();// 异常名称 异常信息 异常初夏位置
        }
    }
}
