package L05.Encapsulation;


import static java.lang.System.out;

abstract public class Person implements MyActions {

    protected String name;
    protected String lastName;
    private final String id;
    protected double age;

    //-------------------Setter %% Getter---------------------------
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public double getAge() {
        return age;
    }
    public abstract void b();




    public final void f() {
        out.println("Hello");
    }

    //---------------------------------------------------------------------
    //----------------------------Constructor--------------------------
    public Person(String name, String lastName, String id, double age) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.age = age;
    }

    public Person() {
        this.id="id";
        System.out.println("Hello constructor Person");
    }

    //---------------------------------------------------------------------
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person implements Comparable<Student> {
    private String universityName;
    private int g;

    public Student(String name, String lastName, String id, double age, String universityName) {
        super(name, lastName, id, age);
        this.universityName = universityName;
    }

    @Override
    public void b() {

    }

    public Student() {

        System.out.println("Hello constructor Student");
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String eat() {
        return ("I'm eating now " + getName());
    }

    @Override
    public String drinkUp() {
        return ("I'm drinking now " + getName());
    }

    @Override
    public String practice() {
        return ("I'm practicing now " + getName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "universityName='" + universityName + '\'' +
                '}' + "\n" + super.toString();
    }

    @Override
    public int compareTo(Student o) {
        if(this.g>o.g)
            return  1;
        else if(this.g<o.g)
            return -1;
        else return 0;
    }
}

class Employee extends Person {

    private String workplaceName;

    public String getWorkplaceName() {
        return workplaceName;
    }

    //Error final!!!
//    public void f() {
//
//        out.println("Hello ff");
//    }

    public void setWorkplaceName(String workplaceName) {

        this.workplaceName = workplaceName;
    }

    public Employee(String name, String lastName, String id, double age, String workplaceName) {
        super(name, lastName, id, age);
        this.workplaceName = workplaceName;
    }

    @Override
    public void b() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "workplaceName='" + workplaceName + '\'' +
                '}' + super.toString();
    }

    @Override
    public String eat() {
        return ("I'm eating now " + getName());
    }

    @Override
    public String drinkUp() {
        return ("I'm drinking now " + getName());
    }

    @Override
    public String practice() {
        return ("I'm practicing now " + getName());
    }
}

class Main_ {
    public static void main(String[] args) {

        out.println("_________Student st = new Student()____________");
        Student st = new Student();
        out.println("____________Person st1= new Student()____________");
        Person st1 = new Student();
        out.println("____________Object st2  =    new Student()____________");
        Object st2 = new Student();
        out.println("____________new Student()____________");
        new Student();

        String[] name = {"Barak", "Naor", "Bob", "Alice"};
        String[] lastName = {"Sharabi", "Novo", "Koren", "Dror"};
        Person stud = new Student(name[0], lastName[0], "123456789", 20.5, "Ariel");
        Student stud2 = new Student(name[1], lastName[1], "123456789", 21.5, "Ariel");
        Person emp = new Employee(name[2], lastName[2], "123456789", 22.5, "U_Ariel");
        Employee emp2 = new Employee(name[3], lastName[3], "123456789", 23.5, "U_Ariel");
        emp2.f();
        out.println("-------------------------------------");
        out.println(stud);
        out.println(stud2);
        out.println(stud2.eat());
        out.println("-------------------------------------");

        MyActions[] ar = {
                new Student(name[0], lastName[0], "123456789", 20.5, "Ariel"),
                new Student(name[1], lastName[1], "123456789", 21.5, "Ariel"),
                new Employee(name[2], lastName[2], "123456789", 22.5, "U_Ariel"),
                new Employee(name[3], lastName[3], "123456789", 23.5, "U_Ariel")
        };

        Person[] arPer = {
                new Student(name[0], lastName[0], "123456789", 20.5, "Ariel"),
                new Student(name[1], lastName[1], "123456789", 21.5, "Ariel"),
                new Employee(name[2], lastName[2], "123456789", 22.5, "U_Ariel"),
                new Employee(name[3], lastName[3], "123456789", 23.5, "U_Ariel")
        };
        out.println("-------------------------------------");
        out.println(ar[3]);
        out.println(ar[1]);
        out.println(ar[0].eat());
        out.println("-------------------------------------");

        out.println("-------------------------------------");
        out.println(arPer[3]);
        out.println(arPer[1]);
        out.println(arPer[0].eat());
        out.println("-------------------------------------");


    }
}

interface MyActions {

    public String eat();

    public String drinkUp();

    public String practice();
}
