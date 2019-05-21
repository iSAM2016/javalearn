package persion;

public class Persion extends Object {
    public String name;
    private int age;

    public Persion() {
        super();
    }

    public Persion(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    // 重写hashcode
    public int hashCode() {
        System.out.println("........hashCode");
        return name.hashCode() + age;
    }

    // 判断内容
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Persion)) {

        }
        System.out.println(this + "........equals");
        Persion p = (Persion) obj;
        return this.name.equals(p.name) && this.age == p.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}