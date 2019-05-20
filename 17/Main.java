import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;

import persion.Persion;

/*
 *  内部是链表，
 */

class Main {
    public static void main(String[] args) {
        LinkedList link = new LinkedList();

        link.addFirst("abc1");
        link.addFirst("abc2");
        link.addFirst("abc3");

        Iterator it = link.iterator();
        // System.out.println(link.getFirst());
        // System.out.println(link.removeFirst()); // 会改变长度

        // while (it.hasNext()) {
        // System.out.println("next is " + it.next());
        // }

        /************** arraylist */
        // arrayList 存储自定义对象
        ArrayList a1 = new ArrayList();
        // add 的参数类型为object，什么类型的对象都能接收, 提升了为object
        // 数据只能存
        a1.add(new Persion("list1", 21));
        a1.add(new Persion("list2", 22));
        a1.add(new Persion("list3", 23));
        a1.add(new Persion("list4", 24));

        Iterator t = a1.iterator();
        while (t.hasNext()) {
            Persion p = (Persion) it.next();
            System.out.println(p.getName());
        }
    }
}