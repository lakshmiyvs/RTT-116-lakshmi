package M303_9;

public abstract class Shape implements AreaCalculation {

    private String name;

    // this is another way of declaring that the children must implement
    // 1) is by using an interface and allowing the child classes to provide the implementation
    // 2) is by using an abstract method that allows child classes to provide the implementation
    // you have 2 different techinque for acomplishing polymorphic behaviour
    public abstract double calculatePerimeter();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
