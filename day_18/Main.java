/* 
 *  Map: 一次添加一对元素，collectio 一次添加一个元素，
 * map 也称为双列集合， collectio 集合称为单列集合
 * map 集合中存储的就是键值对
 * map 集合中必须保证键的唯一性
 * 
 * 常用方法
 * 
 * 1. 添加 value  put(key, value) 如果key值不存在,则返回值是null,但是key值如果存在,则会返回原先被替换掉的value值.(当然,map中的key和value都允许是null).
 * 2. 删除
 *      void clear() 清空map 集合
 *      value remove(key): 根据指定的key 翻出的这个键值对
 * 3. 判断
 *  boolean containsKey(key)
 *  boolean containsValue(value)
 *  boolean isEmpty();
 * 
 * 4. 获取
 * value get(key) 通过键获取值，如果没有该键返回null
 * 当然可以通过返回null, 来判断是否包含指定的jian
 * 
 * entryset
 *  getKey
 *  getValue
 * values
 * 
 * size 获取映射关系
 * 
 * map 常用的子类
 * Hashtable: 内部结构是哈希表 是同步的， 不允许null 作为键，nll 作为值
 * HashMap: 内部结构  是哈希表 不是同步的，允许null 作为键， null 作为值
 * TreeMap: 内部结构是二叉树，不是同步的， 可以对map 集合中的键进行排序
 */

class Main {

    public  static  void  method(Map<Integer,String> map){
        // 学号和姓名
        // 添加元素
        System.out.println("-----");
         System.out.println(map.put(8, "isam2016"));
         System.out.println(map.put(9, "isam2016"));
         System.out.println(map.put(9, "isam2019"));
         System.out.println(map.put(2, "isam2020"));
        System.out.println("-----");
         // 删除
        // System.out.println("remove" + map.remove(2));
        //  keyset 取出map 中所有的元素
         Set<Integer> keyset = map.keySet();
         Iterator<Integer> integerIterator = keyset.iterator();
         while (integerIterator.hasNext()){
             Integer key = integerIterator.next();
             String value = map.get(key);
             System.out.println(value);
         }
        System.out.println(",,,,");
        /**
         *  通过 Map 转成set 就可以迭代
         *  找到另一个方法，entryset
         *  该方法将键和值的映射关系作为对象存储到了set 集合中， 而这个映射关系就是map.Entry 类型
         */
        Set<Map.Entry<Integer, String>> entrySet =  map.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key :" + key + "-" +"value :" + value );
        }

        Collection<String> collection= map.values();
        Iterator iterator1 =  collection.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        method(map);
    }
}