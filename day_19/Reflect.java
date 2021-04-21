///**
// * Java 反射机制是在运行状态中，对于任意一个类（class 文件），都能够知道这个类中所有的属性和方法
// * 对于任意一个对象，都能够调用它任意一个方法和属性
// * 这种能动态获取的信息以及动态调用对象的方法工程称为java 语言的反射机制
// *
// * 动态获取类中的信息，就是java 反射
// * 可以理解为对类的解剖
// *
// * 如果想对指定名称的字节码文件进行加载，并获取其中的内容 并调用
// *
// * 获取字节码的方法
// *
// * 1. Object.getClass()方法
// */
//import persion.Person;
//public class Reflect {
//     public static void main (String[] ages){
//
//     }
//
//     /**
//      * 1.通过Object.getClass 方法
//       想要这种方法 必须要明确具体的类，并创建对象
//       不好
//      */
//    public static void getClassObject (){
//        Person p = new Person();
//        Class pclass = p.getClass();
//
//        Person p1 = new Person();
//        Class class1 = p1.getClass();
//
//        System.out.println(pclass == class1);
//    }
//    /**
//     * 方式二
//     * 任何数据类型都具备一个静态属性，class 来获取对应的class 对象，
//     * 但是还是需要 明确类中的静态成员
//     */
//    public static void getClassObject_2(){
//        Class class2 = Person.class;
//        Class class1 = Person.class;
//        System.out.println(class2 == class1);
//    }
///**
// * 方法三 只要通过给定的字符串 就可以获取该类 更为扩展
// *  可是用class类 中的方法完成
// * 该方法就是forname
// * 但是必须在特定的目录下 bin 和src 下
// *  这种方式只要有名字即可更为方便，扩展性强
// */
//  public static void getClassObject3()throws ClassNotFoundExpetion,InstantiationException,Ill {
//      // 早期： new 时候先根据被new 的类的名称，寻找该类的字节码文件，并加载进内存
//      // 并创建该字节码对象，并接着创建该字节文件对应的Person对象
//      // cn.itcast.bean.Person = new cn.itcast.bean.Person(”小强“， 39);
//
//      /**
//       * 当获取指定名称对应类中的所体现的对象
//       * 而对象初始化使用空参数构造该怎么？
//       * 既然是通过制定的构造函数进行对象初始化
//       * 所以先获得该构造函数，通过字节文件对象即可完成
//       * 是 getConstructor(param)
//       */
//
//
//        String className = "cn.itcast.bean.Persion";
//        // 寻找该名称类文件 并加载进内存，并产生class 文件
//        Class class = Class.forName(className);
//        // 获取构造函数
//        Constructor constructor = class.getConstructor(String.class, int.class);
//        // 通过该构造器对象的newInstance 方法进行对象的初始化
//        Object obj = constructor.newInstance("小明", 30);
//        // 获取公有字段
//        Field field = class.getField("age");
//        // 只获取本类，但包含私有
//        Field fields = class.getDeclareFeld("age");
//        // 对私有字段的访问取消权限检查
//        field.setAccessible(true);
//        Systemout.out.println(fields)
//        Object obj = class.newInstance();
//        field.set(obj, 89);
//        Object o = field.get(obj);
//        System.out.printLn(o);
//
//        // 获取的都是公共方法
//        Method[] methods = class.getMethods(); // 获取的都是公有方法
//        for(Method method: methods){
//            System.out.println(method);
//        }
//
//
//        Method method = class.getMethod("show", null); // 获取空参数一般方法
//        Constructor constructor = class.getConstructor(String.class, int.class);
//        Object obj = constructor.newInstance("小明", 30);
//        method.invoke(obj,null);
//
//        // 获取有参数
//        Method methods = class.getMethod("parammethod", String.class,int.class ); // 获取空参数一般方法
//        methods.invoke(obj,null);
//
//        System.out.println(class);
//  }
//
//}