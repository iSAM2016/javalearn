/****
 * 在多态中成员函数的特点：
 * 
 * 在编译时期； 参阅引用类型变量所属类中是否有调用的方法，如果有，编译通过，如果没有编译失败
 * 
 * 在运行阶段: 参阅对象所属类中是否调有调用方法
 * 
 * 简单总结： 成员函数在多态调用时，编译看左边，运行看右边
 */

class Fu {
    void method1() {
        System.out.println("fu method_1");
    }

    void method2() {
        System.out.println("fu method_2");
    }
}

class Z1 extends Fu {
    void method1() {
        System.out.println("zi method_1");
    }

    void method3() {
        System.out.println("zi method_3");
    }
}

// 接口降底了耦合性，
// 电脑主板, 声卡和主板的的关系
// 声卡开启和关闭 主板加载
// 声卡和主板相互独立，他们之间是怎么关联然后生产的，是有个规范，接口（帧槽）
// 声卡按接口生产
// 主板按接口对接
// 多态的主板示例
/********** */

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

/***** 数据库 */

public class Main {
    public static void main(String[] args) {
        Fu f = new Z1();
        f.method1();
        f.method2();
        // f.method3(); error

        MainBord mb = new MainBord();
        mb.run();
        mb.usePCI(new NetCard());
        mb.usePCI(new SoundCard());
    }
}