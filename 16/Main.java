
/*
 * 将基本类型封装成对象的好处在于对象中定义更多方法操作改数据
 * 
 * 常用于基本数据类型 与字符串之间的转换（8种基本类型）
 * 
 * byte Byte
 * short Short
 * int Integer
 * long Long
 * float Float
 * double Double
 * char Character
 * boolean Boolean
 * 
 * ## 基本类型转化为字符串
 * 1. 基本类型数值 + ‘’
 * 2. 使用string类型中的stringOf(基本数据类型)
 *    
 * ## 字符串- 基本数据类型
 * 1.使用包装类型的静态方法 xxx parsexxx(xxx 类型的字符串)
 *      int parseInt()
 *      long parseLong()
 *      boolean parseBoolean()
 *      char 没有方法
 * 2.如果字符串被 integer 进行对象的封装
 *  可以使用另外一个非静态方法  intvalue()
 *  将一个Interger 对象转化成基本数据类型值
 * 
 * 
 * 集合的特点：
 * 1 用于存储对象的容器
 * 2.集合的长度是可变的
 * 3. 不可以存储基本的数据类型
 * 
 *  collection 常见方法
 * 
 * 1. 添加
 *  boolean add(Object obj)
 *  boolean addAll(Collection coll)
 * 
 * 2. 删除
 *  boolean remove(Object obj)
 *  boolean removeAll(Collection coll)
 *  void clear()
 * 
 * 3. 判断
 *  boolean contains(object obj)
 *  boolean containesAll(Collection coll)
 *  void isEmpty()
 * 
 * 4. 获取
 *  int  size()
 *  Iterator iterator(); 获取元素方式 迭代器
 *  该对象必须依赖于棘突容器，因为每一个容器的数据结构不同
 * 所以 该迭代器对象是在容器中进行内部实现的，对于使用容器者而言，具体的实现不重要 只要通过容器获取到该实现的迭代器对象即可
 * 
 * 一个事物直接访问另外一个事物内部类的成员
 * 
 * 5.其他
 * 
 * boolean retainAll(Collection coll) 取交集
 * Object() toArray(): 将集合转换为数组
 * 
 * collection 
 *  list--- 有序的 存入和取出的顺序一致，元素都有索引（角标） 元素可以重复
 *  set --- 元素不能重发 无序
 * 
 * 
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class Main {
    public static void show(Collection coll, Collection coll2) {
        // 1. 添加元素
        coll.add("89");
        coll.add("123");
        coll.add("90");
        coll2.add("isam2016");

        coll.addAll(coll2);

        // 2. 删除操作
        coll.remove("123"); // 会改变集合的长度
        coll.removeAll(coll2);

        System.out.println(coll);

        // 3.iterator() 方法， 调用集合中的迭代器方法，是为了获取集合中的迭代器对象
        Iterator its = coll.iterator();

        // while (its.hasNext()) {
        // System.out.println(its.next());
        // }
        for (Iterator it = coll.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }

    }

    public static void main(String[] args) {
        Collection coll = new ArrayList();
        Collection coll2 = new ArrayList();
        show(coll, coll2);

    }
}