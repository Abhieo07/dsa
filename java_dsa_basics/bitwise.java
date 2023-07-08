public class bitwise {

    public static void main(String[] args) {
        int p = 9, q = 10;

        System.out.println(p | q); // Bitwise OR 11
        System.out.println(p & q); // Bitwise AND 8
        System.out.println(p ^ q); // Bitwise XOR 3

        System.out.println(p << 1); // Bitwise left shift 18
        System.out.println(p << 2); // Bitwise left shift 36

        System.out.println(q >> 1); // Bitwise Right shift 5
        System.out.println(q >> 2); // Bitwise Right shift 2
    }
}