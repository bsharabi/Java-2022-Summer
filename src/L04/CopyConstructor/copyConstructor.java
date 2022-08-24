package L04.CopyConstructor;

import java.util.Date;

public class copyConstructor {
    public static void main(String[] args) {

        _Car myCar = new _Car("Bmw", 100000, "I6", "Red", new Engine(250, 3000, 6, new Turbo(1)), "2", new Date());
        new Engine(250, 3000, 6, new Turbo(1)); // Engine@jd8749  ---> Turbo@jhks87
        System.out.println(myCar);
//        _Car myCar1 = myCar;
//        System.out.println("-------------------------- Before -----------------------------------");
//        System.out.println(myCar);
//        System.out.println(myCar1);
//        myCar1.getEngine().setCc(2000);
//        System.out.println("-------------------------- After -----------------------------------");
//        System.out.println(myCar);
//        System.out.println(myCar1);

        System.out.println("-------------------------- deep constructor -----------------------------------");
        _Car myCar1 = new _Car(myCar);
        System.out.println("-------------------------- Before -----------------------------------");
        System.out.println(myCar);
        System.out.println(myCar1);
        myCar1.getEngine().setCc(5000);
        System.out.println("-------------------------- After -----------------------------------");
        System.out.println(myCar);
        System.out.println(myCar1);




    }
}

class Vehicles {
    private String name;
    private int Price;
    private String type;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Vehicles(String name, int price, String type, String color) {
        this.name = name;
        Price = price;
        this.type = type;
        this.color = color;
    }

    public Vehicles() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "name='" + name + '\'' +
                ", Price=" + Price +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

class _Car extends Vehicles {
    public Engine engine;
    private String model;
    private Date year;

    public _Car(String name, int price, String type, String color, Engine engine, String model, Date year) {
        super(name, price, type, color);
        this.engine = engine;
        this.model = model;
        this.year = year;
    }

    public _Car(Engine engine, String model, Date year) {
        this.engine = engine;
        this.model = model;
        this.year = year;
    }

    public _Car(_Car other) {
        this.engine =new Engine( other.engine);
        this.model = other.model;
        this.year = other.year;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", model='" + model + '\'' +
                ", year=" + year +
                "," + super.toString() +
                '}';
    }
}

class Turbo {
    private int piling;


    public Turbo(int piling) {
        this.piling = piling;
    }

    public Turbo(Turbo other) {
              this.piling = other.piling;

    }

    public int getPiling() {
        return piling;
    }

    public void setPiling(int piling) {
        this.piling = piling;
    }

    @Override
    public String toString() {
        return "Turbo{" +
                "piling=" + piling +
                '}';
    }
}

class Engine {
    private int hp;
    private int cc;
    private int numCylinders;
    public Turbo turbo;

    public Engine(int hp, int cc, int numCylinders, Turbo turbo) {
        this.hp = hp;
        this.cc = cc;
        this.numCylinders = numCylinders;
        this.turbo = turbo;
    }

    public Engine(Engine other) {
        this.hp = other.hp;
        this.cc = other.cc;
        this.numCylinders = other.numCylinders;
        //deep copy
        this.turbo = new Turbo(other.turbo);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getNumCylinders() {
        return numCylinders;
    }

    public void setNumCylinders(int numCylinders) {
        this.numCylinders = numCylinders;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "hp=" + hp +
                ", cc=" + cc +
                ", numCylinders=" + numCylinders +
                ", turbo=" + turbo +
                '}';
    }
}



