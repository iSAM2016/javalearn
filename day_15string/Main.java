
/*
 * string 类型
 * 字符串是一个特殊的对象
 * 字符串一旦初始化之后， 就不可以改变
 * 
 * ## StringBuffer 字符串缓冲区(容器)
 *  字符串的组成原理就是通过该类实现的
 * 
 * 1. stringBuffer 是可变长度
 * 2. stringBuffer  可以存储不同的类型
 * 3. stringBuffer 最终转换为字符串使用
 * 
 * 
 * 功能
 * 添加： append()
 * 插入： nsert(index data)
 * 删除: delete(start end)  deleteCharAt(int findex) 删除指定位置元素
 * 修改： replace(start end string )  
 * 查找： char charAt(index)
 * int indexof (string)
 * int lastIndexof (string)
 * gethashcode() 获取 
 * 
 * 
 * 
 */

class Main {

    public static void stringDemo2() {
        String s = "abcdcc"; // 常量池中
        String s1 = new String("abc");// 建立两个对象， 一个new 一个字符串对象在堆内存中
        System.out.println(s == s1); // false 比较的是地址
        System.out.println(s.equals(s1)); // true 比较的是值

        /***
         * 常用的方法
         */
        // 1.1 length() 长度
        // indexof(int ch)
        // indexof(int ch f,int fromIndex) 从指定位置查找f

        System.out.println("length" + s.length());
        System.out.println("indexof" + s.indexOf('b'));
        System.out.println("indexof" + s.indexOf('c', 2));

        // 1.2 lastIndexof 字符串在字符串中最后出现的位置
        System.out.println("lastIndexof" + s.lastIndexOf('c'));

        // 1.3 substring 截取
        // 2.1 将字符串变化成(切割) 数组 split
        // 2.2 将字符串变化成字符数组
        // char[] toCharArray();
        // 2.3 将字符串变为字节数组
        // byte[] getBytes()
        // 2.4 将字符串中的字母转化为大小写
        // String toUpperCase()
        // String toLowerCase()
        // 2.5 trim()
        // 2.6 链接 concat
        // 3.1 判断两个字符串内容是否相同 equals
        // 3.2 判断字符串中是否包含指定字符串 contains
        // 3.3 判断字符串是否已指定字符串开头，时候以指定字符串结尾 startsWidth()endsWidth
        // 4.1 compareTo()

    }

    public static void stringbuffer() {
        // 创建缓冲区
        StringBuffer sb = new StringBuffer();
        StringBuffer s1 = sb.append(4);
        System.out.println(sb);
        System.out.println(s1);
        System.out.println(sb == s1);

    }

    public static void main(String[] args) {
        stringDemo2();
        String s = "abcd";
        s = "abc";
        // 字符串 abc 并没有被改写 只是 s 的地址被改变了
        System.out.println(s);

        String s1 = "abcd";

        // 比较的意义： 直接赋值的形式，字符串是存在于变量池中，如果没有就创建，有就使用相同的地址
        System.out.println(s == s1); // true

        stringbuffer();
    }
}