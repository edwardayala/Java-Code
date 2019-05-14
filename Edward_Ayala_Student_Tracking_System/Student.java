public class Student extends Person{
    //properties
    static double GPA;
    // Methods
    public Student(){
    }
    public Student(double gpa) {
        GPA = gpa;
    }

    public static String deansList(){
        if (GPA >= 3.5)
            return "Made Dean's honor list.\n";
        else
            return "";
    }
}
