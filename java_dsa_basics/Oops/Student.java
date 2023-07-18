package Oops;

// creating a new data type
public class Student{
    String name;
    int rno;
    double percent;
    final String schoolName = "VIT"; //immutable
    private static int numberOfStudent; // to make class dependent instead of object dependent

    // default constructor
    public Student(){}

    public Student(String name, int rno, double percent){
        this.name = name;
        this.rno = rno;
        this.percent = percent;
        numberOfStudent++;
    }

    public static int getNumberOfStudents(){ //to ake this function accessible using class name rather than instance
        return numberOfStudent;
    }

    public int getRno(){ // getter
        return rno;
    }

    public void setRno(int rno){ // setter
        this.rno = rno;
    }
}
