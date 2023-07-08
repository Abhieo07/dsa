import java.util.ArrayList;
import java.util.Collections;

public class arrayList {
    static void reverseList(ArrayList<Integer> list){
        int i = 0, j = list.size() - 1;

        while(i < j){
            /*
             * int t = a;
             * a = b;
             * b = t;
             */
            Integer temp = Integer.valueOf(list.get(i));
            list.set(i,list.get(j));
            list.set(j,temp);

            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        // //Wrapper class
        // Integer i = Integer.valueOf(4);
        // System.out.println(i);
        // Float f = Float.valueOf("4.5");
        // System.out.println(f);

        ArrayList<Integer> l1 = new ArrayList<>();
        
        //add new element
        l1.add(5); //5
        l1.add(6); //5,6
        l1.add(7); //5,6,7
        l1.add(8); //5,6,7,8

        //get an element at index i
        System.out.println(l1.get(1));

        //print with loop
        // for (int i = 0; i < l1.size(); i++) {
        //     System.out.print(l1.get(i)+" ");
        // }

        // printing array list directly
        System.out.println(l1); // [5,6,7,8]

        // adding element at index i
        l1.add(1,100);
        System.out.println(l1);  // [5,100,6,7,8]

        // modifying element at i
        l1.set(1,10);
        System.out.println(l1); // // [5,10,6,7,8]

        // removing element at i
        l1.remove(1);
        System.out.println(l1); // [5,6,7,8]

        // removing an element
        l1.remove(Integer.valueOf(7)); 
        System.out.println(l1); // [5,6,8]

        // checking if array exists
        boolean ans = l1.contains(Integer.valueOf(8));
        System.out.println(ans);

        // if you don't specify class, you can put anything inside l eg.int,float,etc
        ArrayList l = new ArrayList<>();
        l.add("pqres");
        l.add(1);
        l.add(true);
        System.out.println(l);

        System.out.println("Original list: "+l1);
        reverseList(l1);
        // Collection.reverse(l1);
        System.out.println("Reversed list: "+l1);
        Collections.sort(l1);
        System.out.println("Asscending order: "+l1);
        Collections.sort(l1, Collections.reverseOrder());
        System.out.println("Desc order: "+l1);

    }
}
