
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
 * 3. 子
 */
class Fu {
    public String houname = "isam2016";

    Fu() {
        this.houname = "isam2017";
        System.out.println("fu");
    }

    private int num = 4;

    // public void show() { 子类不能覆盖，权限不够
    void show() {
        System.out.println(this.num);
    }

}

class Z1 extends Fu {
    Z1() {
        // super();会有一个隐藏的调用
        System.out.println("zi");
    }

    int num = 5;

    void show() {
        System.out.println(this.num);
    }

}

public class Main {
    public static void main(String[] args) {
        Z1 z = new Z1();
        z.show();
        System.out.println(z.houname);

    }
}
