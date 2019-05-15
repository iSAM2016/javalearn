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
 */
class a {
    public static void main(String[] args) {

    }
}