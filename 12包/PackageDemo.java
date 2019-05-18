/*
 * 包 package
 *
 * 对类文件进行分类管理
 * 
 * 给类挺多层命名空间
 * 
 * 写在程序文件的第一行
 * 
 * 类名的全称是包名字 类名
 * 
 * 包也是一种封装形式
 */

package mypack;

class PackageDemo {

    public static void main(String[] args) {
        packa.DemoA d = new packa.DemoA();
        d.show();
        System.out.println("hello world");
    }
}

/*
 * 
 * 
 * DemoA d = new DemoA(); ^ 符号: 类 DemoA 位置: 类 PackageDemo PackageDemo.java:20:
 * 错误: 找不到符号 DemoA d = new DemoA();
 * 
 * 原因： 类名写错 因为 DEMOA 类已经有包的所属， 所以必须明确其包名
 * 
 * 记住： DemoA 这个名字是错误的 正确名称是包名字.类名 package.DemoA
 * 
 */
/*
 * 
 * javac -d . PackageDemo.java
 * 
 * PackageDemo.java:20: 错误: 程序包packa不存在 packa.DemoA d = new packa.DemoA();
 * PackageDemo.java:20: 错误: 程序包packa不存在 packa.DemoA d = new packa.DemoA();
 * 
 * 原因是： 没有指定 classpath
 * 
 * set classpath=/Users/u/su/javacode/12包
 */

/**
 * DemoA在packa中不是公共的; 无法从外部程序包中对其进行访问 packa.DemoA d = new packa.DemoA();
 * PackageDemo.java:20: 错误: DemoA在packa中不是公共的; 无法从外部程序包中对其进行访问 packa.DemoA d
 * =new packa.DemoA();
 * 
 * 需要加 public
 */
/*
 * 错误: show()在DemoA中不是公共的; 无法从外部程序包中对其进行访问 d.show();
 */