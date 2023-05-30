package Practice;

import java.util.ArrayList;
import java.util.Iterator;

public class Collections {
    public static void main(String[] args) {
        ArrayList<Object> listobj1 = new ArrayList<>();
        listobj1.add("Sri Rama");
        listobj1.add(123);
        listobj1.add(true);
        System.out.println(listobj1.size());
        listobj1.remove(0);
        System.out.println( "aftre deleting :" +listobj1.size());
        ArrayList<Object> listObj2 = new ArrayList<>();
        listObj2.add("Ganesh");
        listObj2.add(false);
        listObj2.add(123);
        listObj2.add("Sri Rama");
        listObj2.addAll(listobj1);
        System.out.println("print listobj2 : " +listObj2 );
//        listObj2.removeAll(listobj1);
        System.out.println("array list after delete:" + listObj2);
        listObj2.retainAll(listobj1);
        System.out.println("after retail all : " + listObj2);

        Iterator<Object> itrObj = listObj2.iterator();
        while (itrObj.hasNext()){
            System.out.println(itrObj.next());
        }
    }
}
