public class CollegeStudent extends Student{
    // Properties
//    String major;
//    University attendingUni;
    static String major;
    static University attendingUni;

    // Methods
    public CollegeStudent(){
    }
    public CollegeStudent(String nm, int age, double gpa, String m, University uni) {
        super.name = nm;
        super.age = age;
        GPA = gpa;
        major = m;
        attendingUni = uni;
    }

    public void changeMajor(String m){
        major = m;
    }
//    public void print(){
//         super.toString("Majoring in " + major + ".\n" + "Attending " + attendingUni);
//    }
}
