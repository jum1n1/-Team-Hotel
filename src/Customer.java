import java.util.*;

public class Customer {
    private String name;
    private String phoneNumber;
    private double money;

    public Customer(String name, String phoneNumber, double money) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}}