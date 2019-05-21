import java.util.Enumeration;
import java.util.Vector;
import java.util.Iterator;

/*
 *  内部是数组结构，是同步的，增删查询度很慢
 */

class VertorDemo {
    public static void main(String[] args) {
        Vector v = new Vector();

        v.addElement("abc1");
        v.addElement("abc2");
        v.addElement("abc3");

        Enumeration en = v.elements();
        while (en.hasMoreElements()) {
            System.out.println("nextelement" + en.nextElement());
        }
        Iterator it = v.iterator();

        while (it.hasNext()) {
            System.out.println("next" + it.next());
        }

    }
}