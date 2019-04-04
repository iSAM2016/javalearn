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
    }
}
