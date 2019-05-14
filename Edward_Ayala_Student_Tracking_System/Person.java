public class Person {
    // Properties
    String name;
    int age;
    static int personCount;
    // Methods
    public Person(){
        super();
        personCount++;
    }

    public Person(String nm, int a) {
        name = nm;
        age = a;
        personCount++;
    }
    static int getPersonCount(){
        return personCount;
    }
    public void print(){
        System.out.println(name + " is " + age + " years old. GPA is " + Student.GPA + ".\n"
                                + Student.deansList()
                                + "Major in " + CollegeStudent.major.concat(".\n")
                                + "Attending "+ CollegeStudent.attendingUni.schoolName);
    }
}