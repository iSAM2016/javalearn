/*
 * 多态： 可以理解为 事物存在的多种提现形态
 *      多态的体现是体现在类上
 *
 * ## 多态的体现 
 * 父类的引用指向了自己的子类对象，父类的引用也可以接收自己的子类对象
 * 
 * ##  多态的前提 
 * 必须是类和类的关系，要么继承要么实现，通常还有个前提，存在覆盖
 * 
 * ## 多态的应用
 * 
 * ## 多态的好处 
 * 提高了程序的扩展性，
 * 
 * ## 弊端 
 * 但是只能使用父类的引用访问父类中的成员
 * 
 * 
 * ##多态的好处是
 * 多态简化了对象调用
 * 
 * 
 * ## 在多态中成员函数的特点：（非静态）
 * 在编译时期； 参阅引用类型变量所属类中是否有调用的方法，如果有，编译通过，如果没有编译失败
 * 在运行阶段: 参阅对象所属类中是否调有调用方法
 * 简单总结： 成员函数在多态调用时，编译看左边，运行看右边
 * 
 * 在多态中，成员变量的特点
 * 无论编译和运行，都参考左边（引用类型变量所属的类）
 * // TODO:静态
 */

class Fu {
    int num = 5;

    void method1() {
        System.out.println("fu method_1");
    }

    void method2() {
        System.out.println("fu method_2");
    }
}

class Z1 extends Fu {
    int num = 6;

    void method1() {
        System.out.println("zi method_1");
    }

    void method3() {
        System.out.println("zi method_3");
    }
}

abstract class Animal {
    abstract void eat();
}

class Cat extends Animal {
    public void eat() {
        System.out.println("吃鱼");
    };

    public void catchMouse() {
        System.out.println("抓老鼠");
    };
}

class Dog extends Animal {
    public void eat() {
        System.out.println("骨头");
    };

    public void protectHpuse() {
        System.out.println("看家");
    };

}

/******************************************************************* 多态示例 */
abstract class Student {
    abstract void Study();

    void sleep() {
        System.out.println("sleep");
    }
}

class BaseStudent extends Student {
    public void Study() {
        System.out.println("base");
    }

    public void Sleep() {
        System.out.println("睡觉");
    }
}

class AdvStudent extends Student {
    public void Study() {
        System.out.println("adv study");
    }
}

class Do {
    public static void dosome(Student bs) {
        bs.Study();
        bs.sleep();
    }
}

/******************************************************************* 电脑主板加载声卡 */
// 接口降底了耦合性，
// 电脑主板, 声卡和主板的的关系
// 声卡开启和关闭 主板加载
// 声卡和主板相互独立，他们之间是怎么关联然后生产的，是有个规范，接口（帧槽）
// 声卡按接口生产
// 主板按接口对接
// 多态的主板示例

interface PIC {
    public void open();

    public void close();
}

class MainBord {
    public void run() {
        System.out.println("main start");
    }

    public void usePCI(PIC p) {// 多态
        p.open();
        p.close();
    }
}

class NetCard implements PIC {
    public void open() {
        System.out.println("net catd open");
    }

    public void close() {

        System.out.println("net catd close");
    }
}

class SoundCard implements PIC {
    public void open() {
        System.out.println("sound catd open");
    }

    public void close() {

        System.out.println("sound catd close");
    }
}

/***********************************************************************
 * 数据库链接的的实现参考readme
 */

public class Main {
    public static void main(String[] args) {
        Fu f = new Z1();
        f.method1();
        f.method2();
        // f.method3(); // error 在多态中成员函数的特点

        System.out.println(f.num);

        Z1 z = new Z1();

        System.out.println(z.num);

        Cat c = new Cat();
        Dog d = new Dog();
        // function(c);
        // function(d);
        /**
         * 不要出现这样的情况，将父类对象转成子类类型
         * 
         * 我们能转换的是父类应用指向了自己的子类对象时，该应用可以提升，也可以被强制转换
         * 
         * 多态始终变化的是自己
         * 
         * // Animal a = new Aaimal() cat c = (cat) A
         */
        Animal a = new Cat(); // 类型提升 向上转型
        a.eat();
        // 如果想调用猫的独特方法 如何操作
        // 强制将父类型的引用，转成子类型，向下转型
        Cat cat = (Cat) a;
        cat.catchMouse();

        /****************** */
        Do ds = new Do();
        ds.dosome(new BaseStudent());
        ds.dosome(new AdvStudent());

        /****************** */
        MainBord mb = new MainBord();
        mb.run();
        mb.usePCI(new NetCard());
        mb.usePCI(new SoundCard());
    }

    public static void function(Animal animal) {
        animal.eat();
    }

    // public static void function(Cat c) {
    // c.eat();
    // }

    // public static void function(Dog c) {
    // c.eat();
    // }
}
