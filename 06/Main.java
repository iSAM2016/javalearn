/****
 * 面向对象 封装 继承 多态
 * 
 * 封装： 是指隐藏对象的属性和细节，仅对外提供公共访问方式
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

class Persion {
    {
        // 构造代码块
        System.out.println("cry");
    }

    // 构造函数
    // 当一个函数中没有构造函数的时候，系统会默认自动添加空参数的构造函数
    Persion() {
        System.out.println("A persion");
    }

    Persion(String name) {
        System.out.println("B" + name + "persion");
    }

    Persion(String name, int age) {
        System.out.println("C" + name + "age" + age);
    }

}

public class Main {
    public static void main(String[] args) {
        // 其实就是在内存中产生一个实体
        Car c = new Car();// c 就是一个类类型变量， 类类型指向变量

        /***
         * private 子类： 不读 不写
         * 
         * protected 子类： 读 不写
         * 
         * public 子类： 读 写
         */

        // System.out.println("age" + c.age); error
        // c.color = 'blue';
        System.out.println("color" + c.color);
        c.num = 20;
        System.out.println("color" + c.num);
        // c.run();

        Persion p1 = new Persion("name", 20);

    }
}
