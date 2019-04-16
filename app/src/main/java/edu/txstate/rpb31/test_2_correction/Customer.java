package edu.txstate.rpb31.test_2_correction;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String type;
    private double cost;
    private int customerImage;


    public Customer() {

    }

    public Customer(int id, String firstName, String lastName, int age, String type, double cost, int customerImage) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.type = type;
        this.cost = cost;
        this.customerImage = customerImage;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCustomerImage() {
        return customerImage;
    }

    public void setCustomerImage(int customerImage) {
        this.customerImage = customerImage;
    }

    @Override
    public String toString() {

        return this.id + ". " + this.firstName + " " + this.lastName;


    }
}
