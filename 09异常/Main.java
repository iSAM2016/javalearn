/*
 * # 内部类 
 * ## 访问规则
 * 1. 内部类可以直接访问外部类中的成员 包括私有 之所以可以直接访问外部类的成员，是因为内部类中持有一个外部类的引用 格式： 外部类名.this
 * 2.外部类要访问内部类，必须建立内部类对象
 * 
 * // TODO: 内部类 没有学  finally
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
 * 
 * 
 * throw 和 throws 的区别
 * 
 * throws 使用在函数上
 * throw 使用在函数内
 * 
 * throws 后面跟的是异常类 可以跟对个 用逗号隔开 
 * throw 跟的是异常对象
 * 
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
    // 这种方法不好
    int div(int a, int b) throws Exception {
        return a / b;
    }
}

/************************************************** 异常处理 */

// class FuException extends Exception {
// private int value;

// FuException() {
// super();
// }

// FuException(String mag, int value) {
// super(msg);
// this.value = value;
// }

// public int getValue() {
// return value;
// }

// }

/************************************************** 异常处理 */

class LangPingExpection extends Exception {
    LangPingExpection(String message) {
        super(message);
    }
}

class MaoYanExpection extends Exception {
    MaoYanExpection(String message) {
        super(message);
    }
}

class Computer {
    private int state = 2;

    public void run() throws LangPingExpection, MaoYanExpection {
        if (state == 2) {
            throw new LangPingExpection("蓝屏");
        }
        if (state == 3) {
            throw new MaoYanExpection("冒烟了");
        }
        System.out.println("电脑运行");

    }

    public void reset() {
        state = 1;
        System.out.println("电脑重启");
    }
}

class Teacher {
    private String name;
    private Computer cmpt;

    Teacher(String name) {
        this.name = name;
        cmpt = new Computer();
    }

    public void prelect() {
        try {
            cmpt.run();
        } catch (LangPingExpection e) {
            cmpt.reset();
        } catch (MaoYanExpection e) {

        }
        System.out.print("讲课");
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

        // 测试
        Teacher t = new Teacher("毕老师");

        try {
            t.prelect();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}