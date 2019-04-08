
/****
 * 覆盖： 子类覆盖父类，必须保证子类的权限大于等于父类的权限，才可以覆盖，否则编译失败，并且一模一样，返回值一样，函数名一样
 * 
 * 如果函数之前没有明确的标志，则类型是默认类型，是 public 和 protect ，
 * 
 * 子类中调用父类的构造函数，一定会调用super 一般函数调用 supee.fn()
 * 
 * 子类的实例化过程：
 * 
 * 
 * 1.子类中所有的的构造函数都会访问父类中的构造函数（super）
 * 
 * 2. 当父类中没有空参数的构造函数视乎，子类必须手动通过super语句形式来指定要访问父类中的构造函数
 * 
 * 3. 子类中的构造函数第一行也可以手动指定this 语句来访问本类中的构造函数，子类中至少有一个构造函数会访问父类中的构造函数
 * 
 * final: 最终 作为一个修饰符
 * 
 * 1. 可以修饰类 函数 变量
 * 
 * 2. 被final 修饰的类不可以继承，为了避免继承，被子类腹泻功能
 * 
 * 3. 被final 修饰的方法不可以被改写，
 * 
 * 4. 变量只能赋值一次，可以是一个常量，固定数据，通常为大写
 * 
 * 抽象类 1. 抽象方法一定在抽象类中
 * 
 * 2. 抽象方法和抽象类都必须被abstract 关键字修饰
 * 
 * 3. 抽象方法不可以 用new
 * 
 * 4. 抽象类中的方法要被使用，必须有子类复写所有的抽象方法后，建立子类对象调用，如果子类覆盖了部分抽象方法，那么该子类 还是一个抽象类
 * 
 * 
 * 抽象类和一般类不同：
 * 
 * 正常描述事务，只不过是该事务出现了一些看不懂的东西。
 * 
 * 抽象只能描述方法，可以不定义抽象方法
 * 
 */

abstract class Student {
    abstract void Study();

    void sleep() {
        System.out.println("sleep");
    }
}

class Fu extends Student {
    public String houname = "isam2016";

    Fu() {
        System.out.println("fu");
        this.houname = "isam2017";
    }

    Fu(int x) {
        System.out.println("fu" + x);
    }

    void Study() {
        System.out.println("student");
    }

    private int num = 4;

    // public void show() { 子类不能覆盖，权限不够
    // final void show() {
    void show() {

    }
}

class Z1 extends Fu {
    Z1() {
        // super(4);会有一个隐藏的调用
        System.out.println("z");
    }

    Z1(int x) {
        this();
        // super(4);会有一个隐藏的调用
        System.out.println("zi" + x);

    }

    int num = 5;

    void show() {
        System.out.println(this.num);
    }
}

final class Final {
    void show() {
        System.out.println("final");
    }
}

public class Main {
    public static void main(String[] args) {
        Z1 z = new Z1(0);
        z.show();
        System.out.println(z.houname);

    }
}
