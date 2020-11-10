
/*
 * 包 package
 * 对类文件进行分类管理
 * 给类挺多层命名空间
 * 写在程序文件的第一行
 * 类名的全称是包名字 类名
 * 包也是一种封装形式
 * 
 * 包与包之间的类进行访问，被访问的包中的类必须是public的，被访问的包中的类方法也必须是public 的
 * 可以直接使用 impor  导入了 packa 包中所有的类（不会导入类中的包）
 *
 */

import packa.DemoA;

// import packa.*;
// import packa.abc.*; 这个对

/***
 * packa\DemoA.class
 * 
 * packa\abc\DemoA.class 错误的
 */

class Main {
    public static void main(String[] args) {
        DemoA d = new DemoA();
        d.show();
        System.out.println("hello world");
    }
}

/*
 * 
 * ---------public protected default private
 * 
 * 同一类中 --ok--------ok-------ok----- ok
 * 
 * 同一包中 --ok--------ok-------ok
 * 
 * 子类中 ---ok--------ok
 * 
 * 不同包中---ok
 */