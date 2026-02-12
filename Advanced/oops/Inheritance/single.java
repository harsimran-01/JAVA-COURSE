
import oops.encapsulation.Encapsulation;
class Shape{
    String color;
}
class Rectangle extends Shape{

    public Rectangle() {
        color = "Red";
        int x = 10,y = 20;
        System.out.println("Rectangle of Color: "+color+" with length and breadth :"+x+" , "+y+" is displayed");
    }
    
}
public class single {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        // encapsulation.Account account1 = new encapsulation.Account();

    }
    
}
