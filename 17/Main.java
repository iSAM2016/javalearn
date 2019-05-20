import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/*
 * Set: 元素不可以重复，是无序 set 接口中的方式和collection是一致的. 
 * hashSet: 内部数据结构是哈希表,是不同步的
 * treeSet: 
 * 
 * 哈希表确定元素是否相同
 * 
 * 1. 判断的是两个元素的哈希值是否相同，如果相同 在判断两个对象的内容是否相同
 * 2. 判断哈希值相同，其实判断的是对象hashcode 的方法，判断内容相同 用的是equals 方法
 * 
 * 如果哈希值不同， 是不需要判断equals 的
 * 
 * arrayList 直接测试equals
 */

class Main {
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
        HashSet hash = new HashSet();
        hash.add("heihei");
        hash.add("isam");

        // hash.add(new Person("lisi4", 24));
        // hash.add(new Person("lisi7", 27));
        // hash.add(new Person("lisi1", 21));
        // hash.add(new Person("lisi9", 29));
        // hash.add(new Person("lisi7", 27));

        Iterator it = hash.iterator();

        // while (it.hasNext()) {
        // System.out.println(it.next());
        // }

        ArrayList a1 = new ArrayList();

        a1.add("abc1");
        a1.add("abc2");
        a1.add("abc3");
        a1.add("abc3");
        System.out.println(getSingElemnt(a1));

    }
}