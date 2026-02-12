
class Shape{

    String shape;
}

class Rectangle extends Shape{
    int length = 10;
    int breadth = 20;

    public Rectangle() {
        shape = "Rectangle";
    }
    
}

class Rectangle_Area extends Rectangle{
    public void display(){
        System.out.println(shape + " " + " of Length = "+length+" and breadth = "+breadth+" has an area = "+(length*breadth));

    }
}


public class Multi_level {
    public static void main(String[] args) {
        Rectangle_Area r = new Rectangle_Area();
        r.display();
    }
    
}
