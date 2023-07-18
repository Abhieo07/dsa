package Oops;

public class FractionClass {
    static class Fraction{
        int num;
        int den;

        Fraction(int num, int den){
            this.num = num;
            this.den = den;
            simplify();
        }

        public void simplify(){
            int hcf = gcd(num,den);
            num /= hcf;
            den /= hcf;
        }
    }
    static void add(Fraction f1, Fraction f2){
        int numerator = f1.num * f2.den + f1.den * f2.num;
        int denominator = f1.den * f2.den;
        f1.num = numerator;
        f1.den = denominator;
        
    }

    static int gcd(int x, int y){
        if(y == 0)
            return x;
        return gcd(y,x%y);
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(14,21);
        System.out.println(f1.num+"/"+f1.den);
        Fraction f2 = new Fraction(12,15);
        System.out.println(f2.num+"/"+f2.den);
        
        //addition
        add(f1, f2);
        System.out.println(f1.num+"/"+f1.den);
        
        
    }
}
