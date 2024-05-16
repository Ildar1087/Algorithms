package HW1;
import org.example.Employee;
import org.example.HashMap;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
       ArrayList<Integer> list = new ArrayList<>();
       // область применения справочники телефонных номеров
       list.add(1);
       list.add(-6);

       Employee employee1 = new Employee("User1", 54);
       Employee employee2 = new Employee("User2", 33);
       Employee employee3 = new Employee("User3", 21);

        System.out.println(employee1.hashCode());
        System.out.println(employee2.hashCode());
        System.out.println(employee3.hashCode());

        // описание номера телефона и имени, задание количества элементов в справочнике
        HashMap<String,String> hashMap = new HashMap<>(4);
        String oldValue = hashMap.put("+79003124332", "AAAAAAAA");
        oldValue = hashMap.put("+79003124330", "BBBBBBBB");
        oldValue = hashMap.put("+79003124331", "CCCCCCCC");
        oldValue = hashMap.put("+79003124332", "DDDDDDDD");
        oldValue = hashMap.put("+79003124333", "EEEEEEEE");
        oldValue = hashMap.put("+79003124334", "FFFFFFFF");
        oldValue = hashMap.put("+79003124335", "GGGGGGGG");
        oldValue = hashMap.put("+79003124336", "EEEEEEEE");
        oldValue = hashMap.put("+79003124337", "IIIIIIII");
        oldValue = hashMap.put("+79003124338", "JJJJJJJJ");
        oldValue = hashMap.put("+79003124336", "KKKKKKKK");
        oldValue = hashMap.put("+79003124339", "LLLLLLL");
        oldValue = hashMap.put("+79003124340", "ZZZZZZZ");
        oldValue = hashMap.put("+79003124336", "XXXXXXXX");

//        Set<Map.Entry<String,String>> set = HashMap.Bucket;
        System.out.println(hashMap);





    }
}