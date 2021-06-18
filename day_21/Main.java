import java.io.*;

/**
 * IO 流 
 * io 流用来处理设备之间的数据传输
 * java 对数据的操作是通过流的方式
 * java 用于操作流的对象都在IO 包中
 * 流按操作数据分为两种： 字节流与字符流
 *      字符流： 字节流读取文字字节数据年，不直接操作而是先查找指定的编码表，获取对应的文字
 *             简单来说： 字节流 + 编码表
 * 流按流向分为： 输入流 输出流
 * 
 * 字节流的 抽象基类，顶层父类
 * 
 * 1. InputStream 
 * 2. OutputStream 
 * 
 * 字符流的两个个顶层父类：
 * 1 Reader
 * 2 Writer
 * 
 * 如果是要操作文字数据，建议先考虑字符流。
 * 并且要将数据从内存写到硬盘上。要使用字符流中的输出流
 *
 * 读
 * FileReader  一个字节 一个字节的读
 *
 * 字符流的缓冲区
 * 缓冲区的出现，提高了对数据的读写效率，
 *  对应的类
 *      BufferedWriter
 *      BufferedReaer
 *  缓冲区要结合流才可以使用
 *  在流的基础上对流的功能进行了增强
 *   
 */
class Main {
    private  static  final  String Line = System.getProperty("line.separator");
    // 创建一个可以往文件中写入字符数据的字符输出流对象
    /**
     * 既然是一个文件中写入文字数据，那么在创建对象时候，就要明确该文件
     * 如果没有文件就自动创建
     * 如果存在 就覆盖
     */
    public static  void writeReader(){
        FileWriter fw=null;
        try {
//             如果 加入true 可以实现文件续写
            fw = new FileWriter("demo.txt", true);
            /**
             * 调用wirter 对象中的write（string） 方法 写入数据
             *
             * 其实该方法执行以后，并不会吸入文件 ，写入了缓存区中
             *
             */
            fw.write("abc");
            /**
             * 进行刷新，将数据直接吸入到目的地中
             */
//            fw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw != null){
                try {
                    fw.close();// close 中固定有flush
                }catch (IOException e){
                    throw new RuntimeException("关闭失败");
                }
            }
        }
    }

    public static  void bufferWrite(){
        try {
            FileWriter fileWriter = new FileWriter("buf.txt");

            // 为了提高写入的效率 使用了字符流的缓冲区
            // 创建了一个字符写入流的缓冲区对象，并和指定要被缓冲的流对象相关联
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("abcedf");

            bufferedWriter.flush();

            // 关闭缓冲区  不必关闭 bufferedWriter
            bufferedWriter.close();
        }catch (Exception e){

        }
    }
    public static  void bufferReaders(){
        try {
            FileReader fileReader = new FileReader("buf.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            // 分行
            while ((line=bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }catch (Exception e){

        }


    }

    public static void main(String[] args) {
       System.out.println("io");
        buffer();

    }
}