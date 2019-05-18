
/*
 * lsit 特有的方法， 可以操作角标 add 
 * 
 * 1. 添加
 *      void add(index, elemet)
 *      void add(index, collection)
 * 2. 删除
 *      Object remvoe(index)
 * 3. 修改
 *      Object set(index, element)
 * 4. 获取
 *      Object  get(index)
 *      int     indexOf(object)
 *      int     lastindexOf(object)
 *      List    subList(from, to)
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class Mylist {
    public static void show(List coll) {
        System.out.println("9");
    }

    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("abc1");
        list.add("abc2");
        list.add("abc3");

        // 1.插入
        list.add(0, "89");

        // 2. 删除元素
        // System.out.println("remove" + list.remove(2));
        ListIterator it = list.listIterator(); // 获取列表迭代器对象
        // 她可以在迭代过程中完成对元素的增删改查
        // 只有list有该功能
        while (it.hasNext()) {
            Object obj = it.next();
            if (obj.equals("abc2")) {
                it.set("abc4"); // 在迭代器过程中 不要使用集合操作元素，容易出现异常
            } else {
                System.out.println(obj);
            }
        }
        System.out.println("hasNext" + it.hasNext());
        // Iterator it = list.iterator();
        // while (it.hasNext()) {
        // Object obj = it.next();
        // if (obj.equals("abc2")) {
        // list.add("abc3"); // 在迭代器过程中 不要使用集合操作元素，容易出现异常
        // } else {
        // System.out.println(obj);
        // }
        // }
        System.out.println(list);
    }
}