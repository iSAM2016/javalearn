package persion;

public class Person {
    public int age;
    private String name;
    
    public Person(int age, String name){
        super();
        this.age = age;
        this.name = name;    
        System.out.println("Person param run " +this.name);
    }
    public Person(){
        super();
    }
    
    public void show(){
        System.out.println(name + "..show run" +age);
    }
     
}