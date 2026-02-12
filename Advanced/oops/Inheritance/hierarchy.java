class Shape{
    String name;

    public Shape() {
        System.out.println(name);
    }
    
}

class Rectangle extends Shape{
    int Width=10;
    int height = 10;

    public Rectangle() {
        name = "Rectangle";
        System.out.println(name);
    }

    public void display(){
        System.out.println("Area = "+ (Width * height));
    }
    
}

class Triangle extends Shape{
    int size = 10;
    int height = 5;

    public Triangle() {
        name = "Triangle";
        System.out.println(name);
    }

    public void display(){
        System.out.println("Area = "+ (1/2*(size+height)));
    }
    
}
public class hierarchy {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.display();

        Triangle t = new Triangle();
        t.display();
    }
    
}
