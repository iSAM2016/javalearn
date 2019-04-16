
/*
 * # 继承
 * ## 继承的概述
 *  提高了代码复用性
 *  让类和类之间产生关系，有了关系才有多态的特点。
 *  注意： 不要为了获取其他类的功能，简化代码而继承，必须是类和类之间有关系才继承，
 *        java 值支持单继承
 * 
 * ## 子父类中变量的特点（super 关键字）
 *  子类出现后，类成员的特点：
 *  1.变量
 *  2.函数
 *  3.构造函数
 *  A:变量：
 *  如果子类中出现非私有的同名变量成员变量时候
 *  子类访问 使用this
 *  子类要访问父类中的同名变量用super/
 * 
 * ## 函数覆盖
 * 当子类出现和父类一模一样的函数时， 当子类对象调动改函数，会运行子类函数的内容，如同父类函数被覆盖一样
 * 
 * B:这种情况是函数重写（覆盖）
 *  
 * 1. 子类覆盖父类，必须保证子类的权限大于等于父类的权限，才可以覆盖，否则编译失败，并且一模一样，返回值一样，函数名一样
 * 2. 静态只能覆盖静态
 * 如果函数之前没有明确的标志，则类型是默认类型，是 public 和 protect之间
 * 子类中调用父类的构造函数，一定会调用super 一般函数调用 supee.fn()
 * 
 * 重载： 只看同名函数的参数列表
 * 重写： 覆盖
 * 
 * ## 子类的实例化过程
 * C:子类的构造函数
 * 
 * 在对子类对象进行初始化时，父类的构造函数也会运行
 * 那是因为子类的构造函数默认第一行有一条隐士的语句super()
 * super 会访问父类的构造函数，位置为第一行
 * 
 * 为啥摸子类一定要访问父类中的构造函数
 *
 * ### 子类的实例化过程：
 * 1.子类中所有的的构造函数都会访问父类中的构造函数（super）
 * 2. 当父类中没有空参数的构造函数视乎，子类必须手动通过super语句形式来指定要访问父类中的构造函数
 * 3. 子类中的构造函数第一行也可以手动指定this 语句来访问本类中的构造函数，子类中至少有一个构造函数会访问父类中的构造函数
 * 
 * ## final: 最终 作为一个修饰符
 * 1. 可以修饰 类 函数 变量
 * 2. 被final 修饰的类不可以继承，为了避免继承，被子类腹泻功能
 * 3. 被final 修饰的方法不可以被改写，
 * 4. 被final 修饰变量只能赋值一次，可以是一个常量，固定数据，通常为大写
 * 
 * ## 抽象类 
 * 1. 抽象方法一定在抽象类中
 * 2. 抽象方法和抽象类都必须被abstract 关键字修饰
 * 3. 抽象方法不可以 用new
 * 4. 抽象类中的方法要被使用，必须有子类复写所有的抽象方法后，建立子类对象调用，如果子类覆盖了部分抽象方法，那么该子类 还是一个抽象类
 * 
 * ### 抽象类和一般类不同：
 *  正常描述事务，只不过是该事务出现了一些看不懂的东西。
 *  抽象只能描述方法，可以不定义抽象方法
 * 
 * 
 * ## 接口（支持多继承）（但是java 值支持单继承）
 * 接口中的成员修饰符是固定的
 *      成员变量：  public static final
 *      成员函数： public abstract
 * 
 *  接口这接口之间是继承关系
 *      继承是所属关系，（集合的一种）
 *      接口是体系以外的功能扩展，（集合以外的扩展）
 * 
 *  1.接口是对外暴露规则
 *  2.接口是程序的功能扩展
 *  3.接口可以用来多实现
 *  4.类于接口之间是实现关系，而且类可以继承一个类的同时实现多个接口
 *  5.接口和接口之间可以有继承关系
 * 
 * 
 * //TODO: 模板方法  
 */

/******************************************************* 抽象类 */
abstract class Student {
    abstract void study();

    void sleep() {
        System.out.println("sleep");
    }
}

class Fu extends Student {
    public String houname = "isam2016";
    final int x = 3;

    Fu() {
        System.out.println("fu");
        this.houname = "isam2017";
    }

    Fu(int x) {
        System.out.println("fu" + x);
    }

    void study() {
        System.out.println("student");
    }

    int num = 4;

    // public void show() { 函数覆盖 子类不能覆盖，权限不够
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
        // 构造函数间调用
        this();
        // super(4);会有一个隐藏的调用
        System.out.println("zi" + x);

    }

    int num = 5;

    void show() {
        // 子父类中变量的特点
        System.out.println(this.num);
        System.out.println(super.num);
    }
}

final class Final {
    void show() {
        System.out.println("final");
    }
}

/******************************************************* 接口 */
// 接口
interface Smoking {
    // 接口会自动补全关键, 比如final 不写会默认添加进去
    public static final int NUM = 3;

    public void smoking();
}

// 接口是体系以外的功能扩展
class Test extends Student implements Smoking {
    public void study() {
    };

    public void smoking() {
    }
}

public class Main {
    public static void main(String[] args) {

        Z1 z = new Z1(0);
        z.show();
        System.out.println(z.houname);
        Test test = new Test();
        System.out.println(test.NUM);
        System.out.println(Test.NUM);
        System.out.println(Inter.NUM);
        // test.NUM = 7;error
    }
}
