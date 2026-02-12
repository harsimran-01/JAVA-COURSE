
//private modifier

class private_modifier{
    private String name;
    private_modifier(){
        System.out.println("Private Modifier");
    }

    //getter

    public String getname(){
        return this.name;
    }

    //setter

    public void setname(String name){
        this.name = name;
    }
}

//default  modifier

class default_modifier{
    String name;
    default_modifier(){
        System.out.println("Default Modifier");
    }
    void display(){
        System.out.println("Name = "+ this.name);
    }
}

//Protected Modifier

class protected_modifier{
    protected String name;
    protected_modifier(){
        System.out.println("Protected Modifier");
    }

    protected void display(){
        System.out.println("Name = "+this.name);
    }


}

//Public modifier

class public_modifier{
    public String name;
    public_modifier(){
        System.out.println("Public Modifier");
    }

    public void display(){
        System.out.println("Name = "+this.name);
    }
}



public class access_modifiers {
    public static void main(String[] args) {
        //Accessing Private Modifier 
        private_modifier p1 = new private_modifier();
        // p1.name = "John"; //Error 

        //Accessing using Setter method

        p1.setname("Simmi");
        System.out.println(p1.getname());

        //Accessing Default Modifier

        default_modifier d1 = new default_modifier();
        d1.name = "John";
        d1.display();

        //Accessing Protected Modifier

        protected_modifier p2 = new protected_modifier();
        p2.name = "John";
        p2.display();

        //Accessing Public Modifier

        public_modifier p3 = new public_modifier();
        p3.name = "John";
        p3.display();



        
    }
    
}
