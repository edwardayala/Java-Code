import java.util.ArrayList;
import java.util.List;

public class MyArrayList {
    public static void main(String[] args) {
        int [] a = {23, 5, 3, 7, 5, 6, 4, 25, 2, 2, 5, 2, 4};
        ArrayList list = new ArrayList<Integer>();

        for (int i = 0; i < a.length; i++)
        {
            Integer n = new Integer(a[i]);      // Depreciated use Integer n = a[i];
            list.add(n);
        }

        System.out.println("The max integer in the list is : " + findMax(list));

        System.out.println("\nThe integers with duplicates are : ");
        print(list);
        removeDuplicates(list);
        System.out.println("\n\nThe integers after removing duplicates are : ");
        print(list);

        int [] b = {8, 5, 9, 7, 6};
        ArrayList list2 = new ArrayList<>();

        for (int i = 0; i < b.length; i++)
        {
            Integer n = new Integer(b[i]);      // Depreciated use Integer n = b[i];
            list2.add(n);
        }

        System.out.println("\n\nThe integers before union are :");
        System.out.print("List 1: ");
        print(list);
        System.out.print("\nList 2: ");
        print(list2);
        union(list, list2);
        System.out.println("\nThe integers after union are : ");
        print(list);
    }

    public static int findMax(ArrayList<Integer> list)
    {
        int max = list.get(0).intValue();

        for (int i = 0; i < list.size(); i++){
            Integer n = list.get(i);
            if ( n.intValue() > max )
                max = n.intValue();
        }

        return max;
    }

    //This method takes an array list object as input and remove the duplicates in it
    //The items in the array are objects of Integer type (Java APIs). Use the methods defined for class Integer
    public static void removeDuplicates(ArrayList<Integer> list) {

        /*
        ~~~~This method works but prints in wrong order~~~~
        ArrayList tempArr = new ArrayList<Integer>();
        tempArr.ensureCapacity(list.size());
        for (int i = 0; i < list.size(); i++) {
            tempArr.addAll(list);
        }
        list.clear();
        for (int i = 0; i < tempArr.size(); i++) {
            if (!list.contains(tempArr.get(i))){
                list.add((Integer)tempArr.get(i));
            }
        }
        */
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i).intValue() == list.get(j).intValue())
                    list.remove(i);
            }
        }
    }


    //This method takes two array lists as input. The resultant list after union is store into the first list.
    public static void union(ArrayList list1, ArrayList list2)
    {

        /*
        ~~~~This method works but prints in wrong order~~~~
        list1.addAll(list2);
        removeDuplicates(list1);
        removeDuplicates(list1);
        */
        for (int i = 0; i < list2.size(); i++) {
            if (!list1.contains(list2.get(i)))
                list1.add(list2.get(i));
        }
    }

    //This method prints items stored in an arrayList object.
    public static void print(ArrayList<Integer> lst)
    {
        for (int i = 0; i < lst.size(); i++){
            System.out.print(lst.get(i).intValue() + ", ");
        }
    }
}