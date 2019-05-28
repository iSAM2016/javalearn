import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

import persion.Persion;
import persion.ComparatorByName;

/*
 * #List 
 *  --- vector 内部数组数据结构  是同步的 增删 查询都很慢
 *  --- LinkedList 内部是链表数据结构  是不哦同步的  增删元素的速度会很快
 *  --- ArrayList 内部是数组数据结构  是不同步的  代替了 vector  查询的速度快 只能存储相同的数据结构
 * 
 * 当基本类型变为Object 会进行封箱操作
 * show(Object num)
 * Object num = new Integer(6)
 * 
 * # set
 * Set: 元素不可以重复，是无序 set 接口中的方式和collection是一致的. 
 * ------ hashSet: 内部数据结构是哈希表,是不同步的
 * -------------- LinkedHashSet: 有序的
 * ------ treeSet: 
 * 
 * ## hashSet
 * 哈希表确定元素是否相同, 
 * 1. 判断的是两个元素的哈希值是否相同，如果相同 在判断两个对象的内容是否相同
 * 2. 判断哈希值相同，其实判断的是对象hashcode 的方法，判断内容相同 用的是equals 方法
 * 注意：
 *  a.如果哈希值不同， 是不需要判断equals 的。
 *  b.如果元素要存储到hashset集合中，必须覆盖hashcode 方法和equals方法
 *  c.如何和 arrayList 比较不同. arrayList 比较内容相同 直接测试equals
 * 
 * ## treeSet
 *  可以对set 集合中的元素进行排序，是不同步的
 *   
 * 判断元素唯一的方式吗， 就是根据比较方法的返回结果是否是0。是0 就是相同的元素，不存。
 * 
 * ---方法1 让元素具有比较功能， 实现 comparable 接口， 覆盖compareTO 方法
 *    
 *    如果不要按照对象中具备的自然顺序进行排序，怎么版
 *      可以使用treeset 集合第二种排序
 * ----方法二 让集合自身具备计较功能，定义一个实现comparator  接口 覆盖 compare 方法，将该类对象作为参数传递给 treeset 集合的构造函数
 * 
 *     
 *
 */

class Main {
    // 去除重复元素
    public static ArrayList getSingElemnt(ArrayList al) {
        // 1. 定义一个临时容器
        ArrayList temp = new ArrayList();
        // 2 迭代集合
        Iterator it = al.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            // 判断迭代到的元素是否存在临时容器存在
            if (!temp.contains(obj)) {
                temp.add(obj);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        /***************************************** arraylist 存储自定义对象 *********/
        ArrayList a1 = new ArrayList();
        // ArrayList 存储自定义对象
        // add 的参数类型为object，什么类型的对象都能接收, 提升了为object
        // 数组只能存相同的数据类型
        a1.add(new Persion("list1", 21));
        a1.add(new Persion("list2", 22));
        a1.add(new Persion("list3", 23));
        a1.add(new Persion("list4", 24));

        Iterator t = a1.iterator();
        while (t.hasNext()) {
            // 重要
            Persion p = (Persion) t.next();
            // System.out.println(p.getName());
        }

        /************************************************ HashSet ************/
        HashSet hash = new HashSet();
        // ArrayList 存储自定义对象
        // 传给hashset 都是object 每个hash 不同无法进行 比较，需要重写比较方法
        /**
         * hashset 集合数据几个欧是哈希表 所以存储元素的时候 使用的元素的hashcode 方法来确定的，如果位置相同，在通过元素的equals
         * 来确定是否相同
         */
        hash.add(new Persion("lisi4", 24));
        hash.add(new Persion("lisi7", 27));
        hash.add(new Persion("lisi1", 21));
        hash.add(new Persion("lisi9", 29));
        hash.add(new Persion("lisi7", 27));

        Iterator it = hash.iterator();

        while (it.hasNext()) {
            Persion p = (Persion) it.next();
            // System.out.println(p.name);
        }
        // System.out.println(getSingElemnt(a1));
        /**************************************************************** LinkedList */
        LinkedList link = new LinkedList();

        link.addFirst("abc1");
        link.addFirst("abc2");
        link.addFirst("abc3");

        Iterator t2 = link.iterator();
        // System.out.println(link.getFirst());
        // System.out.println(link.removeFirst()); // 会改变长度

        while (it.hasNext()) {
            // System.out.println("next is " + it.next());
        }
        /**************************************************************** treeSet */

        TreeSet treeset = new TreeSet(new ComparatorByName());// 一个计较类
        // 是比较的fcompareTO 返回 -1 0 1

        treeset.add(new Persion("lisi4", 24));
        treeset.add(new Persion("lisi7", 27));
        treeset.add(new Persion("lisi1", 21));
        treeset.add(new Persion("lisi9", 29));
        treeset.add(new Persion("lisi7", 27));

        Iterator t3 = hash.iterator();

        while (t3.hasNext()) {
            Persion p3 = (Persion) t3.next();
            System.out.println(p3.name);
        }
    }
}