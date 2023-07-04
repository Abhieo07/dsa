import java.util.Scanner;

public class Methods {
    public static void main(String[] args) {

        //METHODS
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter a and b ");
        // int a = sc.nextInt();
        // int b = sc.nextInt();

        // Algebra obj = new Algebra();
        // System.out.println("Sum = "+obj.add(a, b));

        //CONSTRUCTOR
        // Algebra obj = new Algebra();
        // System.out.println("Sum = "+obj.add());
        // System.out.println("Sub = "+obj.sub());
        // System.out.println("Mul = "+obj.mul());

        // Algebra obj2 = new Algebra();
        // System.out.println("Sum = "+obj2.add());
        // System.out.println("Sub = "+obj2.sub());
        // System.out.println("Mul = "+obj2.mul());

        //ACCESS MODIFIERS
        App obj = new App();

        obj.printFromClass();
        System.out.println("Within class: "+obj.str_1);

        App2 obj2 = new App2();
        obj2.printFromOutsideClass();
    }
}

class Algebra {
    
    // int add(int a, int b){
    //     return a + b; // it was for method without class variable or default constructor
    // }

    int a,b;
    Algebra() {
        System.out.println("Construction of algebra class ");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a and b ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        a = x;
        b = y;
    }
    
    int add(){
        return a + b;
    }

    int sub(){
        return a - b;
    }

    int mul() {
        return a * b;
    }
    
}

class App {

    public String str_1 = "I am a public member";

    void printFromClass() {
        System.out.println("Within class: "+str_1);
    }
}

class App2 {
    void printFromOutsideClass() {
        App obj = new App();
        System.out.println("Within package but Outside of class: "+obj.str_1);
    }
}