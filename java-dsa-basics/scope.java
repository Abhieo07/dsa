public class scope {

    static void changeValue(int a) {
        a *= 100;
        System.out.println("Inside function: "+a);
    }

    public static void main(String[] args) {
        // Algebra obj = new Algebra();
        // obj.demo();

        int a = 10;
        System.out.println("a before function call: "+a);
        changeValue(a);
        System.out.println("a after function call: "+a);
    }
}

class Algebra { 

    int a = 10; // member variables
    int b = 5;

    int add() {
        int p = 100; //method level scope
        int q = 20;
        return p + q;
    }

    int sub() {
        return a - b;
    }

    void demo() {
        int r = 10;
        {
            int s = 5; //block level scope
            System.out.println(s);
        }
        {
            int s = 100; //block level scope
            System.out.println(s);
        }
        System.out.println(r);
        //System.out.println(s); //it cannot be accessed outside the block
    }
}