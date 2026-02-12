class pen{
    String color;
    String type;
    pen(String color,String type){
        this.color = color;
        this.type = type;
        System.out.println("Parameterized Constructor called");
        System.out.println("Color: "+color+" Type: "+type);
     }
    public void display(){
        System.out.println("This is a "+this.color+" "+this.type+" pen");
    }
}

class Student{
    String name;
    int age;

    Student() {
        System.out.println("Default Constructor called");
    }
    Student(Student s2){
        System.out.println("Copy Constructor called");
        this.name = s2.name;
        this.age = s2.age;
    }
    
    public void printInfo(){
        System.out.println("Name: "+this.name);
        System.out.println("Age: "+this.age);
    }
}

public class OOPS {
    public static void main(String[] args) {
        pen p1 = new pen("Blue","Ballpoint");
        p1.color = "Blue";
        p1.type = "Ballpoint";
        p1.display();


        pen p2 = new pen("Red","Ballpoint");
        p2.color = "Red";
        p2.type = "Gelpoint";
        p2.display();

        Student student1 = new Student();
        student1.name = "John";
        student1.age = 20;
        student1.printInfo();

        Student student2 = new Student(student1);
        student2.printInfo();
        

    }
    

    
}
