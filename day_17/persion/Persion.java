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
    @Override
    public int hashCode() {
        System.out.println("........hashCode");
        return name.hashCode() + age;
    }

    // 判断内容
    @Override
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

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    // treset 比较 自然排序
    // public int compareTo(Object o) {
    // Persion p = (Persion) o;
    // int temp = this.age - p.age;
    // return temp == 0 ? this.name.compareTo(p.name) : temp;
    // }

}