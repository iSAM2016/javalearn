/*
 * # 面向对象
 * 
 * ## 面向对象概念
 *  1. 面向对象是相对面向过程而言 
 *  2. 面向对象和面向过程都是一种思想 
 *  3. 面向过过程是功能行为
 *  4. 面型对象将功能封装进对象，强调了具备功能的对象
 *  5. 面向对象是基于面向过程的
 *  三个基本特征  封装 继承 多态
 * 
 * ## 类和对象对象关系
 *  类： 对现实生活事物的描述
 *  对象： 个体
 * 
 * ### 变量和类之间的关系 
 *  成员变量和局部变量，
 *      作用范围
 *          成员变量作用于整个类中
 *          局部变量
 *      内存中的位置
 *          成员变量在内存中，以为对象的存在，才在内存中
 *          局部变量在栈内存
 *          
 * ## 封装
 * 是指隐藏对象的属性和细节，仅对外提供公共访问方式
 * （这些修饰符是私有的表现形式）
 *  private 子类： 不读 不写
 *  protected 子类： 读 不写
 *  public 子类： 读 写
 * 
 * ## 构造函数
 * 
 * 构造函数调用this
 * 
 * 类似于construction 用于给对象初始化
 * 1.函数于类名相同 
 * 2.不用定义返回值 
 * 3.不可以写 return 
 * 
 * 当一个类中没有定义构造函数时候，那么系统会给该类加入一个空参数的构造函数，当定义了就没有了
 * 
 * 注意： 多个构造函数是以重载的形式存在的
 *      写法不同
 *      运行不同
 *          构造函数是在对象一建立就运行，给对象初始化
 *          而一般方法是对象调用菜执行，给是对象添加具备的功能
 * 
 * ### 构造 代码块
 *   作用：   给对象进行初始化
 *          对象一建立就运行，而且优先于构造函数执行
 *   和构造函数的区别：
 *          构造代码块是给所有对象进行统一初始化（专有特征）不同对象共享的初始化内容
 *          而改造函数是给对应的对象初始化（共性特征）
 *          
 *     
 * 
 * ## this 关键字
 * 
 */

class Car {
    // 成员变量存在内存中，因为对象的存在才在内存中存在
    protected String color = "red";
    private int age = 10;
    public int num = 4;

    void run() {
        System.out.println("age" + this.age);
    }
}

/*************************************************************** 构造函数 */

class Person {
    private String name;
    private int age;
    {
        // 共性
        cry();
    }

    Person(String name) {
        name = n;
        System.out.print("A name=" + name + ",age " + age);
        // cry();
    }

    Person(String name, Number age) {
        this(name);
        System.out.print("A name=" + name + ",age " + age);
        // cry();
    }

    public void cry() {
        System.out.println("cry-----");
    }

}

public class Main {
    public static void main(String[] args) {
        // 其实就是在内存中产生一个实体
        // c 就是一个类类型变量， 类类型指向变量
        Car c = new Car();

        // System.out.println("age" + c.age); error
        // c.color = 'blue';
        System.out.println("color" + c.color);
        c.num = 20;
        System.out.println("color" + c.num);
        // c.run();

        /************************ 构造函数 */
        Person p2 = new Person("lili", 12);
        // System.out.println(p2.get);;
    }
}
