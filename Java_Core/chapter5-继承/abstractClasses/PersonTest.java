package abstractClasses;

public class PersonTest {
    public static void main(String[]args){
        var people=new Person[3];

        people[0]=new Employee("Harry Hacker", 50000, 1989, 10, 1);
        people[1]=new Student("Maria Morris","computer science");
        people[2]=new Employee("Harry Hacker", 50000, 1989, 10, 1);

        for(Person p:people)
            System.out.println(p.getName()+", "+p.getDescription());
        System.out.println("people[1]==people[2]: "+(people[0]==people[2]));
        System.out.println("people[1]==people[2]: "+people[0].equals(people[2]));
    }
}
