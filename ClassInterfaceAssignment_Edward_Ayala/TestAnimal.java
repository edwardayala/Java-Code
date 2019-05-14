public class TestAnimal
{
    public static void main(String []args)
    {
        Animal d1 = new Dog(50.2, 101, "German Shepherd");
        Dog d2 = new Dog(40.5, 102, "Lab");
        Animal b1 = new Bird(0.35, 103, "Blue");
        Flyable b2 = new Bird(0.55, 104, "Red");

        if (d1 instanceof Dog)
            ((Dog)d1).speak();

        b1.speak();
        b2.fly();

        try{
            Dog d3 = (Dog)d2.clone();
            Bird b3 = (Bird)((Bird)b1).clone();
            d3.speak();
            b3.speak();
            b3.fly();
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(d2.compareTo(d1));
        System.out.println(((Bird)b2).compareTo(b1));
    }
}

abstract class Animal
{
    protected double weight;
    protected int tag;

    public Animal(double weight, int tag) {
        this.weight = weight;
        this.tag = tag;
    }

    public abstract void speak();
}

class Dog extends Animal implements Comparable<Animal>, Cloneable
{
    private String breed;

    Dog(double wt, int tg, String bd){
        super(wt, tg);
        breed = bd;
    }

    //Implement a compareTo method that returns 1 if the caller object weighs more than the object as parameter;
    //returns 0 if they weigh equally; returns -1 if the caller object weighs less than the object as parameter
    public int compareTo(Animal a)
    {
       return Double.compare(weight, a.weight);
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    public void speak() {
        System.out.println(breed + " dog with a tag of " + tag + " woof!");
    }
}

class Bird extends Animal implements Flyable, Comparable<Animal>, Cloneable
{
    private String color;

    Bird(double weight, int tag, String color) {
        super(weight, tag);
        this.color = color;
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    public void speak() {
        System.out.println(color + " bird with a tag of " + tag + " tweet!");
    }

    @Override
    public void fly() {
        System.out.println(color + " bird with a tag of " + tag + " is flying!");
    }

    @Override
    public int compareTo(Animal o) {
        return Double.compare(weight, o.weight);
    }
}

// Output:

// German Shepherd dog with a tag of 101 woof!
// Blue bird with a tag of 103 tweet!
// Red bird with a tag of 104 is flying!
// Lab dog with a tag of 102 woof!
// Blue bird with a tag of 103 tweet!
// Blue bird with a tag of 103 is flying!
// -1
// 1