abstract class Person {
    protected String name;
    protected String address;

    public Person() {}

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public abstract void inputData();

    public abstract void display();

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address;
    }
}
