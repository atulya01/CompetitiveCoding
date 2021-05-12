import java.util.*;

public class TestMap {

    public static void main(String[] args) {
        HashMap<String, Employee> empMap = new HashMap<String, Employee>();
        Employee e1 = new Employee("1", "atulya");
        Employee e2 = new Employee("2", "rastogi");
        Employee e3 = new Employee("1", "arpit");

        empMap.put(e1.id, e1);
        empMap.put(e2.id, e2);
        empMap.put(e3.id+e3.name, e3);

        System.out.println(empMap.size());

        for(Map.Entry entry: empMap.entrySet()){
            System.out.println(entry.getKey() + ", "+ ((Employee)entry.getValue()).name);
        }
    }


}

class Employee{
    String id;
    String name;

    Employee(String id, String name){
        this.id = id;
        this.name = name;
    }
}
