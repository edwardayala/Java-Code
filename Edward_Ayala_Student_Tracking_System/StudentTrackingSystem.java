public class StudentTrackingSystem {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        University wesleyan = new University("Texas Wesleyan University, Fort Worth, Texas");
        University rice = new University("Rice University, Houston, Texas");
        University cornell = new University("Cornell University, Ithaca, New York");

        Person bretBirth = new CollegeStudent("Bret Birth", 21, 3.58, "Computer Science", wesleyan);
        System.out.println("\n---------------------- 1 ---------------------");
        bretBirth.print();

        Person erikaSmart = new CollegeStudent("Erika Smart", 25, 2.3, "Biology", rice);
        System.out.println("\n---------------------- 2 ---------------------");
        erikaSmart.print();
        if (erikaSmart instanceof CollegeStudent)
            ((CollegeStudent)erikaSmart).changeMajor("General Business");
        System.out.println("\n---------------------- 3 ---------------------");
        erikaSmart.print();

        Student joMiller = new CollegeStudent("Jo Miller", 19, 2.85, "Liberal Arts", new University());
        System.out.println("\n---------------------- 4 ---------------------");
        joMiller.print();

        CollegeStudent amyZhang = new CollegeStudent("Amy Zhang", 22, 3.95, "Mechanical Engineering", cornell);
        System.out.println("\n---------------------- 5 ---------------------");
        amyZhang.print();

        System.out.println("\n" + Person.getPersonCount() + " Person objects have been created.");
    }
}

