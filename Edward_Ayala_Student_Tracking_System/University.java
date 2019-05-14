public class University {
    // Properties
    String schoolName;
    public University(){
        super();
        schoolName = "The university name has not been provided.";
    }
    public University(String nm) {
        schoolName = nm.split(",")[0];
    }
}
