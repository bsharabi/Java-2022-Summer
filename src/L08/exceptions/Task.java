package L08.exceptions;


import static java.lang.System.out;

abstract class Person {

    static int count =0;
    private String name;
    private String lastName;
    private String id;
    private double age;


    protected void valid(String str) throws Exception {
        String regularExpression = "^[A-Za-z]{2,15}$";
        if (!str.matches(regularExpression))
            throw new Exception("Error");

    }

    //-------------------Setter %% Getter---------------------------
    public void setName(String name) throws Exception {
        valid(name);
        this.name = name;
    }

    public void setLastName(String lastName) throws Exception {
        valid(lastName);
        this.lastName = lastName;
    }

    public void setAge(double age) throws Exception {
        if (age < 0 || age > 100)
            throw new Exception("Error");
        this.age = age;
    }

    public void setId(String id) throws Exception {
        if (id.length() != 9)
            throw new Exception("Error");
        this.id = id;
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


    //----------------------------Constructor--------------------------
    public Person(String name, String lastName, String id, double age) throws Exception {

        setAge(age);
        setId(id);
        setLastName(lastName);
        setName(name);
        Person.count++;
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

class Student extends Person {
    private String universityName;

    public Student(String name, String lastName, String id, double age, String universityName) throws Exception {
        super(name, lastName, id, age);
        setUniversityName(universityName);
    }


    //-------------------Setter %% Getter---------------------------
    public String getUniversityName() throws Exception {
        valid(universityName);
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "universityName='" + universityName + '\'' +
                '}' + super.toString();
    }
}

public class Task {
    public static void main(String[] args) {
        Student s = null;
        try {
            s = new Student("barak", "Sharabi", "123456789", 15, "ariel");
            out.println(s);
            s=null;
            s = new Student("b", "Sharabi", "123456789", 15, "ariel");
            out.println(s);

        } catch (Exception e) {
            out.println("Error");
            out.println(e);
        }
        out.println(s);
        try {
             s = new Student("b", "Sharabi", "123456789", -1, "ariel");
            out.println(s);

        } catch (Exception e) {
            out.println("Error");
            out.println(e);
        }
        out.println(s);


    }

}
