interface Animal{
    void walk();
    

}

interface Herbivore{
    void eatGrass();

}

class dog implements Animal,Herbivore{
    public void walk(){
        System.out.println("Dog is Walking");
    }

    public void eatGrass(){
        System.out.println("Eats Grass");
    }

}
public class interfaces {

    public static void main(String[] args) {
        dog d = new dog();
        d.walk();
        d.eatGrass();
    }
    
}
