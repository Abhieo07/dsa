public class classes {
    public static void main(String[] args) {
        Students s1 = new Students();
        s1.roll = 1;
        s1.name = "Rohan";
        System.out.println(s1.roll);
        System.out.println(s1.name);

        Students s2 = new Students();
        s2.roll = 2;
        s2.name = "Aman";
        System.out.println(s2.roll);
        System.out.println(s2.name);
    }
}

class Students {
    int roll;
    String name;
}